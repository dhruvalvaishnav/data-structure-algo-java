package com.demo;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 17-07-2024
 */
public class DynamicBatches {

    static int ethosVariable = 5;

    public static void main(String[] args) {
        OliOverrideRequestWrapper wrapper = new OliOverrideRequestWrapper();

        // Example setup of oppOliMap and ndrOliList
        setupExampleData(wrapper);

        // Create OLI ID to NetDollarOliOverrideWrapper Map
        Map<String, NetDollarOliOverrideWrapper> idToWrapperMap = createIdToWrapperMap(wrapper.getNdrOliList());

        // Transform oppOliMap to use NetDollarOliOverrideWrapper instead of String IDs
        List<Map<String, List<NetDollarOliOverrideWrapper>>> transformedOppOliMap = transformOppOliMap(wrapper.getOppOliMap(), idToWrapperMap);

        // Process with dynamic batch size
        Map<Integer, List<NetDollarOliOverrideWrapper>> oppBasedMap = wrapper.processWithDynamicBatchSize(transformedOppOliMap);

        List<Map<Integer, List<NetDollarOliOverrideWrapper>>> submaps = new ArrayList<>();
        Iterator<Map.Entry<Integer, List<NetDollarOliOverrideWrapper>>> iterator = oppBasedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map<Integer, List<NetDollarOliOverrideWrapper>> submap = new HashMap<>();
            for (int i = 0; i < ethosVariable && iterator.hasNext(); i++) {
                Map.Entry<Integer, List<NetDollarOliOverrideWrapper>> entry = iterator.next();
                submap.put(entry.getKey(), entry.getValue());
            }
            submaps.add(submap);
        }

        System.out.println("Total number of submaps : " + submaps.size());

        // Process each batch
        for (Map<Integer, List<NetDollarOliOverrideWrapper>> batchEntry : submaps) {
            List<NetDollarOliOverrideWrapper> batch = new ArrayList<>();
            batchEntry.values().forEach(batch::addAll);
            System.out.println("Processing batch with " + batch.size() + " OLI IDs");
            wrapper.processBatch(batch);
        }
    }

    private static void setupExampleData(OliOverrideRequestWrapper wrapper) {
        wrapper.setOppOliMap(createOppOliMap());
        wrapper.setNdrOliList(createNdrOliList());
    }

    private static List<Map<String, List<String>>> createOppOliMap() {
        List<Map<String, List<String>>> oppOliMap = new ArrayList<>();

        Map<String, List<String>> oppMap = new HashMap<>();
        oppMap.put("opp1", generateOliIds(1, 7));
        oppMap.put("opp2", generateOliIds(8, 13));
        oppMap.put("opp3", generateOliIds(14, 20));
        oppMap.put("opp4", generateOliIds(21, 30));
        oppMap.put("opp5", generateOliIds(31, 33));
        oppMap.put("opp6", generateOliIds(34, 47));
        oppMap.put("opp7", generateOliIds(48, 57));
        oppMap.put("opp8", generateOliIds(58, 88));
        oppMap.put("opp9", generateOliIds(89, 149));
        oppMap.put("opp10", generateOliIds(150, 200));

        oppOliMap.add(oppMap);
        return oppOliMap;
    }

    private static List<NetDollarOliOverrideWrapper> createNdrOliList() {
        List<NetDollarOliOverrideWrapper> ndrOliList = new ArrayList<>();

        ndrOliList.addAll(generateNetDollarOliOverrides(1, 200));

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


}

@Getter
@Setter
@Data
@ToString
class OliOverrideRequestWrapper {

    private static final int MAX_BATCH_SIZE = 100;

    private List<Map<String, List<String>>> oppOliMap;
    private List<NetDollarOliOverrideWrapper> ndrOliList;


    public Map<Integer, List<NetDollarOliOverrideWrapper>> processWithDynamicBatchSize(List<Map<String, List<NetDollarOliOverrideWrapper>>> oppOliMap) {
        Map<Integer, List<NetDollarOliOverrideWrapper>> batchMap = new HashMap<>();
        if (oppOliMap != null && !oppOliMap.isEmpty()) {
            int batchIndex = 0;

            // Iterate through oppOliMap to create batches based on oppIds and their oliIds
            for (Map<String, List<NetDollarOliOverrideWrapper>> entry : oppOliMap) {
                for (Map.Entry<String, List<NetDollarOliOverrideWrapper>> oppEntry : entry.entrySet()) {
                    String oppId = oppEntry.getKey();
                    List<NetDollarOliOverrideWrapper> oliList = oppEntry.getValue();

                    List<NetDollarOliOverrideWrapper> currentBatch = new ArrayList<NetDollarOliOverrideWrapper>();

                    // Check if oliIds count is exactly 54 for this oppId
                    if (oliList.size() > MAX_BATCH_SIZE) {
                        // Handle the case where the total number of OLI IDs exceeds MAX_BATCH_SIZE
                        int startIndex = 0;
                        while (startIndex < oliList.size()) {
                            int endIndex = Math.min(startIndex + MAX_BATCH_SIZE, oliList.size());
                            batchMap.put(batchIndex++, oliList.subList(startIndex, endIndex));
                            startIndex = endIndex;
                        }
                    } else {
                        // Split oliIds into smaller batches respecting transaction boundary
                        for (NetDollarOliOverrideWrapper oli : oliList) {
                            currentBatch.add(oli);

                            // Check if currentBatch size reaches MAX_BATCH_SIZE or end of oliIds
                            if (currentBatch.size() == MAX_BATCH_SIZE || oli.equals(oliList.get(oliList.size() - 1))) {
                                batchMap.put(batchIndex++, new ArrayList<>(currentBatch));
                                currentBatch.clear(); // Reset currentBatch
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("OppOliMap is empty or null");
        }
        return batchMap;
    }

    public void processBatch(List<NetDollarOliOverrideWrapper> oliBatch) {
        System.out.println("into processBatch method : " + oliBatch.size());
    }

}

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class NetDollarOliOverrideWrapper {

    private String opportunityLineItemId;
    private Double twelveMonthEntryOverride;
    private Double twelveMonthExitOverride;
    private Boolean arrEligibleOverride;
    private Double arrAverageOverride_CAT;


    public NetDollarOliOverrideWrapper(String opportunityLineItemId) {
        this.opportunityLineItemId = opportunityLineItemId;
    }


}

