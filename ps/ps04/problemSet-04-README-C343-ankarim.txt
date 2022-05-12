Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Problem Set 4
9/22/2020, 11:21 pm

Task A
The first thing that needed to be accomplished with
this was generating a random number for the elements in 
the array. I also had to change the parameters from what
I previously had because the constructor needed an array
to be passed in but the parameters had changed to dimensions.
But no matter what kind of way I was trying to generate a random
number between Integer.MIN_VALUE and Integer.MAX_VALUE, it just
wasn't working. So I went to office hours with Brooklyn Gibbs as
the UI and we spent a lot of time trying things and eventually figured
out another way of doing it. After figuring that out, all that was left
was actually putting it in the GUI which didn't require a lot of work
since all the methods that I needed to use to get data on the array were
in the Int2DArray class from implementing the interface. I went to where
in the example code where the line was drawn and that's where I went through
the entire array and checked for the conditions to determine what color was
the pixel supposed to be. I looked up RGB values online because I don't know
colors well. Then I plotted it on the GUI and it looked really small but I
thought it was satisfactory when I ran the data with smaller dimensions.

Task B
Using compareTo in the first if statement was to check if the node wanting
to be checked was the node that was being looked for. I used recursion when
I was looking for the node because essentially looking for an element in a
tree is a recursive problem. I had to draw it out for each condition. If there
was a node that had a child or children, then I'd use recursion and check the
child node. The last nested else statement was the one that I had a troubling
time with but I got assistance with. When there were 2 children to a node, then
you could check either child because you could search down their paths. Then I
added in more nodes to the tree and added them wherever in the tree and ran some
tests.