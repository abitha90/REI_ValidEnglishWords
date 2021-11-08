# TITLE - Generate Valid English Words From a Given String Using Java

## PROJECT OVERVIEW 
The project aims to generate all the valid English words from a given String using Java, and validate functionality using unit and integration tests.
There is a utility class called Dictionary which has one method isValidEnglishWord, that returns a boolean if a string input is passed. 

## PROJECT DESCRIPTION
The project is based on SOLID (Single Responsibility principle). There are four classes - CombinatorGenerator, Permutation Generator, StringConverterUtil,
Interface Dictionary and the FindValidEnglishWords. Each class has a single responsibility to perform. The main class for this application is FindValidEnglishWords. 
It's dependencies are injected using dependency injection. Also, Dictionary is exposed as Interface, which is implemented by MockDictionary. This, along with use of DI pattern enables future integration with an actual dictionary without major code change. 
Unit Tests are covered for individual classes, and Integration Test are covered for the end-to-end functionality.The code uses recursion to solve the problem.

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
4. IDictionary                    | Interface for Dictionary
5. MockDictionary                 | Mock implementation of IDictionary. 

## TESTING METHODOLOGY
Created Unit Test for each functionality and Integration test for end-to-end functionality. Also, the data stubs are created in a folder for each Test case, which is called and read by the function directly. So, in the future, adding a testcase, is simply adding an extra input,output files in the corresponding naming convention, rather than editing the code.

## FUTURE IMPROVEMENTS
1. Integration with Cucumber for scenario based testing.
2. Reduce memory footprint for combinations and permutations, by exposing results as a Stream.
3. Add Performance tests on latency.
4. Add exception tests. I did not include exception tests, since we are using a Mock Dictionary.
5. Add checkstyle.
     
