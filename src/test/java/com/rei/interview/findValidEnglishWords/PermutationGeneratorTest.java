package com.rei.interview.findValidEnglishWords;

import com.rei.interview.dictionary.IDictionary;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;

class PermutationGeneratorTest {

    private PermutationGenerator subject;
    private IDictionary dict = null;

    @BeforeEach
    void setUp() {
        subject = new PermutationGenerator();
    }

    @Test
    void findPermutations_ForSingleLetter() {
        List<Character> input = new ArrayList<>();
        input.add('W');
        final char[][] expected = {
                {'W'}
        };
        final List<List<Character>> actual = subject.findPermutations(input);
        Assertions.assertEquals(getSetOfList(expected),actual);
    }

    @Test
    void findPermutations_ForMoreThanOneLetter()
    {
        final char[] input =  {'W','I','N'};
        final char[][] expected = new char [][]{
                {'W','I','N'},{'W','N','I'},{'I','W','N'},{'I','N','W'},{'N','I','W'}, {'N','W','I'}};
        final List<List<Character>> actual = subject.findPermutations(getCharList(input));
        MatcherAssert.assertThat(new HashSet<List<Character>>(actual), equalTo(getSetOfList(expected)));
    }

    private Set<List<Character>> getSetOfList(final char[][] charArray)
    {
        final Set<List<Character>> result = new HashSet<>();
        for(int i = 0; i< charArray.length; i++)
        {
            result.add(getCharList(charArray[i]));
        }
        return result;
    }

    private List<Character> getCharList(final char[] charArray)
    {
        final List<Character> charList = new ArrayList<>();
        for(char c: charArray)
        {
            charList.add(c);
        }
        return charList;
    }
}