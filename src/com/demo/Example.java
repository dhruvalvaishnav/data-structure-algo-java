package com.demo;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

// Define the Request class
class Request {
    private String opportunityId;
    private String id;

    // Constructor
    public Request(String opportunityId, String id) {
        this.opportunityId = opportunityId;
        this.id = id;
    }

    // Getters
    public String getOpportunityId() { return opportunityId; }
    public String getId() { return id; }
}

// Main class to demonstrate the example
public class Example {
    public static void main(String[] args) {
        // Sample list of Request objects
        List<Request> requestList = List.of(
                new Request("op1", "opg1"),
                new Request("op1", "opg2"),
                new Request("op2", "opg3"),
                new Request("op3", "opg4"),
                new Request("op3", "opg5"),
                new Request("op3", "opg6"),
                new Request("op3", "opg5") // Duplicate id for testing
        );

        // Create the map
        Map<String, Set<String>> result = requestList.stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getOpportunityId()) && Objects.nonNull(x.getId()))
                .collect(Collectors.toMap(
                        Request::getOpportunityId, // Key mapper
                        x -> Set.of(x.getId()),     // Value mapper (initial set with one id)
                        (set1, set2) -> {
                            // Combine two sets
                            Set<String> combined = new java.util.HashSet<>(set1);
                            combined.addAll(set2);
                            return combined;
                        }
                ));

        // Print the result
        System.out.println(result);
    }
}
