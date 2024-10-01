package com.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 27-08-2024
 */
public class DynamicBatches1 {
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
        Map<Integer, List<NetDollarOliOverrideWrapper>> batchMap = generateDynamicBatchMap(transformedOppOliMap, maxOliSizeOnOppty);

        // Print the batch map
        for (Map.Entry<Integer, List<NetDollarOliOverrideWrapper>> entry : batchMap.entrySet()) {
            System.out.println("Batch Index: " + entry.getKey() + " -> " + entry.getValue().size());
        }
    }


    private static void setupExampleData(OliOverrideRequestWrapper wrapper) {
        wrapper.setOppOliMap(createOppOliMap());
        wrapper.setNdrOliList(createNdrOliList());
    }

    private static List<Map<String, List<String>>> createOppOliMap() {
        List<Map<String, List<String>>> oppOliMap = new ArrayList<>();

        Map<String, List<String>> oppMap = new HashMap<>();
        oppMap.put("opp1", generateOliIds(1, 110));
        oppMap.put("opp2", generateOliIds(111, 180));
        oppMap.put("opp3", generateOliIds(181, 290));
        oppMap.put("opp4", generateOliIds(291, 365));
        oppMap.put("opp5", generateOliIds(366, 417));
        oppMap.put("opp6", generateOliIds(418, 429));
        oppMap.put("opp7", generateOliIds(430, 482));
        oppMap.put("opp8", generateOliIds(483, 503));
        oppMap.put("opp9", generateOliIds(504, 510));
        oppMap.put("opp10", generateOliIds(511, 633));
        oppMap.put("opp11", generateOliIds(634, 734));
        oppMap.put("opp12", generateOliIds(735, 811));
        oppMap.put("opp13", generateOliIds(812, 932));
        oppMap.put("opp14", generateOliIds(933, 1066));
        oppMap.put("opp15", generateOliIds(1067, 1136));
        oppMap.put("opp16", generateOliIds(1137, 1273));
        oppMap.put("opp17", generateOliIds(1274, 1385));
        oppMap.put("opp18", generateOliIds(1386, 1505));
        oppMap.put("opp19", generateOliIds(1506, 1637));
        oppMap.put("opp20", generateOliIds(1638, 1715));

        oppOliMap.add(oppMap);
        return oppOliMap;
    }

    private static List<NetDollarOliOverrideWrapper> createNdrOliList() {
        List<NetDollarOliOverrideWrapper> ndrOliList = new ArrayList<>();

        ndrOliList.addAll(generateNetDollarOliOverrides(1, 1715));

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


    public static Map<Integer, List<NetDollarOliOverrideWrapper>> generateDynamicBatchMap(List<Map<String, List<NetDollarOliOverrideWrapper>>> oppOliMap, int maxOliSizeOnOppty) {

        // This map will store the final result
        Map<Integer, List<NetDollarOliOverrideWrapper>> batchMap = new HashMap<>();

        // Temporary storage for batches
        List<NetDollarOliOverrideWrapper> currentBatch = new ArrayList<>();
        int currentBatchSize = 0;
        int batchIndex = 0;

        // Process each opportunity's list of OLIs
        for (Map<String, List<NetDollarOliOverrideWrapper>> opportunity : oppOliMap) {
            for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> entry : opportunity.entrySet()) {
                String oppId = entry.getKey();
                List<NetDollarOliOverrideWrapper> oliList = entry.getValue();

                System.out.println("Processing Opportunity ID: " + oppId + ", Number of OLIs: " + oliList.size());

                // If the list size exceeds the max allowed, handle it as a separate batch
                if (oliList.size() > maxOliSizeOnOppty) {
                    // If the list of OLIs for the current opportunity exceeds the allowed maximum size
                    if (!currentBatch.isEmpty()) {
                        // If there are any OLIs currently in the ongoing batch
                        // Flush the ongoing batch to the batchMap because we need to start a new batch
                        batchMap.put(batchIndex++, new ArrayList<>(currentBatch)); // Add the current batch to the batchMap
                        currentBatch.clear(); // Clear the current batch list for new entries
                        currentBatchSize = 0; // Reset the current batch size
                    }
                    // Log the event of creating a separate batch
                    System.out.println("Generating separate batch for Opportunity ID: " + oppId + ", Number of OLIs: " + oliList.size());
                    // Add the entire OLIs from the current opportunity as a new batch
                    batchMap.put(batchIndex++, new ArrayList<>(oliList));
                } else {
                    // Check if adding this opportunity will exceed the max size
                    if (currentBatchSize + oliList.size() <= maxOliSizeOnOppty) {
                        System.out.println("Adding Opportunity ID: " + oppId + " to current batch. New batch size will be: " + (currentBatchSize + oliList.size()));
                        currentBatch.addAll(oliList);
                        currentBatchSize += oliList.size();
                    } else {
                        if (!currentBatch.isEmpty()) {
                            // Flush current batch before starting a new one
                            batchMap.put(batchIndex++, new ArrayList<>(currentBatch));
                            currentBatch.clear();
                            currentBatchSize = 0;
                        }
                        System.out.println("Creating new batch for Opportunity ID: " + oppId + " with size: " + oliList.size());
                        currentBatch.addAll(oliList);
                        currentBatchSize += oliList.size();
                    }
                }
            }
        }

        // Add any remaining batch
        if (!currentBatch.isEmpty()) {
            batchMap.put(batchIndex++, new ArrayList<>(currentBatch));
        }

        System.out.println("Total number of batches created: " + batchMap.size());
        return batchMap;
    }
}