package com.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TR_EPM_TEST_StateMapFilter {
    public static void main(String[] args) {
        List<State> states = Arrays.asList(

                new State("Andhra Pradesh", 1000000L),

                new State("Gujarat", 2000000L),

                new State("Assam", 12000L)

        );

        Map<String, Long> map = states.stream()
                .filter(s -> s.getName().startsWith("A"))
                .collect(Collectors.toMap(s -> s.getName().toUpperCase(), State::getPopulation));

        for (Map.Entry<String, Long> o : map.entrySet()) {
            System.out.println(o.getKey() + " " + o.getValue());
        }

    }


}

class State {
    private String name;
    private Long population;

    public State(String name, Long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}