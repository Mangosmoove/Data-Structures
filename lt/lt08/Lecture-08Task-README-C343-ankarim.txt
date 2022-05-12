Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture-Task 8
9/19/2020, 6:37p.m.

Lecture 8 Task
my answer:
Bubble sort's invariant is the inner loop. It only makes swaps with the element in front of it and when it reaches a point where
the element in front is bigger then that element takes over. Insertion sort has to compare all the way back to the first element
and the positions of those elements aren't set in place.

professors answers:
it's true that the first j elements are sorted but they aren't in their final place
last element from j to n are sorted, but property is stronger bc it has an additional property:
they're already in the final place that they're supposed to be
--if you need top 10 highest numbers, then only have to run outer loop 10 times

-to improve insertion sort use binary search to make O(nogn) comparisons but still O(n^2) for insertions and shifts operations