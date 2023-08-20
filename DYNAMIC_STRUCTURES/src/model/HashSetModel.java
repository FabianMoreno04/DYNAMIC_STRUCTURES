package model;

import java.util.HashSet;
import java.util.Set;

public class HashSetModel {
    public static Set<Set<String>> generatePowerSet(String[] elements) {
        Set<Set<String>> powerSet = new HashSet<>();

        for (int i = 0; i < (1 << elements.length); i++) {
            Set<String> subset = new HashSet<>();
            for (int j = 0; j < elements.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(elements[j]);
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }
}

