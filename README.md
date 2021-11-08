# TITLE - Generate Valid English Words From a Given String Using Java

## PROJECT OVERVIEW 
The project aims to generate all the valid English words from a given String using Java, and validate functionality using unit and integration tests.
There is an utility class called Dictionary which has one method isValidEnglishWord, that returns a boolean if a string input is passed. 

## PROJECT DESCRIPTION
The project is based on SOLID (Single Responsibilty principle). There are four classes - CombinatorGenerator, Permutation Generator, StringConverterUtil,
Interface Dictionary and the FindValidEnglishWords. Each class has a single responsibility to perform. The main class for this application is FindValidEnglishWords. It's dependencies are injected using dependency injection. Also, Dictionary is exposed as Interface, which is implemented by MockDictionary. This, along with use of DI pattern enables future integration with an actual dictionary without major code change. Unit Tests are covered for individual classes, and Integration Test are covered for the end-to-end functionality.

## ASSUMPTIONS
1. Length of the input String is within the maximum limit.


## TOOLS/PACKAGES USED
1. Maven - For Build Management
2. Git - For Version Control
3. JUnit, Hamcrest - For Testing
4. Json - Storing Input/Output/Dictionary Test stubs
5. Apache Commons/ListUtils - Collection utils

## CLASS DEFINITION
Class Name                        |      Intention
-----------------------------------------------------------------------------------------------------------------
1. CombinationGenerator           | To derive at all possible selection of letters,for the given input string 
2. PermutationGenerator           | To derive at all possible arrangement of letters, for the derived combinations
3. StringConverterUtil            | To convert the given character array to String and to generate list of strings
4. IDictionary                    | Mocked Interface

## FUTURE IMPROVEMENTS
1. Integrartion with Cucumber for scenario based testing.
2. Reduce memory footprint for combinations and permutations, by exposing results as a Stream.
3. Add Performance tests on latency.
4. Add exception tests. I did not include exception tests, since we are using a Mock Dictionary.
5. Add JavaDocs 
     
