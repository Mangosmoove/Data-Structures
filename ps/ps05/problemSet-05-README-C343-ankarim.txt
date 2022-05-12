Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
PS-05
11/14/2020, 3:10 p.m.

New Write-up:
From the problem sets and labs after this, I realized my mistakes I made whe doing this problem set.
PS05Model
So I realized that I had an error in my bubble sort algorithm in my sortRow method so I fixed that.

PS05Controller
I removed all the JFrame related code and added an instance of the PS05Controller class so it would
use Observable right. 

PS05View
I added in the JFrame code I took out from the PS05Controller class and put it in the constructor
of this class. I also made private variables for the width and the height to set up the dimensions
for the JFrame. I removed repaint and removed ActionListener because I no longer had a use for
them. Instead of hard-coding values into the clear method, I used width and height instead. I also
fixed the problem I was having with the green value in the drawPoint method so I fixed that as well.

1. Yes; after both of the sorting methods are called you can see them in ascending order in both rows and columns.

2. Yes; after both of the sorting methods are called you can see them in ascending order in both rows and columns.

3. For both of my sorting methods, it would take O(n^2) time
   because the for loops run on n time but bubble sort takes n^2 amount
   of time.

4. sortArray1 method - 30174566200 nanoseconds
   sortArray2 method - 30116332700 nanoseconds

5. They didn't differ substantially.


Write-up

PS05Model
I started by creating field variables for the width and height for a given array.
For the randomize method, I went through the width and height and bounded it to be
between -255 to 255 and then assigned that to the proper position in the array.
For the sortColumns method I went through the width of the array because the width
represents the columns, then I went through the height of the array to store the row
values in a 1D array. Then I used bubble sort to sort the 1D array that I made (I referenced
pseudocode from here (https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm).
After bubble sort, I assigned the column in the array to the sorted 1D array values. The
same happened with sortRows method except I switched the placements of height and width.
I tested the sorting methods with a main method to make sure it did create random numbers
in the proper range and then sorted them properly.

PS05View
For the constructor, I created a frame and got the array from the Model class except I did this
by using the getArray method in the Controller class. Then for drawPoint, I did a series of if
statements to make sure the proper color was assigned. In the clear method, I went through
each individual pixel and changed it to black that way. In paintComponent I called on drawPoint
to give color to each of the pixels.

PS05Controller
For the main method, I created instances of the Model and View class. I wasn't sure if the program
would run with or without the instance of the Controller class but I ran out of time to test that
because I procrasinated.