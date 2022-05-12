Arinah Karim
CSCI-C 343 / Fall 2020
Problem set 11
11/9/2020, 4:58pm 

TASK A
1) Dijkstra's algorithm finds the shortest path from one vertex to every other
   vertex while also finding the shortest path from one vertex to another so in
   the worst case, it's asymptotically as efficient as any algorithm for finding
   the shortest path from some vertex to another vertex.

2)
	  |  4  |  1  |  2  |  3  |  5  |  6
----------|-----|-----|-----|-----|-----|-----
Intial    |  0  |  ∞  |  ∞  |  ∞  |  ∞  | ∞
Process 4 |  0  | 20  |  5  |  ∞  | 11  | 10
Process 3 |  0  | 20  |  5  |  8  | 11  | 10

3)
  create an array D w/ a length of the total number of vertices that'll hold all the shortest paths from vertices to the source
  loop through all the vertices
     set D at each vertex to some large number/infinity
  loop through all the vertices
     set some vertex v to equal the next closest vertex
     mark v as a visited vertex
     if D at v is equal to infinity, break and stop
     go through all the adjacent vertices
        if D at an adj. vertex is greater than D[v] + weight of the edge from v to the adj. vertex
           D[adj. vertex] = D[v] + weight of edge v to adj. vertex

TASK B
1)My code was based on the pseudocode given to us in Lecture 22. I created a private variable dist that
  was an array that would hold the shortest paths from a source vertex. The first loop set every node
  to infinity besides the source node. The second loop found the closest, adjacent vertex to the source node
  so I made a method to do that. Then I marked whatever the adjacent node was as visited. But if the only node
  that was adjacent was equal to MAX_VALUE, that meant that it was unreachable so loop would need to stop. But
  if that didn't happen, I went through another loop and updated the distances for each of the neighbors using
  the relax method and did a print statement of the array at the end.

2)** doesn't work and is commented out
I used the given pseudocode to code dijkstra2 and the class DijkElem. However, I was having a problem at line
231 so if I have time later and before the solution is uploaded, I'll work on it.

TASK C
I followed the given pseudocode and based my variable-naming convention on the pseudocode. I didn't really delineate
from the given pseudocode and its explanations so I don't really know what else I can explain with this method.  