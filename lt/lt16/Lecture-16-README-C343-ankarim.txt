Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 16
10/15/2020, 10:40a.m.

SORTING ALGORITHMS (that run in big-theta nlogn)
-merge sort
--divide and conquer algorithm
--take each input and divide total number of inputs we have into two separate subsets
--start w/ unsorted list at the top
---sort two elements at a time
---set a pointer to the element if it needs to be swapped, pointer then goes to next element in the list
--always have to treat subsets as pairs
--don't need random access to elements in the list
--total steps required at every level: big-Oh(n)
---number of steps performed depends on every element we perform at merging elements
--total cost will always be big-theta(nlogn)
--can't sort in-place, need some sort of temporary storage

COMPARISON ALGORITHMS
-takes big-omega(nlogn), so in general big-omega(n)
--takes at least that many steps to read n elements
-only interested in lower bound

COMPARISON MODEL OF COMPUTATION FOR SORTING
-every possible answer in sorting algorithms >= n!
--because of permutations
-height of sorting algorithm search tree >= logn! which is greater than nlogn
-no sorting algorithm can possibly be faster than big-omega(nlogn) in worst case because 
the tree of all possible comparison outcomes has height h >= log(n!)
 