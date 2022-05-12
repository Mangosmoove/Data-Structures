Arinah Karim
CSCI-C 343 / Fall 2020
Lecture 23
11/10/2020, 3:43pm

OPTIMAL SUBSTRUCTURE
-want to solve:
--could be using algorithm with greedy choice property
---globally optimal solution can be arrived by making a locally optimal (greedy) choice
---doesn't mean it necessarily provides a global optimal solution
--if a problem exhibits a property that is the analogous if the algorithm itself
---optimal substructure- if we are solving subsets of the same problem and find an optimal solution
   and then use those solutions to solve the entire problem, then we're taking advantage of the optimal
   substructure of the problem itself
----which means if you have an optimal solution to a problem that can be built on the top of optimal solutions to sub-problems
----see that property in graphs

MINIMUM-COST SPANNING TREES(MSTs)    
-a graph
-want to connect all the vertices/nodes in the graph
-want to find if tree is a spanning tree
--on the top of the graph itself, we would like to be able to select just those edges that reach all the vertices and therefore connects
  all the vertices
-weights don't matter in spanning tree, only care about is reaching all the nodes
-no cycles bc it's a tree


QUESTIONS
1) What is an optimal substructure?
   Using sub problems' solutions to solve an entire problem
2) How do you maintain an AVL tree?
   Use rotations
3) What are some good usages of MST?
   Things that have a lot of networking



