Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Problem Set 5
10/6/2020, 8:47pm

TASK A
letter	frequency	code	bit
A	50%		0	1
T	35%		11	2
C	10%		101	3
G	5%		100	3

Huffman Tree:
			(100)
		       0/   \1
		     (50)   (50)
		      A	   0/  \1
                          (15) (35)
			 0/  \1	 T	
			(5) (10)
			 G    C
a fixed-length code for the four characters would require log4 = 2 bits per letter.
For Huffman coding, the expected cost per character is (assuming length = 50):
[(1*25) + (2*17.5) + (3*5) + (3*2.5)]/50 = [25 + 35 + 15 + 7.5]/50 = 1.65 bits

ratio: 2 / 1.65 = 0.825
compression ratio = 100 / 82.5 = 1.21
		  (2 x 50)


TASK B
Since we had the option of using a helper method, I created one called bCTHelper for the buildCodeTable method.
The bCTHelper would take in a node of type BinNode and a string. The BinNode kept track of what node I was at
in the program and the string represented the code of the node. If the node was a leaf node, then the code was
already made so I just need to put it in the HashTable. If the node was wasn't null on either the right or left
then I made a recursive call and added to a 0 -if the left wasn't null- to the String and a 1 if the right of
the node wasn't null. The buildCodeTable method itself checks for whether the root for the traversal was empty
or was a leaf node and if it wasn't either of those, I used the bCTHelper method. For the decode method, I went
through all the characters in the string parameter and got the value at each character depending on whether the
character was 0 or 1. If the node was a leaf node, then I put the value of that node in the string and reset the
current node's position. After traversing through the entire string, I returned the decoded message.

TASK C
Before working at the main task, I did the other task first. I found that the breaking point for the program was at
n = 32768 (Exception in thread "main" java.lang.OutOfMemoryError: Java heap space) This is because we were making the 
size of the string n double itself so the algorith was growing at a rate of n^2. So there was not enough memory left
to calculate the distances. You can see the results further down.
For the levenshteinDistance method, I followed along the given pseudocode. I also made a min function because that
was present in the method's pseudocode. For reading each of the files in the main method, I created 2 scanners to read
the files and stored the files' contents into appropriate strings. Then I used the methods to calculate the editing
distances which I got:
Hamming distance for sequences: 704
Levenshtein distance for sequences: 6


length: 4
Time elapsed to generate DNA sequence1 in nanoseconds: 1585100
Time elapsed to generate DNA sequence2 in nanoseconds: 208600
Hamming distance for sequences: 3
Time elapsed for calculating hamming distance in nanoseconds: 387500
Levenshtein distance for sequences: 2

Time elapsed for calculating levenshtein distance in nanoseconds: 276200
length: 8
Time elapsed to generate DNA sequence1 in nanoseconds: 45000
Time elapsed to generate DNA sequence2 in nanoseconds: 31000
Hamming distance for sequences: 8
Time elapsed for calculating hamming distance in nanoseconds: 39200
Levenshtein distance for sequences: 6

Time elapsed for calculating levenshtein distance in nanoseconds: 66000
length: 16
Time elapsed to generate DNA sequence1 in nanoseconds: 60600
Time elapsed to generate DNA sequence2 in nanoseconds: 61900
Hamming distance for sequences: 14
Time elapsed for calculating hamming distance in nanoseconds: 39900
Levenshtein distance for sequences: 12

Time elapsed for calculating levenshtein distance in nanoseconds: 286500
length: 32
Time elapsed to generate DNA sequence1 in nanoseconds: 148200
Time elapsed to generate DNA sequence2 in nanoseconds: 127300
Hamming distance for sequences: 24
Time elapsed for calculating hamming distance in nanoseconds: 52200
Levenshtein distance for sequences: 19

Time elapsed for calculating levenshtein distance in nanoseconds: 372400
length: 64
Time elapsed to generate DNA sequence1 in nanoseconds: 243800
Time elapsed to generate DNA sequence2 in nanoseconds: 308700
Hamming distance for sequences: 48
Time elapsed for calculating hamming distance in nanoseconds: 48500
Levenshtein distance for sequences: 36

Time elapsed for calculating levenshtein distance in nanoseconds: 4057400
length: 128
Time elapsed to generate DNA sequence1 in nanoseconds: 711600
Time elapsed to generate DNA sequence2 in nanoseconds: 369600
Hamming distance for sequences: 91
Time elapsed for calculating hamming distance in nanoseconds: 145600
Levenshtein distance for sequences: 71

Time elapsed for calculating levenshtein distance in nanoseconds: 3446200
length: 256
Time elapsed to generate DNA sequence1 in nanoseconds: 415000
Time elapsed to generate DNA sequence2 in nanoseconds: 243000
Hamming distance for sequences: 197
Time elapsed for calculating hamming distance in nanoseconds: 137100
Levenshtein distance for sequences: 135

Time elapsed for calculating levenshtein distance in nanoseconds: 13343900
length: 512
Time elapsed to generate DNA sequence1 in nanoseconds: 388800
Time elapsed to generate DNA sequence2 in nanoseconds: 376900
Hamming distance for sequences: 378
Time elapsed for calculating hamming distance in nanoseconds: 211600
Levenshtein distance for sequences: 263

Time elapsed for calculating levenshtein distance in nanoseconds: 18089200
length: 1024
Time elapsed to generate DNA sequence1 in nanoseconds: 2110500
Time elapsed to generate DNA sequence2 in nanoseconds: 868100
Hamming distance for sequences: 759
Time elapsed for calculating hamming distance in nanoseconds: 715200
Levenshtein distance for sequences: 532

Time elapsed for calculating levenshtein distance in nanoseconds: 25377800
length: 2048
Time elapsed to generate DNA sequence1 in nanoseconds: 3428100
Time elapsed to generate DNA sequence2 in nanoseconds: 7635300
Hamming distance for sequences: 1548
Time elapsed for calculating hamming distance in nanoseconds: 357000
Levenshtein distance for sequences: 1055

Time elapsed for calculating levenshtein distance in nanoseconds: 68202700
length: 4096
Time elapsed to generate DNA sequence1 in nanoseconds: 4342700
Time elapsed to generate DNA sequence2 in nanoseconds: 1625300
Hamming distance for sequences: 3069
Time elapsed for calculating hamming distance in nanoseconds: 663500
Levenshtein distance for sequences: 2136

Time elapsed for calculating levenshtein distance in nanoseconds: 386283100
length: 8192
Time elapsed to generate DNA sequence1 in nanoseconds: 13897400
Time elapsed to generate DNA sequence2 in nanoseconds: 22597200
Hamming distance for sequences: 6097
Time elapsed for calculating hamming distance in nanoseconds: 1250900
Levenshtein distance for sequences: 4222

Time elapsed for calculating levenshtein distance in nanoseconds: 1173548200
length: 16384
Time elapsed to generate DNA sequence1 in nanoseconds: 56535000
Time elapsed to generate DNA sequence2 in nanoseconds: 74076400
Hamming distance for sequences: 12263
Time elapsed for calculating hamming distance in nanoseconds: 1772000
Levenshtein distance for sequences: 8493

Time elapsed for calculating levenshtein distance in nanoseconds: 3691082500
length: 32768
Time elapsed to generate DNA sequence1 in nanoseconds: 302184300
Time elapsed to generate DNA sequence2 in nanoseconds: 84057900
Hamming distance for sequences: 24615
Time elapsed for calculating hamming distance in nanoseconds: 3636300
**out of memory error here