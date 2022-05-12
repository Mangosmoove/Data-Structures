Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Problem set 08
10/20/2020, 5:30pm

For the recursive method, the first step I thought of was figuring out the base case
of the method which was whenever the kSum we were looking for ended up being 0 at the
end because that meant that there existed a subset of numbers where the sum equaled kSum.
Then for the induction step, I first had to write out the pseudocode for what I wanted.
I knew I would have to traverse through the entire array of ints and then whenever I found
a number that could be subtracted from kSum, I would need to remove that number and recursively
call the method again. I tried to implement the remove method in the recursive method initailly,
but I was having difficulties and couldn't figure out why so I just made a helper remove method
that would remove the number that could be subtracted from kSum. Then the stack would need to be
popped so I did that with the if-statement that recursively called the method.
For the dynamic method, I referenced the pseudocode that was given to us in Knapsack.java and modify
it because of the differences between my program and the pseudocode's. I created a 2D array that would
be the kSum+1 x the parameter array's length+1 which mirrored the 2D array V in the pseudocode. I then
initialized the 2D array like how it was done in the pseudocode except I used true and false instead of
0. Then I went through the 2D array and checked whether or not the element that was less than or equal
to the kSum was greater than the given array at its position - 1 and if that was the case then I set the
value at the subset to true or false after it evaluated the expression with the or statement. If one of those
were true, then the kSum could be found in a subset of numbers, but if none of the expressions evaluated to
true then the value in subset would be evaluated to false. This results in O(2^n) because two expressions are
being evaluated n times so that would be 2^n. I then returned what the lower right hand corner value
was in the 2D array I had made.