Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 19
10/29/2020, 9:04am

INTRO TO SEARCH PROBLEM
-exact-match query- a search for the record(s) whose key value matches a specified key value
-range query- a search for all records whose key value falls w/in a specified range of key values
-jump search, interpolation search

HASHING
-takes O(1) for inserting, search, and deleting
-hashing- a function that maps or transforms keys into indices
--also involves collision-resolution process (multiple entries from different keys from same index you gotta figure out what to do with them_
--exact-match query
-direct access table- an array of items where the key kj is the index into the array and the information Ij is the value stored in the array
--uses a lot of memory, need to allocate memory for each specified key
---avoid occupying memory for unused entries in the array (actual hashing)
--keys are the indices
---pre-hashing- devise a funciton that maps all key values to non-negative integers
--no key collisions
--easy to make table fast

HASH FUNCTIONS
-come back to this later

LECTURE TASK
7 -> 18
2
3 -> 14 -> 25
1 -> 12 => 1332
11

QUESTIONS
1. What's the difference between exact-match and range queries?
   Exact-match query finds a item from a specified key and range queries give a variety of items based on a range of keys
2. What operations take O(1) time for hash tables?
   Inserting, deleting, searching
3. What are the disadvantages to hasing?
   It takes up a lot of space and the keys are the indices