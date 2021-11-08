package com.rei.interview.findValidEnglishWords;

import com.rei.interview.dictionary.IDictionary;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindValidEnglishWords {
    /**
     * This is the main class, that takes all the dependencies as its argument.
     * @param combinationGenerator
     * @param permutationGenerator
     * @param stringConverterUtil
     * @param dictionary
     */
    public FindValidEnglishWords(
            final CombinationGenerator combinationGenerator,
            final PermutationGenerator permutationGenerator,
            final StringConverterUtil stringConverterUtil,
            final IDictionary dictionary) {
        this.combinationGenerator = combinationGenerator;
        this.permutationGenerator = permutationGenerator;
        this.stringConverterUtil = stringConverterUtil;
        this.dictionary = dictionary;
    }

    /**
     * This method takes the String input and calls the CombinationGenerator methods to
     * generate all the possible combinations of the characters(List of List) from the input word
     * and pass (each List of Character) it to PermutationGenerator method to arrive all possible
     * arrangements of the characters.The output from the permutation generator,is then passed to
     * StringConverterUtil to convert the possible combinations of characters to string, which is then
     * streamed to dictionary to get only the valid words.
     * @param word
     * @return result-List of valid English word String.
     */
    public List<String> findValidEnglishWords(final String word) {
        if (StringUtils.isBlank(word))
            return Collections.EMPTY_LIST;

        final List<String> result = new ArrayList<>();

        final List<List<Character>> combinations = combinationGenerator.findCombinations(word);

        for (List<Character> combination : combinations) {
            List<List<Character>> permutations =
                    permutationGenerator.findPermutations(combination);

            final List<String> words =
                    stringConverterUtil.convertCharacterListsToString(permutations)
                            .stream()
                            .filter(w -> dictionary.isValidEnglishWord(w))
                            .collect(Collectors.toList());

            result.addAll(words);
        }

        return result;
    }

    private final CombinationGenerator combinationGenerator;
    private final PermutationGenerator permutationGenerator;
    private final StringConverterUtil stringConverterUtil;
    private final IDictionary dictionary;
}

