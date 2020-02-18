Post development comments:
- To prove the correctness of the code I have unit tested intensively and added a multitude of edge cases test
also all the test cases provided in the examples are included in the unit tests.

- The exercise mentions handling a large input. To demonstrate that this code han handle larger input, I have included
the unit test that contains a paragraph from the book "Don Quijote de La Mancha" which was provided in the examples.

- I was confused by the term "fancy puctuation", I assumed that anything other than comas or dots are fancy punctuation.
But then I noticed that one of the provided examples inputs "  //wont won't won't" and the outcome is [won't wont]. So
based on that i deduced/assumed that the program is spected to take into account the words the words that are next to
"fancy punctuation", but just will not display the punctuation in the output.

- Initially I did not understand the meaning of "Ties may be broken arbitrarily". Latter while adding test cases I 
discovered that inputs that have an equal of counts of words on top 3. I then assumed that this what actually a Tie was.
The program is accepting the default behaviour to deal with ties. I have added unit tests to replicate a Tie scenario.

- For the cases with less than 3 in the output the array will variate in size. The minimum possible length of the output
array is zero(empty array) and the maximum 3.

- The requirements said "Avoid any non-standard library.". So i did not use any library or framework for production code
at all. Every tool used comes with java. The only external libraries added to this project are the ones that enable
 me unit test, an that is a must because I can't write code without testing it. So for unit testing, I am using junit 
 and assertJ. Both this two libraries are well know and widely accepted in the industry. 

- One final comment, I added as many unit tests that I thought were relevant and also I tried to the best of my ability
to solve the challenge using a Java functional style approach. The version of Java used for this program is 1.8, so this
will work correctly in any machine that is using java 1.8 or higher.
