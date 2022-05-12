Arinah Karim
CSCI-C 343 / Fall 2020
Lab 11
11/6/2020, 6:23 pm

I implemented the better pseudocode that has a run time of O(V^3).
To code this, I followed the pseudocode and named my variables based
on the pseudocode. The first loop sets all positions in the matrix to
0 when the vertex is pointing to itself. The second loop goes through
each of the vertices and changes the value in the matrix to 1 if there
is another vertex it has a connection to, otherwise I had it set to 99999
as instructed under the task implementation section of the lab task
assignment. The third loop consisting of 3 loops traverses the matrix and
compares prior results and reusing them to determine the length of the 
shortest path for every pair of nodes in the graph. The last loop in the
method goes through and prints out the constructed matrix.
The main method has 3 test cases where I used letters, numbers, and names
to test the display of the matrix.