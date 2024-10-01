package com.demo;

import lombok.extern.java.Log;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 20-09-2024
 */
public class DynamicBatches2 {
    public static void main(String[] args) {
        // Maximum number of OLIs per batch
        int maxOliSizeOnOppty = 100;

        // Create sample data
        OliOverrideRequestWrapper wrapper = new OliOverrideRequestWrapper();

        // Example setup of oppOliMap and ndrOliList
        setupExampleData(wrapper);

        // Create OLI ID to NetDollarOliOverrideWrapper Map
        Map<String, NetDollarOliOverrideWrapper> idToWrapperMap = createIdToWrapperMap(wrapper.getNdrOliList());

        // Transform oppOliMap to use NetDollarOliOverrideWrapper instead of String IDs
        List<Map<String, List<NetDollarOliOverrideWrapper>>> transformedOppOliMap = transformOppOliMap(wrapper.getOppOliMap(), idToWrapperMap);

        // print transformedOppOliMap
        for (Map<String, List<NetDollarOliOverrideWrapper>> entry : transformedOppOliMap) {
            for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> oppEntry : entry.entrySet()) {
                String oppId = oppEntry.getKey();
                List<NetDollarOliOverrideWrapper> oliList = oppEntry.getValue();
                System.out.println("Opportunity ID: " + oppId + ", Number of OLIs: " + oliList.size());
            }
        }

        // Generate dynamic batch map
        Map<String, List<NetDollarOliOverrideWrapper>> batchMap = generateDynamicBatchMap(transformedOppOliMap, maxOliSizeOnOppty);

