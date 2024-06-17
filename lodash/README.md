# Letter Occurances

# Tech Used
C# and .Net.

The main code is in the letterOccurances folder of the c_sharp_program folder.

The Unit Test code is in the UnitTestProject1 folder of the c_sharp_program folder.

# Purpose

Output statistics on how often each letter is present in the JavaScript/TypeScript files of the repository, in decreasing order.

# Lessons learned 
Use of dictionary for storing letter counts is initialized with all lowercase letters from 'a' to 'z'. This pre-initialization ensures that each letter has an entry, avoiding potential issues with missing keys during the counting process.

The code retrieves all files in the specified directory and its subdirectories, filtering only JavaScript (.js) and TypeScript (.ts) files.

The use of a try-catch block to handle FileNotFoundException ensures that the program can handle missing files gracefully. 

# Unit testing
A test case to test if the letter occurances for each letter is correct.
