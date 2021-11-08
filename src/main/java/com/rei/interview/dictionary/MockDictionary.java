package com.rei.interview.dictionary;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MockDictionary implements IDictionary {
    /**
     * @description Returns a Set of String which is converted to their lower case.
     * @param words
     */
    public MockDictionary(final Set<String> words)
    {
        final Set<String> wordsCopy = new HashSet<>();

        for (String word : words)
        {
            wordsCopy.add(word.toLowerCase(Locale.ROOT));
        }

        this.words = wordsCopy;
    }

    private final Set<String> words;

    @Override
    public boolean isValidEnglishWord(String word) {

        return words.contains(word.toLowerCase(Locale.ROOT));
    }
}
