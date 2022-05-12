Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lab 12
11/13/2020, 6:52pm

I kept some of my code the same from the previous problem set and modified 
my minDistVertex method. I basically did the same thing I did for the relax
method for Dijkstra for Prim's algorithm. The actual primMST method itself
wasn't too hard to do because it was all basically given in the pseudocode
so I utilized that. Explaining the algorithm, it starts with an array that
will contain the distances to each of the nodes and sets the first starting
node distance to 0 because it's the source node. Then it processes the nodes
and that's when I used the minDistVertex method like how I did in Dijkstra's.
After being processed, the MST's cost gets incremented by the distance at a
new node. The relax method gets called where for all neighbors of the current node
checks the weight between the neighbors and the current node and compares them
and sets dist at that current node to the right ditsances based on that comparison.
At the end, I had it print out the dist array using Arrays.toString and then
had it display the MST cost.