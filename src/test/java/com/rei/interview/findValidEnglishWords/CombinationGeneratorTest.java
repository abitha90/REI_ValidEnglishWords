package com.rei.interview.findValidEnglishWords;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;


class CombinationGeneratorTest {

    @BeforeEach
    void beforeEach()
    {
        subject = new CombinationGenerator();
    }

    @Test
    void findCombinations_ForSingleLetter() {
        final String input = "W";
        final char[][] expected = new char[][]{
                {'W'},
                {}
        };

        final List<List<Character>> actual = subject.findCombinations(input);
        final Set<Map<Character,Integer>> actualSetMap = getCharacterCounts(actual);
        final Set<Map<Character,Integer>> expectedSetMap = getCharacterCounts(getCharListList(expected));
        MatcherAssert.assertThat(actualSetMap, equalTo(expectedSetMap));
    }

    @Test
    void findCombinations_ForMoreThanOneLetter()
    {
        final String input = "WING";
        final char[][] expected = new char[][]{
                {'W'},{'I'},{'N'},{'G'},
                {'W','I'},{'W','N'},{'W','G'},{'I','N'},{'I','G'},{'N','G'},
                {'W','I','N'},{'W','N','G'},{'I','N','G'},{'W','I','G'},
                {'W','I','N','G'},{}
        };
        final List<List<Character>> actual = subject.findCombinations(input);
        final Set<Map<Character,Integer>> actualSetMap = getCharacterCounts(actual);
        final Set<Map<Character,Integer>> expectedSetMap = getCharacterCounts(getCharListList(expected));
        MatcherAssert.assertThat(actualSetMap, equalTo(expectedSetMap));
    }

    @Test
    void findCombinations_ForDuplicateLetter()
    {
        final String input = "FEEL";
        final char[][] expected = new char[][]{
                {'F'},{'E'},{'E'},{'L'},
                {'F','E'},{'F','E'},{'F','L'},{'E','E'},{'E','L'},{'F','L'},{'E','L'},
                {'F','E','E'},{'F','E','L'},{'E','E','L'},
                {'F','E','E','L'},
                {}
        };
       final List<List<Character>> actual = subject.findCombinations(input);
       final Set<Map<Character,Integer>> actualSetMap = getCharacterCounts(actual);
       final Set<Map<Character,Integer>> expectedSetMap = getCharacterCounts(getCharListList(expected));
       MatcherAssert.assertThat(actualSetMap,equalTo(expectedSetMap));
    }

    @Test
    void findCombinations_Null(){
        final List<List<Character>> actual = subject.findCombinations((String) null);
        MatcherAssert.assertThat(actual, is(empty()));
    }

    @Test
    void findCombinations_Empty(){
        final List<List<Character>> actual = subject.findCombinations("");
        MatcherAssert.assertThat(actual, is(empty()));
    }

    private Set<Map<Character, Integer>> getCharacterCounts(List<List<Character>> actual)
    {
       Set<Map<Character, Integer>> result = new HashSet<>();

       for(List list : actual)
       {
           final Map<Character, Integer> map = new HashMap<>();
           for(int i = 0; i <list.size(); i++)
           {
               if(map.containsKey(list.get(i)))
               {
                   map.put((Character) list.get(i),map.get(list.get(i))+1);
               }
               else
               {
                   map.put((Character) list.get(i),1);
               }
           }

           result.add(map);
       }

       return result;
    }

    private List<List<Character>> getCharListList(final char[][] chars)
    {
        final List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            result.add(getCharList(chars[i]));
        }

        return result;
    }

    private List<Character> getCharList(final char[] chars)
    {
        final List<Character> result = new ArrayList<>();
        for (char c : chars)
        {
            result.add(c);
        }

        return result;
    }

    private CombinationGenerator subject;
}