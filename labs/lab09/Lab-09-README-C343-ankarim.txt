Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lab 09
10/24/2020

Watching the animation of Counting Sort helped greatly in implementing the method. I followed
the given description of the algorithm and worked on each of those in steps. I created the resulting
sorted array to be returned at the end first and then found the max int value in the array passed in
the parameter. Then I went on to the second stage where I struggled for a bit, but again, the animation
really helped. I kept trying to code that the intermediate at index i would be this value but I ran into
problems by doing that. I then realized that I would need to set the intermediate array's value at i to
the value of a at i and then increment that variable by 1 to prepare the look-up table in the next for
loop where I incremented the value at index i of intermediate to the number before similar to how you
would implement Fibonocci. Moving on to the next stage was troublesome and where I spent most of my time
rewatching the animation. One of the hardest things for me to conceptualize was predecrementing so I
could put the value in the right position. Then I returned the sorted array. The main method needed 5 test
cases so I provided those. Looking for the breaking point was difficult. I initially thought it would be
Integer.MAX_VALUE since it is the largest int value but then I realized it might be lower than that. So
I put in the raw value of Integer.MAX_VALUE and then took out a digit until it stopped throwing a heap
error. Then I went through the decimal points in the number in descending error and eventually found the
max key value.