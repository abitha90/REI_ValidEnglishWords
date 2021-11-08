package com.rei.interview.findValidEnglishWords;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationGenerator {
    public List<List<Character>> findPermutations(List<Character> list, IDictionary dict) {
        List<List<Character>> result = new ArrayList<>();
        if (list.size() == 1) {
            return new ArrayList(list);
        }

        for (char c : list) {
            List<List<Character>> subPermutation = findPermutations(list.subList(1, list.size()), dict);
            for (List l : subPermutation) {
                result.add(ListUtils.union(Collections.singletonList(c), l));
            }
        }
        return result;
    }
}
