Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
PS-03
9/14/2020, 10:56 p.m.

Task A
1) For the "static array" version, there is no best, average, and worst case. They will all run
   in the same amount of iterations because you are replacing a value with null without having
   to traverse through the entire array. The "dynamic array" is different though because you do
   need to traverse through the array and shift elements properly aftering deletion. The worst case
   would be when the first element wanting to be delted is the first element because all elements
   would have to be shifted to the left. The best case is when the element wanted to be deleted is
   the last element in the array because nothing would need to be shifted. Therefore the average case
   would be if the element wanting to be deleted was the middle element and would have to shift only
   half of the array elements to the left.
3) The array would contain null values if the "static array" was used. I looked up how much space this
   would take and for every null value, 4 bytes on a 32-bit system or 8 bytes on a 64-bit system would
   be used. Although I only created a small array of integers, if the array were bigger, null would consume
   more space when you could just implement the "dynamic array" method and save space. If I wanted to see the
   contents of an array, I wouldn't care about the null values for they don't have a purpose of being in my array
   if they were set to null. It just makes sense to have a "dynamic array" for space and also because it just
   logically makes sense to do so so you wouldn't need to check for null values that exist in your array.

Task B
1)
mvToPos(2)
delete()
We move to the index of where the number 15 occurs and then delete the element

2)
   a) n > 40/3
      math behind answer: n > 20*8/(4+8)
   b) n > 10
      math behind answer: n > 30*2/(4+2)
   c) n > 6
      math behind answer: n > 30*1/(4+1)
   d) n > 320/9
      math behind answer: n > 40*32/(4+32)
   The linked list will use less space that is less than whatever answer was achieved so for a, the linked list would
   use less space if the n < 40/3

Task C
1. 2, log3(n), log2(n), n^2/3, 20n, 4n^2, 3^n, n!
2. 
   a)c1n
      O(n): f(n) = c1n which is <= 3c1*n for n0 = 1 and c= c1
      Ω(n): g(n) = 1/4(c1n) which is >= 1/4c1n for n0 = 1 and c = c1
   b)c2n^3 + c3
      O(n^3): f(n) = cn^3 which is <= c2n^3 + c3 where n0 = 1 and c = c2 + c3
      Ω(n^3): g(n) = cn^3 which is >= c2n^3 + c3 where n0 = 1 and c = c2
   c)c4nlog2n + c5n
      O(nlogn): f(n) = c(nlogn) <= 4nlogn + c5n where n0 = 1 and c = c4 + c5
      Ω(nlogn): g(n) = c(nlogn) >= 4nlogn + c5n where n0 = 1 and c = c4 + c5
   d)c6(2^n) + c7n^6
      O(2^n): f(n) = c2^n <= c6(2^n) where n0 = 1 and c = c6 + c7
      Ω(2^n): g(n) = c2^n >= c6(2^n) where n0 = 1 and c = c6 + c7