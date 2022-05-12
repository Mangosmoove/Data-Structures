Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lecture 11
10/1/2020, 9:17 am

HUFFMAN ENCODING
-algorithm paradigm (specific way of designing and implementing an algorithm)
-encodes text (store text in a file)
-assigns a code(bits - 0&1) to each character that we want to encode
-variable length in coding depending on position in tree
-prefix-free - there is no prefix in the code that will tell us that there is no new character
--any prefix-free binary code can be visualized as a binary tree w/ encoded characters stored at the leaves
---internal nodes are only there to build tree shape
---binary code is stored in the edges
--want to take advantage of the fact that any language we use and want to transmit, as long as it's made of characters, we can measure the frequency of each character in text
-decide what encoding to after looking at text itself 
-length of code depends on the relative frequency/weight of the corresponding character
--letters that are more often used will have a higher wait in terms of importance and they will be encoded more efficiently
-most used in order: e, t, a, o, i, n, s, h, r, d, l, u
-stored in memory as bits(0 & 1)
--how are letters stored in memory?
---follows some kind of rule
----ASCII
-----letters pre-date standard plain-text terminals
-----ordered by importance (b7 - b1)
------1 based
------ASCII is 7 bit (every single letter occupies 7 bits)
-------8th is used for error detection to make sure other 7 bits were transmitted right
----UTF-8
-----one of the most used encodings for text-based communications (over 95% of webpages use)
-----for encoding non-Latin languages

HUFFMAN TREE
-is a full binary tree in which each leaf of the tree corresponds to a letter in the given alphabet
-weighted path length 
--node's weight * node's depth
--for Huffman trees: satisfies the minimum external path weight property i.e. has the minimum sum of weighted path lengths
---longer set of bits (code length) = higher depth in tree

ENCODING A STRING USING A HUFFMAN TREE
-replace each letter in string w/ binary code
--binary code is found by traversing the tree

DECODING
-use bits to navigate the tree
-look left and right to look for letter than go back to top
-prefix free bc no encoding can be used as the beginning of any other coding

BUILDING
-look at each letter as an individual tree
-min heap priority queue
-don't care if it's sorted as long as first element is the smallest value
-from heap, remove first 2 trees from heap to create a new tree where root has 2 trees of children
 and weight is the sum of the weight of the 2 children trees
--put that into priority queue at the beginning
-index shifts to the right where 0 will be index of tree
-repeat w/ 0 and 1st index depending on weight (smallest weight should be smaller index)
--picking smallest two trees with lowest weight from min-heap
-greedy algorithm - finds local best decision w/out looking at anything else
--decision is removing the first 2 trees from min-heap
-extraction time: 2*(n-1) steps, O(logn) time because it needs to re-heapify the MinHeap
-building tree takes O(nlogn) time
-Lemma - uses step stone to actual proof you want to use
--if you pick 2 of the least weighted, there is an optimal code tree where the 2 are siblings whose depth is at least as any other leaf nodes in the tree



LECTURE TASK
                        (87)
		       0/  \1
		       E    T (76)
                          0/ \1
		      (42)A   O (43)  
			0/     \1
		    (11)N

QUESTIONS
1) How many bits does ASCII use in memory?
   7 bits
2) How do you get the binary code of an element?
   Store the edges visited in order
3) How does the priority queue order the huffman tree?
   by min-heap (increasing weight)