package com.demo.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dhruval Vaishnav Created on 01-10-2024
 */
public class DynamicBatches3 {

    public static void main(String[] args) {
        // Sample input map
        Map<String, List<NetDollarOliOverrideWrapper>> batchMap = new HashMap<>();

        // Sample data
        batchMap.put("006DM00000Saj8dYAB__8", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__7", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__9", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__4", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__3", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__6", new ArrayList<>());
        batchMap.put("006DM00000Saj8dYAB__5", new ArrayList<>());
        batchMap.put("0dbae4d6-4e24-ee11-9cbd-00224820eb7b", new ArrayList<>());
        batchMap.put("0065Y00001bFa3dQAC__1", new ArrayList<>());
        batchMap.put("0065Y00001bFa3dQAC__2", new ArrayList<>());

        // Call the method
        groupBatchesByOpportunity(batchMap);

    }

    private static void groupBatchesByOpportunity(Map<String, List<NetDollarOliOverrideWrapper>> batchMap) {
        Map<String, List<String>> opportunityBatches = new HashMap<>();

        for (String key : batchMap.keySet()) {
            if (key == null) {
                System.err.println("Encountered null batch key. Skipping.");
                continue; // Skip null keys
            }

            String opportunityId = key.contains("__") ? key.substring(0, key.indexOf("__")) : key;
            opportunityBatches.computeIfAbsent(opportunityId, k -> new ArrayList<>()).add(key);
        }
        System.out.println("Original Opportunity Batches: " + opportunityBatches);
        // Format the keys
        getStringListMap(opportunityBatches);
    }

    private static void getStringListMap(Map<String, List<String>> opportunityBatches) {
        Map<String, List<String>> formattedOpportunityBatches = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : opportunityBatches.entrySet()) {
            String opptyId = entry.getKey();
            List<String> originalKeys = entry.getValue();
            List<String> formattedKeys = new ArrayList<>();

            // If there's only one entry, add it without modification
            if (originalKeys.size() == 1) {
                formattedKeys.add(opptyId);
            } else {
                for (int i = 0; i < originalKeys.size(); i++) {
                    formattedKeys.add(opptyId + "__" + (i + 1));
                }
            }

            formattedOpportunityBatches.put(opptyId, formattedKeys);
        }
        System.out.println("Formatted Opportunity Batches: " + formattedOpportunityBatches);
    }

    // Dummy class to simulate the original structure
    static class NetDollarOliOverrideWrapper {
        // Define any properties and methods you need for this class
    }
}
