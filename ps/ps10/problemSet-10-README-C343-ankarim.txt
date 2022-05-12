Arinah Karim, ankarim
CSCI-C 343, Fall 2020
Problem Set 10
11/14/2020, 7:00pm

TASK A
Since we had to start with node E, I went to another node that was
one edge away, node D. D only had one other edge to it so I had to go
to node B. B had 2 edges, so I decided to go to node C because if you went
to node A you'd have to go to nodes F and C and you can't do that without
overlapping over an already-visited node. C had two edges but we already visited
E so I went to node A. Then from A, the only unvisited node was node F so I
visited F.

TASK B
I made an Adjacency List and Adjacency Matrix to help my understanding of the problem.

Adjacency List:
Vertex  Adjacency-List			Adjacency Matrix:
A	[B] -> [C] -> [F]		| A B C D E F
B	[A] -> [C] -> [D]	      --|------------
C	[A] -> [B] -> [E] -> [F]      A |   1 1     1
D	[B] -> [E]		      B | 1   1 1
E	[C] -> [D] -> [F]	      C | 1 1     1 1
F	[A] -> [C] -> [E]	      D |   1     1
				      E |     1 1   1
				      F | 1   1   1
total nodes*: 18 nodes
-------------------------------------------------------
Adjacency List:		    | Adjacency Matrix:
-6 linked lists		    | -6x6 matrix
--6 bytes of memory	    | --1 byte each
---pointer: 4 bytes	    | = 6*6*1 = 36 bytes
---vertex label: 2 bytes    |
-18 nodes*		    |
= 18*6 = 108 bytes	    |
-------------------------------------------------------
The adjacency list would take up more space

TASK C
Adjacency List:		    | Adjacency Matrix:
-6 linked lists		    | -6x6 matrix
--3 bytes of memory	    | --1 byte each
---pointer: 2 bytes	    | = 6*6*1 = 36 bytes
---vertex label: 1 bytes    |
-18 nodes*		    |
= 18*3 = 54 bytes	    |
-------------------------------------------------------
The adjacency list would take up more space

TASK D
The first thing I had to figure out was that I could use a helper method
and not try to put everything into the componentsAndSize method. I decided
that the componentsAndSize method should do the display part and keep track of the
components and that the calculations for how many nodes a component contains should
be in a separate method. I also saw how display would work in the example and I realized
that we had to display the total components at the top but I couldn't figure out how to
without making things messy, so instead, I created a private field variable called
totalComps and then would call on another method I made called displayComps so it would
display the total components in the graph. So after all of that, I wasn't entirely sure 
how to implement this helper method at first, but reading through the discord, we were 
told we could modify the BFS or DFS and that would help. Since I had a better understanding
of BFS, I decided to modify the given BFS method and create a new method called modBFS. In this
method, I modified it so I could keep track of the size with a variable that I called size.
It was easy to keep track of the size by just incrementing it in the while loop and then I 
returned the size at the end. Then I made 3 instances of the class and did some testing.