# TITLE - Generate Valid English Words From a Given String Using Java

## PROJECT DESCRIPTION
The project aims to generate all the valid English words from a given String using Java, and validate functionality using unit and integration tests.
There is an utility class called Dictionary which has one method isValidEnglishWord, that returns a boolean if a string input is passed. 

##PROJECT OVERVIEW
The project is based on SOLID (Single Responsibilty) as the project structure has four class - CombinatorGenerator, Permutation Generator, StringConverterUtil,
Interface Dictionary and the FindValidEnglishWords. Each class has a single responsibility to perform. Also the project is created with dependency injection technique, which aims to 
remove dependency by sepearting the usage from the creation of object and thereby improving flexibility. Also each class has its variables within the class, thereby maintianing the state of the variables.

Dictionary(Mocked) is implemented as Interface, which enables future implementation of the actual dictionary without major code change. Unit Test are covered for major functionalities
and Integration Test are covered for the end-to-end functionality.

##TOOLS/PACKAGES USED
1. Maven - For Build Management
2. Git - For Version Control
3. JUnit, Hamcrest - For Test
4. Json - Input/Output/Dictionary Data
5. Apache Commons/ListUtils - For Joining the list

##RESULTS ACHIEVED
Class Name                        |      Intention
-----------------------------------------------------------------------------------------------------------------
1. CombinationGenerator           | To derive at all possible selection of letters,for the given input string 
2. PermutationGenerator           | To derive at all possible arrangement of letters, for the derived combinations
3. StringConverterUtil            | To convert the given character array to String and to generate list of strings
4. IDictionary                    | 

     
