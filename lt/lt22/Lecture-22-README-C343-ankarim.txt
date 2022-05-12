Arinah Karim
CSCI-C 343 / Fall 2020
Lecture 22
11/9/2020, 8:13pm

Source-Target shortest path
-given a weight directed graph
-try to minimize weight
--weights aren't necessarily distances
-worst case reasoning:
--may be missing a possible alternative route
-required properties required for a distance explained:
--i: no weights, just number of edges covered
--ii: distance btwn one vertex to another is the same backwards
--iii: if all are set to 1
--this is for a connected graph

Single source
-weighted directed graph w/ a single source, find shortest distance from that one source to all others
-result will be a tree, paths from source to every single vertex
-BFS
--works well as long as weight or edges = 1
-Dijkstra's alg
--no negative weights
--form of BFS, explore any node that is a neighbor
--keep track of weights, keep track of distance (could be some data structure that stores distances for a vertex)
--find min distance for neighbor of a vertex
--edge relaxation - comparing the distances from the connecting edge versus the path to a vertex
--time complexity: could be exploring all the neighbors other than processed ones --> v^2 steps

QUESTIONS
1) Why shouldn't you use negative numbers in Dijkstra's algorithm?
   Because the comparisons would become cyclical and the shortest path calculation would be wrong
2) When can you use BFS in a digraph?
   Only when the weight is 1
3) What's the worst case for finding the shortest path for s-t?
   Reaching each of the vertices because it will look for a better, alternative route.