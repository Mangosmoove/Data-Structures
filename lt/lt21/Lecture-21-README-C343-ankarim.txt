Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 21
11/5/2020, 8:25am

DFS
-add all edges leading out of node to a stack
-total cost: big-theta(cardinalities of V + E)
-backtrack if necessary

TOPOLOGICAL ORDER
-list vertices in DAG in linear order

EDGE CLASSIFICATION
-tree edges: any edge that is part of the tree built by the DFS algorithm (or more generally, the "forest", i.e. all the trees found by DFS)
-forward edges: any edge that leads from a node to one of its non-child descendant nodes
-backward or back edges: any edge that leads from a node to one if its ancestor nodes
-cross edges: any edge that leads from a node to a node that is neither a descendant nor an ancestor node

SHORTEST PATH ALGORITHMS
-source-target
--weights
--worst case performance:  the same as the algorithm for finding the shortest directed paths from a source vertex to every other vertex

QUESTIONS
1. What is the cost of DFS?
   big-theta(|V|+|E|)
2. What is the goal of topological ordering?
   To list the vertices of a DAG in a linear order
3. What is the worst case performance of s-t shortest path?
   The same as the algorithm for finding the shortest directed paths from a source vertex to every other vertex