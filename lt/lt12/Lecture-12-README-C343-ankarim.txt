Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 12
10/1/2020

ALGORITHM PARADIGMS
-greedy: looks for the optimal of some criteria, looks at small data at a time and ignores the rest of the data; short-sighted approach
 so have to prove mathematically that it achieves a global optimum
-divide and conquer - orderly behavior, break up problem into sub-problems independent of each other and then solve those problems independently
 and then combine solutions together
--key part: understand how problem can be broken down into sub-problems
--merge sort
-recursion - method that calls a simpler version of itself
-dynamic programming - considers an overall problem and breaks problem into smaller, overlapping sub-problems that are not independent of each other
--used for harder types of problems
--find sub-problems that are solved in part and their solutions would be used
--is not divide and conquer 

RECURSION
-using recursion doesn't imply any other specific algorithm design technique

DYNAMIC PROGRAMMING
-use when natural way of solving problem is exponential
-build on subproblem solutions to solver larger subproblems
-store subproblems' solutions so we trade space for time
-memoization - jot it down
-works by using recursion + memoization