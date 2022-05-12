Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 9 notes
9/23/2020, 10:36 pm

COMPLETE BINARY TREE
-all levels except bottom filled out completely, and botom level
has all of its nodes filled in from left to right
-only has one possible shape (relationship btwn parent & child node)
-for an array, you don't need any pointers
--but memory requires only specific shape

BINARY TREE TRAVERSALS
-visiting all the nodes of a tree in some order = traversal
-3 recursive ways w/ time complexity of big-theta(n)
--inorder: left sub, root, right sub
--preorder: root, left sub, right sub
--postorder left sub, right sub, root

BINARY SEARCH TREES
-designed for good search operations
-all nodes left of a node will be less than the node
-all nodes right of a node will be greater than the node
-shape depends on order of inserted elements
-search/insertion: big-theta(logn) (avg case), big-theta(n) (worst case)
--why: depends on shape of the tree (so order of elements in a tree)
-building tree: big-theta(nlogn) (avg case), big-theta(n^2) (worst case)
--why: also depends on insertion

PRIORITY QUEUE
-abstract data type
-has a key for each element
-want elements sorted by priority
--find element w/ max priority needs to happen fastest
-increase_key method by setting it with a new key val k --> heaps

HEAP
-implementation of priority queue


Questions:
1) What is an advantage of using binary search trees?
   The values to the left of a node are less than the node and the values to the
   right of the node are greater than the node.
2) How do you do the traversals for binary trees?
   Recursively
3) What is a major flaw of binary search trees
   The way elements are added to tree determine the search/insertion and building of tree time complexity

