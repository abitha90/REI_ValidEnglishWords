package com.rei.interview.findValidEnglishWords;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationGenerator {
    /**
     * @description Returns a List Of List of Character from the input String by calling the same method recursively.
     * This method returns an empty list when the input string is empty and returns the same string as list of list
     * with the input String.
     * @param String word
     * @return List of List of all possible combination of Characters
     */

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

    /**
     * @description Returns the List of List of characters for the given Character if the String input is a Single
     * Letter
     * @param c
     * @return result -input character as List of List.
     */
    private List<List<Character>> getCombinationList(final Character c)
    {
        final List<List<Character>> result = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        charList.add(c);
        result.add(charList);
        result.add(Collections.EMPTY_LIST);
        return result;
    }

    /**
     * @description Returns List of List of Character after joining the two input list list1 and list2
     * @param list1
     * @param list2
     * @return finalResult-List of List of Characters after joining the two input lists.
     */

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
