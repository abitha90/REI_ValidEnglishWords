package com.rei.interview.findValidEnglishWords;

import com.rei.interview.dictionary.MockDictionary;
import org.apache.commons.collections4.ListUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class FindValidEnglishWordsIntegrationTest {

    @ParameterizedTest
    @MethodSource("provideInputsForFindValidEnglishWords")
    void findValidEnglishWords(final String wordFilePath, final String dictFilePath, final String expectedFilePath) {
        final MockDictionary mockDictionary = createDictionary(dictFilePath);
        final Set<String> expected = readExpected(expectedFilePath);
        final String word = readString(wordFilePath);
        final FindValidEnglishWords subject =
                new FindValidEnglishWords(
                        new CombinationGenerator(), new PermutationGenerator(),
                        new StringConverterUtil(), mockDictionary);

        Set<String> actual = new HashSet<>(subject.findValidEnglishWords(word));

        assertThat(actual, equalTo(expected));
    }

    private String readString(final String wordFilePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(wordFilePath))
        {
            return (String) jsonParser.parse(fileReader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private Set<String> readExpected(String expectedFilePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(expectedFilePath))
        {
            final JSONArray array = (JSONArray) jsonParser.parse(fileReader);
            final Set<String> words = new HashSet<>();
            array.forEach(w -> words.add((String) w));
            return words;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private MockDictionary createDictionary(final String dictFilePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(dictFilePath))
        {
            final JSONArray array = (JSONArray) jsonParser.parse(fileReader);
            final Set<String> words = new HashSet<>();
            array.forEach(w -> words.add((String) w));

            return new MockDictionary(words);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> provideInputsForFindValidEnglishWords()
    {
        File testcasesDir = new File("src/test/data");

        List<Arguments> argumentsList = new ArrayList<>();

        for (File testcaseDir : testcasesDir.listFiles())
        {
            Arguments arguments = Arguments.of(
                    testcaseDir.getAbsolutePath() + "/input.json",
                    testcaseDir.getAbsolutePath() + "/dictionary.json",
                    testcaseDir.getAbsolutePath() + "/expected.json");

            argumentsList.add(arguments);
        }

        Arguments[] arguments = new Arguments[argumentsList.size()];
        argumentsList.toArray(arguments);

        return Stream.of(arguments);
    }
}