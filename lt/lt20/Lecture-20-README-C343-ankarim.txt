Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 20
10/31/2020, 1:30 pm

CLOSED HASHING
-looks for soonest position in the table that isn't occupied by an element
-probe and keep looking for new positions in sequence

GRAPHS
-extremely versatile
-garbage collecting - BFS
-edges = moves, nodes = states
-|G|= cardinality of graph, how many vertices are in G
GRAPH TERMINOLOGY
-vertices(V)- a set of vertices, is either there or not, don't have to be ordered
-edges(E)- set of edges
-graph(G)- consists of (V, E)
-different graphs can be buit on the same set of vertices
-Graph search
--finding a path from a node to another node
-sparse- not a lot of edges
-dense- too many edges
-parallel edges- 2 edges that connect the same pair of vertices
-to represent asymptotic time it takes for an algorithm to visit all the nodes in a graph: O(f|V|,|E|)
-subgraph- a subset of a graph's edges that constitutes a graph
-path- sequence of vertices connected by edges, simple if all vertices on the path are distinct
--cycle- a path whose first and last vertices are the same
--length of path/cycle is the number of its edges 
-connected- a graph is connected if there is a path from every vertex to every other vertex
-acyclic graph is a graph w/ no cycles

QUESTIONS
1. What does || represent?
   Cardinality
2. How do you properly note the time complexity of an algorithm that wants to visit every node in the graph?
   O(f|V|, |E|)
3. How can a path be cyclic?
   The first and last vertices are the same 