Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 10
9/26/2020, 11:38 p.m.

PRIORITY QUEUE
-a structure that has to satisfy a certain number of operations in a certain way
-use in situations where you need to make decisions
-any queue where we need to order elements by priority
-typically implemented as a HEAP

HEAP
-"this is the relationship between elements in an array"
-implemented as an array but can be visualized as a COMPLETE binary tree (doesn't have to be full)
-max will be the first element in the "array"
-as long as the parent node is bigger than the children we all gucci
-has some array-tree duality properties (look back at notes)
--parent node of any element at i is i/2
-invariant property of max heap:
--each node has a value(key) that is greater than any of its child nodes
-invariant property of min heap:
--same for max heap
-only partially ordered
-insert element at the end of array
--need to check max heap and min heap properties (check parent nodes until parent is not larger/smaller than node)
-big-theta(logn) in worst case to insert an element into right position

HEAPSORT
-based on Heap
-build heap and constantly remove max value and restore heap property until heap is empty
-takes big-theta nlognn time with operations, building Heap takes big-theta n
--total cost: big-theta nlogn

LECTURE 10 TASK
1) for a max heap, it would take big-theta 1 because the max key would be the first element. Finding the minimum would
   take logn time because the element would have to be smaller than the parent node which would make the time for finding
   it reduced by 2 
2) it would be the same as above because you're not removing a value
3) both; if size n is big then we need to look at different elements in order to find our k's that we are looking for

QUESTIONS:
1) When should you use a priority queue?
   When you need to have things sorted based on a certain characteristic
2) What is the invariant property for heaps
   That depends on whether it's a min-heap or a max-heap. For a min-heap, the parent must be greater than the child node(s) and
   it's the other way around for a max-heap
3) Why is heapsort a nice structure to use?
   It's total cost of time is big-theta nlogn   
