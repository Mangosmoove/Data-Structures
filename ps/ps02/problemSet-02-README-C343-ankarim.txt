Arinah Karim / ankarim
CSCI-C 343 / Fall 2020
PS-02
9/8/2020

Task A:
Putting elements into an Arraylist is not hard. What took the most amount of time
was figuring out how to handle the royals. I had to watch some videos on modulus
to make sure I understood the math behind it. After figuring out which numbers would need
to be modded with what value, the rest was nice. I had to brush up on the Random class because
I almost confused the bounds with indices. My mindset behind drawRandomCard() and 
drawTopCardFromDeck() methods was that if I were to draw a card, I'd put it at the bottom 
of the deck. So in those methods I included the fact that they are removed from the deck to 
be added to the bottom of the deck. In the placeCardOnBottomOfDeck method, I included the 
print statement about the card being found because I was having difficulties with that for 
some reason that eventually got fixed from me doing something. I also included the last
else if statement to make sure that some non-existent card would have an error message in
some kind of way. I was thinking of how I could fit the cards in the terminal without having
52 lines of just cards. So instead, I used modulus to have 13 cards for each lines (4 total).
Then I did a series of print statements in my main after instantiating an object to run 
some basic tests.

Task B:
I did the TweetClass class first. When we were told that we could
make the constructor however way we saw fit, I thought the best method would be to have a String
for the author's name and a String for whatever it is that they post. I included getter methods
that I thought would be useful later for client code and also later for TheTweeter class. I used
the contains method for Objects to see if a string was in the content string and then in main I
ran some basic tests. I remember spending 2 hours trying to understand that an arraylist of a
certain type should be empty but then you'd need to add objects to it but how? And then I
realized I was a dummy and then figured it out. I got so tripped over the fact that there were
multiple adds going on but I just had to mentally distinguish them. I have the brainpower of a fish,
but anyway, I made an Arraylist that would hold objects of the TweetClass class. The add method used
the add method Arraylists can use. Remove required accessing a getter method from the TweetClass
class. I used the equals method because you don't use ==. In the main method, I made an object of
the class and created some objects of the TweetClass class. Then I started implementing the methods
to run some basic tests. The inspiration behind the objects I made were vines because I accidentally
added a vine contemplation to my music playlist. I also had to use the getContent method from the
TweetClass so I wouldn't just get a memory location printed out. To avoid getting a NullPointerException
I didn't use the getContent method when I tried removed the author Michael B and his content.

Task C:
I don't know if I misinterpreted the instructions but I basically just implemented the required methods
and the additional 2. But if I were to go outside of the requirements here's what I think an ADT for an
2D array of ints should have:
-setting a number at a certain position to something else
-returning a number at a certain position
-deleting a number
-return a count for a certain number appearing in the array
-inserting a number though I'd imagine it as setting a number because I'm not certain how to do that without
messing with the size of the array
-size method where a new array could be constructed to dimensions bigger than the current size to add in more numbers
if needed

The implementation:
As I mentioned above, I included the basic requirements for the ADT and gave comments on their functionalities.
I struggled a bit with the Int2DArray class because I kept getting memory locations and then I realized that
I forgot to specify the dimensions of the field. When I was thinking of what getColumn method would return, I 
thought a 1D array would be fine, but I kept running into the problem of getting a memory address and spent a 
good amount of time trying to run different print statements on it but couldn't fix it. So instead, I chose to
do a print statement in the method itself and make its return type void. I did the same with the getRow method
as well. I had the set method take in 3 parameters: the row index, the column index, and the value that wanted
to be changed. The get method just returned the value at the row index i and the column index j. I interpretted
the zeroArray method as resetting the 2D array to have all zeroes so I did that. The toString method was basically
for formatting purposes and to override the regular toString method so I wouldn't get a memory address printed out.
I formatted it so it'd appear as it'd look in a matrix. In the main, I ran a lot of tests to debug and find errors.