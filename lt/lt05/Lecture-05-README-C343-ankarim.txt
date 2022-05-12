Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture Task 5
9/9/2020

The Decision Tree of an Algorithm (&some other data structures)

LISTS & LIST OPERATIONS
-Lists: a finite, ordered sequence of data items known as elements
---have index with predecessor and successor element
---first element will have an empty predecessor
---ArrayList class implements List<E>
---focus on Array-based List and LinkedList
---LinkedList is made of Nodes, a Node contains a pointer to another element
-----java doesn't use pointers (which are just memory locations of something)
-----look back at pros and cons
---break-even point: the measure that tells us which one is more efficient w/ respect to space
-----n > DE / (P+E)
-------n = number of elements, d is length of array-based list, e is size of data element, p is size of pointer
---performance depends on implementation

MODELS OF COMPUTATION
-helps us idealize what we have as a computing engine
-RAM & PM
---very useful when we need to analyze performance of any data structure or algorithm in this class
-model chosen specifies operations allowed and time and space cost of each operation
-language chosen relies on what the machine language can do or what the assembly language provides as a direct interface to the hardware
-use pseudocode to analyze algorithms, algorithms rely on computation

DECISION TREE OF AN ALGORITHM
-invariant property- array elements are ordered by index
---if one index is smaller than the other then it needs to be less or equal to objecct as index j
---no matter how you modify array, you need to maintain order
-trace algorithm execution (idea behind decision tree of an algorithm)
---show every possible operation to get to answer
---tree tells you how many steps by the height of the tree (in example it'd be 2)
-----when you're doing comparisons (height of tree = big omega (log(n) --> how many elements are in tree)
-shows what we have to follow to get to one possible answer
---follow one complete execution of the algorithm
-not a data structure but a visualization
-use it to find lower bound of sorted array (logn) bc height is log of leaves and leaves are n

3 Questions & Answers
1) Does Java use pointers? Not explicitly, but we do use pointers but call them memory locations
2) Why do we use models of computation? They're helpful when you need to analyze the performance of any dta structure or algorithm
3) Is a decision tree an algorithm? No, it's a visual aid that can help you trace an algorithm execute.