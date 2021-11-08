package com.rei.interview.findValidEnglishWords;

import java.util.ArrayList;
import java.util.List;

public class StringConverterUtil {
    public List<String> convertCharacterListsToString(final List<List<Character>> charList) {
        final List<String> result = new ArrayList<>();

        for (List<Character> l : charList) {
            result.add(convertCharacterListToString(l));
        }

        return result;
    }

    public String convertCharacterListToString(final List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : charList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
