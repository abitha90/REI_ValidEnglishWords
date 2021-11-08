package com.rei.interview.findValidEnglishWords;

import java.util.ArrayList;
import java.util.List;

public class StringConverterUtil {
    /** @description Returns a List of String for each List of Character input.
     * @param charList
     * @return result - List of String
     */
    public List<String> convertCharacterListsToString(final List<List<Character>> charList) {
        final List<String> result = new ArrayList<>();

        for (List<Character> l : charList) {
            result.add(convertCharacterListToString(l));
        }

        return result;
    }

    /**
     * This method is called when the input is a single list, mostly in the case of String
     * with single letter.
     * @param charList- List of Character
     * @return  String
     */
    public String convertCharacterListToString(final List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : charList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
