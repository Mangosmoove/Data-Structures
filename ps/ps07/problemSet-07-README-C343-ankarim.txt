Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Problem Set 07
10/13/2020 1:48 p.m.

For the PS07Model class, I had it extend Observable like how we had to do it in Problem Set 5.
I made private variables width, height, d, and e. Although the width and height weren't really
used from the PS07Model class, I kept them in anyway and initialized them in the constructor. For
the dist method, I kept everything the same but then I assigned what position in d meant that
the element would be inserted, deleted, or substituted. I referenced a wikipedia (https://en.wikipedia.org/wiki/Levenshtein_distance)
to determine what values those elemnts would be asigned. At the end of the outermost for loop,
I called setChanged and notifyObservers. For the dLine and eLine methods, I simply returned an
array of the row values. I had getD and getE for testing purposes. For returning the strings,
I had created global variables to hold the Strings passed into the dist method and then returned
those strings depending on which method, aString or bString, was called.

For the PS07View class, I created private variables for the width and height and instantiated both of them
in the constructor. I also instantiated the JFrame variable in the constructor. For drawPoint, I truncated
the rbg values given just in case the values were above or below 255 or 0 respectively. Then I made
an object of type Graphics to draw the pixel. For the clear method, I had another object of type Graphics
be made and then set the color according to the directions and then drew it.

I had the Controller class implement Observer. I created a constructor for Controller and passed in objects
of type PS07Model and PS07View. For the main method, I used code I had in the last problem set to store the
text files into strings. Then I created objects of the PS07Model and PS07View class. I created an object of
the PSO7Controller class and passed in the objects I had made. Then I made the controller object control the
observe method and called on the dist method from the PS07Model class. For the update method, I stored the
two strings using the aString and bString methods in the PS07Model class. Then I drew the first top row line
by using a for loop, where each color was determined by whether or not the character in the string was a vowel,
a consonant, or some sort of punctuation mark. I did the same thing for the left part of the screen but with the
second string. Then, to color in everything else, I went through each character in each row using the eLine method
and having a count variable to keep track of where the character was at index-wise. I called on drawPoint and passed
the proper arguments for given conditions. To color the minimum of of the dLine black, I made a conditional for when
the loop was at the end of its incrementing and then checked for the minimum value and called on drawPoint. I incremented
count so then the next eLine for the next row would be called again.