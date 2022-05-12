Arinah Karim, ankarim
Lecture 8 notes
CSCI-C 343 / Fall 2020
9/19/2020, 6:37pm

BUBBLE SORT
-input: unsorted array, output: same array but sorted
-invariant: the lsst elements from j to n-1 in the array are sorted
-picks an element that is largest and keeps swapping with it until it
 finds an element that is bigger than it
---when it finds a bigger element, it makes that element the one to be swapped
---the inner loop

INTRODUCTION TO TREES
-root node - has no parent nodes
-depth - length of the path from root of tree to m
-height - one more than the depth of the deepest node in the tree
-edges - represent parent-child relationship; provide any location for node in the tree
--form paths
-binary trees
--nodes at most have 2 children
--is made of sub-trees
--level count at root is 0, then so forth +1
--leaf nodes - have no children
--internal nodes - nodes that have children
--full binary trees & complete binary trees
---full binary trees - every node is either an internal node w/ 2 non-empty children or a leaf node
---complete binary tree - all levels are completely full except possible depth - 1 (last row of nodes)

BINARY SEARCH TREES
-guarantees big O(h) {h is height of the tree}
-full binary tree theorem
--some amount of space for internal nodes
---need to provide structure to the trees
--some different amount for leaf nodes for storing the actual data
--says that the number of leaves in a non-empty full binary tree is one more than the number of internal nodes
--also the number of emtpy subtrees in a non-empty binary tree is one more than the number of nodes in the tree

QUESTIONS:
1) How does Bubble sort work?
--it chooses the first element and swaps it if it is bigger than the next element and when it isn't, then that number
  starts to get swapped. Then it repeats again
2) Why is a binary tree called have the word "binary" in the name?
--each node can have at most 2 children
3) Why is it good that binary search trees are guaranteed O(h)?
--if you continuously add on nodes to the point where its some number of 2^h where h is the height of the tree, then it
  would be good that it would take O(h) time for any operation because it could take more if it were some other implemented
  way of doing an operation in some sort of different data structure