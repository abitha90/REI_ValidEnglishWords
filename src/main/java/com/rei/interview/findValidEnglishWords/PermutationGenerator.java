package com.rei.interview.findValidEnglishWords;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationGenerator {
    /**
     * The method takes List of Character input generated from CombinationGenerator and finds
     * all possible arrangements of the list and creates List of List of character arrangements.
     * @param list
     * @return result-List of List of all possible arrangements of Character
     */
    public List<List<Character>> findPermutations(List<Character> list) {
        List<List<Character>> result = new ArrayList<>();
        if (list.size() == 1) {
            final List<Character> l = new ArrayList(list);
            result.add(l);
            return result;
        }

        for (int i =0; i < list.size(); i++) {
            final List<Character> sublist = new ArrayList<>(list);
            sublist.remove(list.get(i));
            List<List<Character>> subPermutation = findPermutations(sublist);
            for (List<Character> l : subPermutation) {
                result.add(ListUtils.union(Collections.singletonList(list.get(i)), l));
            }
        }
        return result;
    }
}
