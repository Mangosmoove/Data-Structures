Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lab 5
9/26/2020, 4:29pm

Task A
Before programming this, I wrote out conditions that needed
to be met in order for a tree to be balanced. If the node
was a leaf node then it would be true because it would have
reached the last child. It makes more sense to explain when
the recursion part happens so I'm sorry if that sounds wrong.
If the node wasn't a leaf, I checked whether or not the node
had children nodes. If it did have two children, then I checked
the size of each of those subtrees and if the sizes weren't the
same (>1), the tree wouldn't be balanced. If the sizes were the same
I checked whether or not the nodes were a leaf node and recursively
called the method. Then I checked whether or not one of the children
nodes were null because if so, I needed to check whether the non-null
node was a leaf node because if it wasn't, then the size of the non-null
subtree would be greater than the size of the null node's subtree because
that subtree wouldn't exist. In order to test whether or not this
actually worked for both balanced and unbalanced trees, I looked up
an example of a balanced BST online (I linked it in my code but here
it is again: https://rb.gy/x4a8yh

Task B
I started off not knowing where to start with this. Writing
it out made it a whole lot easier to understand the recursion
behind the traversals though. I also picked up on the pattern
on where to print out the node based off of the preorder method.
I then moved the print statement depending on the traversal.

Task C
I had no idea where to start coding this but conceptually thinking,
the smallest element would have to be a leaf node because a node that
had a child would be smaller than the parent. We'd need to search the left
subtree first because all values to the left of a node are smaller than the 
node. But the thing that woulddetermine if we need to search the right subtree
would be whether or not the sizes of the subtrees are less than, greater than, 
or equal to K. If the left subtree's size is equal to K then we'd need to get 
the value of the node of the left sub-tree. If the left subtree's size is
less than the value of K, the right subtree will contain the value. If 
the left subtree's size is greater than K then the value will be in the
left subtree. But we'd need a way to control which nodes were already visited.
I know the hint said to mess with the size in BinNode but I don't know how
to. So instead, I think a counter would work the same way. Inorder traversal has
the nodes listed out in increasing order (https://www.gatevidyalay.com/binary-search-tree-traversal-bst-traversal/ 
under important notes/ note-01) so we could traverse that way. The counter variable would
also have to be monitored based on how many elements we've visited. I honestly
have no idea if this will meet the desired big-theta but I really wanted to see
whether or not it actually worked based off of this current logic. If I can
think of some other way to reduce time then I'll go back and change it.

pseudocode:
check whether the nodes on either side of given node are null
...check whether the size of left subtree equals K and if so print out that node
...if condition above isn't met
.......check whether the size of left subtree is greater than K
............recursively call the function but pass in left-subtree
.......if condition above isn't met check whether left subtree is less than K
............recursively call the function but the K value needs to change depending on size of the left subtree checked
............and then counter needs to be incremented by the size of the left subtree because we checked all of those nodes

but we'd need to do some of those conditions depending on if there were a null child.

In the end, I couldn't get it to work properly. It runs without crashing but prints out either
nothing or the wrong output.