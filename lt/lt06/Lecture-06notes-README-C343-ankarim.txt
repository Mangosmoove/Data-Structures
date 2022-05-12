Arinah Karim / ankarim
CSCI-C 343 / Fall 2020
Lecture 6 notes
9/10/2020

STACKS
-LIFO list-like structure
-can only insert to top of Stack (push), time complexity: big theta 1
-can only remove element at top of the Stack (pop), time complexity: big theta 1
-index 0 of stack is the element on the top of the stack
-doesn't satisfy ADT because it wouldn't take constant time
-used all the time at a certain level of implementation of any programming language
---calling a method, implementation is performed by using a stack
---convenient mech. for storing info that needs to be retrieved sooner than anything else
-array-based stack
---have to make sure that you're not going over max size of array
---would push and pop at the bottom of the stack
---limitation: has fixed size
-Linked stack
---uses linked list to build it
---create a new element to be stored in stack data structure and increase size by 1 to add new element
---have to decrease size when popping
---each element contains its own data and the pointer to the next element (.next)
-----would take twice as much space as a normal stack
---go in 35 minutes in about when to use what
-stack is used mainly for recursion

QUEUES
-FIFO, elements can only be added in the back and removed from the front
-enqueue - inserting
-dequeue - removing
-array queue
---has index of front and end element
---check for space
---use modulo for circular increment (tying together the front and end like a circle)
-linked queue
---update rear and size
-array is less efficient w/ space but don't waste space with pointers
---the opposite is true for linked queue

MODEL
-rep. knowledge
-go check out that section later