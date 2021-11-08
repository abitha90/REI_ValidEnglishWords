package com.rei.interview.findValidEnglishWords;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CombinationGenerator {

    public List<List<Character>> findCombinations(final String word)
    {
        final List<Character> charList = new ArrayList<>();
        for (char c : word.toCharArray())
        {
            charList.add(c);
        }

        return findCombinations(charList);
    }

    private List<List<Character>> findCombinations(List<Character> charList) {

        if (charList == null || charList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        if (charList.size() == 1) {
            return getCombinationList(charList.get(0));
        }

        List<List<Character>> l1 = getCombinationList(charList.get(0));
        List<List<Character>> l2 = findCombinations(charList.subList(1, charList.size()));

        return union(l1, l2);
    }

    private List<List<Character>> getCombinationList(final Character c)
    {
        final List<List<Character>> result = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        charList.add(c);
        result.add(charList);
        result.add(Collections.EMPTY_LIST);
        return result;
    }

    private List<List<Character>> union(List<List<Character>> list1, List<List<Character>> list2) {
        List<List<Character>> finalResult = new ArrayList<>();
        for (List<Character> l1 : list1) {
            for (List<Character> l2 : list2) {
                List<Character> newList = ListUtils.union(l1, l2);
                finalResult.add(newList);
            }
        }

        return finalResult;
    }

}