        // Print the batch map
        for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> entry : batchMap.entrySet()) {
            System.out.println("Batch Index: " + entry.getKey() + " -> " + entry.getValue().size());
        }

        Map<String, List<String>> opportunityBatches = groupBatchesByOpportunity(batchMap);
        System.out.println("Opportunity batches: {}" + opportunityBatches);

        processOpportunityBatches(opportunityBatches, batchMap);

    }


    private static void setupExampleData(OliOverrideRequestWrapper wrapper) {
        Map<Integer, Integer> oppOliCount = new HashMap<>();
        oppOliCount.put(1, 5);
        oppOliCount.put(2, 10);
        oppOliCount.put(3, 190);
        oppOliCount.put(4, 10);
        oppOliCount.put(5, 151);

        wrapper.setOppOliMap(createOppOliMap(oppOliCount));

        int totalOliCount = oppOliCount.values().stream().mapToInt(Integer::intValue).sum();
        wrapper.setNdrOliList(createNdrOliList(totalOliCount));
    }

    private static List<Map<String, List<String>>> createOppOliMap(Map<Integer, Integer> oppOliCount) {
        List<Map<String, List<String>>> oppOliMap = new ArrayList<>();
        Map<String, List<String>> oppMap = new HashMap<>();

        int currentOliId = 1; // Start generating oli IDs from 1

        for (Map.Entry<Integer, Integer> entry : oppOliCount.entrySet()) {
            int oppNumber = entry.getKey();
            int oliCount = entry.getValue();

            List<String> oliIds = generateOliIds(currentOliId, currentOliId + oliCount - 1);
            oppMap.put("opp" + oppNumber, oliIds);

            currentOliId += oliCount; // Update currentOliId for the next opportunity
        }

        oppOliMap.add(oppMap);
        return oppOliMap;
    }

    private static List<NetDollarOliOverrideWrapper> createNdrOliList(int totalOliCount) {
        List<NetDollarOliOverrideWrapper> ndrOliList = new ArrayList<>();
        ndrOliList.addAll(generateNetDollarOliOverrides(1, totalOliCount));
        return ndrOliList;
    }

    private static List<NetDollarOliOverrideWrapper> generateNetDollarOliOverrides(int start, int end) {
        List<NetDollarOliOverrideWrapper> oliOverrides = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            oliOverrides.add(new NetDollarOliOverrideWrapper("oli" + i, 100.0, 200.0, true, 300.0));
        }
        return oliOverrides;
    }

    private static List<String> generateOliIds(int start, int count) {
        List<String> oliIds = new ArrayList<>();
        for (int i = start; i <= count; i++) {
            oliIds.add("oli" + i);
        }
        return oliIds;
    }

    private static Map<String, NetDollarOliOverrideWrapper> createIdToWrapperMap(List<NetDollarOliOverrideWrapper> ndrOliOverrideList) {
        return ndrOliOverrideList.stream().filter(Objects::nonNull).collect(Collectors.toMap(NetDollarOliOverrideWrapper::getOpportunityLineItemId, wrapper -> wrapper, (existing, replacement) -> existing // Handle duplicate IDs gracefully
        ));
    }

    private static List<Map<String, List<NetDollarOliOverrideWrapper>>> transformOppOliMap(List<Map<String, List<String>>> oppOliMap, Map<String, NetDollarOliOverrideWrapper> idToWrapperMap) {
        return oppOliMap.stream().map(x -> transformMapEntry(x, idToWrapperMap)).collect(Collectors.toList());
    }

    private static Map<String, List<NetDollarOliOverrideWrapper>> transformMapEntry(Map<String, List<String>> originalMap, Map<String, NetDollarOliOverrideWrapper> idToWrapperMap) {
        if (originalMap == null) {
            return Collections.emptyMap();
        }

        return originalMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> transformIdListToWrapperList(entry.getValue(), idToWrapperMap)));
    }

    private static List<NetDollarOliOverrideWrapper> transformIdListToWrapperList(List<String> idList, Map<String, NetDollarOliOverrideWrapper> idToWrapperMap) {
        if (idList == null) {
            return Collections.emptyList();
        }

        return idList.stream().filter(Objects::nonNull).map(id -> {
            NetDollarOliOverrideWrapper wrapper = idToWrapperMap.get(id);
            if (wrapper == null) {
                System.err.println("Warning: No NetDollarOliOverrideWrapper found for OLI ID: " + id);
            }
            return wrapper;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

//    private static Map<String, List<NetDollarOliOverrideWrapper>> generateDynamicBatchMap(List<Map<String, List<NetDollarOliOverrideWrapper>>> oppOliMap, int maxOliSizeOnOppty) {
//        // Maps to store batches
//        Map<String, List<NetDollarOliOverrideWrapper>> finalBatchMap = new HashMap<>();
//        int batchCount = 0;
//
//        // Iterate over each opportunity in oppOliMap
//        for (Map<String, List<NetDollarOliOverrideWrapper>> opportunityMap : oppOliMap) {
//            for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> entry : opportunityMap.entrySet()) {
//                String opportunityId = entry.getKey();
//                List<NetDollarOliOverrideWrapper> olis = entry.getValue();
//                int oliCount = olis.size();
//
//                if (oliCount > maxOliSizeOnOppty) {
//                    // Split OLIs into multiple batches
//                    int remaining = oliCount;
//                    int startIndex = 0;
//
//                    while (remaining > 0) {
//                        int currentBatchSize = Math.min(maxOliSizeOnOppty, remaining);
//                        List<NetDollarOliOverrideWrapper> currentBatch = olis.subList(startIndex, startIndex + currentBatchSize);
//                        finalBatchMap.put(opportunityId + "-" + (++batchCount), currentBatch);
//                        remaining -= currentBatchSize;
//                        startIndex += currentBatchSize;
//                    }
//                    System.out.println("Opportunity ID " + opportunityId + " has been split into " + batchCount + " batches");
//                } else {
//                    // Add all OLIs to a single batch
//                    finalBatchMap.put(opportunityId, olis);
//                }
//            }
//        }
//
//        System.out.println("Total number of batches created: " + finalBatchMap.size());
//
//        // Publish the batches
//        publishBatches(finalBatchMap);
//
//        return finalBatchMap;
//    }
//
//    public static void publishBatches(Map<String, List<NetDollarOliOverrideWrapper>> batchMap) {
//        // Use a map to track batches by opportunity ID
//        Map<String, List<String>> opportunityBatches = new HashMap<>();
//
//        // Group batch keys by opportunity ID
//        for (String key : batchMap.keySet()) {
//            String opportunityId = key.contains("-") ? key.substring(0, key.indexOf('-')) : key;
//            opportunityBatches.computeIfAbsent(opportunityId, k -> new ArrayList<>()).add(key);
//        }
//
//        // Publish the batches, introducing a wait for batches of the same opportunity
//        for (Map.Entry<String, List<String>> entry : opportunityBatches.entrySet()) {
//            String opportunityId = entry.getKey();
//            List<String> keysForOpportunity = entry.getValue();
//
//            // Check if there are multiple batches for this opportunity
//            if (keysForOpportunity.size() > 1) {
//                for (String batchKey : keysForOpportunity) {
//                    List<NetDollarOliOverrideWrapper> batch = batchMap.get(batchKey);
//                    try {
//                        System.out.println("Waiting for 5 seconds before publishing the next batch for opportunity: " + opportunityId);
//                        TimeUnit.SECONDS.sleep(5); // Wait for 5 seconds
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt(); // Restore interrupted status
//                        System.err.println("Interrupted while waiting: " + e.getMessage());
//                    }
//                    System.out.println("Publishing batch: " + batchKey + " with " + batch.size() + " OLIs");
//                }
//            } else {
//                // NORMAL CASE: Publish the batch without waiting
//                List<NetDollarOliOverrideWrapper> batch = batchMap.get(keysForOpportunity.get(0));
//                System.out.println("Publishing batch: " + keysForOpportunity.get(0) + " with " + batch.size() + " OLIs");
//            }
//        }
//    }

    public static Map<String, List<NetDollarOliOverrideWrapper>> generateDynamicBatchMap(List<Map<String, List<NetDollarOliOverrideWrapper>>> oppOliMap, int maxOliSizeOnOppty) {
        Map<String, List<NetDollarOliOverrideWrapper>> batchMap = new HashMap<String, List<NetDollarOliOverrideWrapper>>();

        if (oppOliMap != null && !oppOliMap.isEmpty()) {
            // Iterate over each opportunity in oppOliMap
            for (Map<String, List<NetDollarOliOverrideWrapper>> opportunityMap : oppOliMap) {
                for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> entry : opportunityMap.entrySet()) {
                    int batchCount = 0;
                    String opportunityId = entry.getKey();
                    List<NetDollarOliOverrideWrapper> olis = entry.getValue();
                    int oliCount = olis.size();

                    if (oliCount > maxOliSizeOnOppty) {
                        // Split OLIs into multiple batches if the count exceeds the maxOliSizeOnOppty
                        int remaining = oliCount;
                        int startIndex = 0;
                        while (remaining > 0) {
                            int currentBatchSize = Math.min(maxOliSizeOnOppty, remaining);
                            List<NetDollarOliOverrideWrapper> currentBatch = olis.subList(startIndex, startIndex + currentBatchSize);
                            batchMap.put(opportunityId + "__" + (++batchCount), currentBatch);
                            remaining -= currentBatchSize;
                            startIndex += currentBatchSize;
                        }
                        System.out.println("Opportunity Id " + opportunityId + " has been split into " + batchCount + " batches");
                    } else {
                        // Add all OLIs to a single batch
                        batchMap.put(opportunityId, olis);
                    }
                }
            }
        } else {
            System.out.println("OppOliMap is empty or null");
        }
        System.out.println("Total number of batches created: {}" + batchMap.size());
        return batchMap;
    }


    private static Map<String, List<String>> groupBatchesByOpportunity(Map<String, List<NetDollarOliOverrideWrapper>> batchMap) {
        Map<String, List<String>> opportunityBatches = new HashMap<>();
        for (String key : batchMap.keySet()) {
            if (key == null) {
                System.out.println("Encountered null batch key. Skipping.");
                continue; // Skip null keys
            }
            String opportunityId = key.contains("__") ? key.substring(0, key.indexOf("__")) : key;
            opportunityBatches.computeIfAbsent(opportunityId, k -> new ArrayList<String>()).add(key);
        }
        return opportunityBatches;
    }


    private static void processOpportunityBatches(Map<String, List<String>> opportunityBatches, Map<String, List<NetDollarOliOverrideWrapper>> batchMap) {
        System.out.println("Processing opportunity batches...");
        for (Map.Entry<String, List<String>> entry : opportunityBatches.entrySet()) {
            String opportunityId = entry.getKey();
            List<String> keysForOpportunity = entry.getValue();

            try {
                if (keysForOpportunity.size() > 1) {
                    processMultipleBatches(keysForOpportunity, batchMap, opportunityId);
                } else {
                    processSingleBatch(keysForOpportunity.get(0), batchMap);
                }
            } catch (Exception e) {
                System.out.println("Error processing opportunity batches: {}" + e.getMessage());
            }
        }
        System.out.println("Processing opportunity batches completed.");
    }

    private static void processMultipleBatches(List<String> keysForOpportunity, Map<String, List<NetDollarOliOverrideWrapper>> batchMap, String opportunityId) {
        System.out.println("Processing multiple batches for opportunity: " + opportunityId + " with " + keysForOpportunity.size() + " batches to process");
        int waitTimeForLargeOliRecords = 5;
        Set<String> processedOpptyKeys = new HashSet<>(); // To keep track of seen prefixes

        for (String batchKey : keysForOpportunity) {
            List<NetDollarOliOverrideWrapper> batch = batchMap.get(batchKey);
            if (batch == null) {
                System.out.println("Batch for key " + batchKey + " is null. Skipping.");
                continue; // Skip null batches
            }

            // Extract the opportunity prefix (before the "__")
            String opportunityPrefix = batchKey.split("__")[0];

            // Check if the opportunity prefix has been processed before
            if (processedOpptyKeys.contains(opportunityPrefix)) {
                System.out.println("Waiting for " + waitTimeForLargeOliRecords + " seconds before processing the next batch for opportunity: " + opportunityId);
                try {
                    TimeUnit.SECONDS.sleep(waitTimeForLargeOliRecords); // Wait
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted while waiting: " + e.getMessage());
                }
            }

            // Add the current opportunity prefix to the set of processed keys
            processedOpptyKeys.add(opportunityPrefix);

            System.out.println("Publishing batch: " + batchKey + " with " + batch.size() + " OLIs");
        }
    }

    private static void processSingleBatch(String batchKey, Map<String, List<NetDollarOliOverrideWrapper>> batchMap) {
        System.out.println("Processing single batch for opportunity: {}" + batchKey);
        List<NetDollarOliOverrideWrapper> batch = batchMap.get(batchKey);
        if (batch == null) {
            System.out.println("Batch for key {} is null. Skipping." + batchKey);
            return; // Skip null batches
        }
        System.out.println("Processing single batch: {} with {} OLIs" + batchKey + batch.size());
    }


}

