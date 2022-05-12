Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lab-03
9/11/2020, 10:13p.m.

I kept the ArrayList that I used in the problem set because it made it easier
for me to understand what was happening. I also included the add method from
the TheTweeter class so I could add elements into the ArrayList. For the getTweets
method, I basically kept it the same as I had it in the TheTweeter class. I included
the newline because I noticed that there was a user that tweeted more than once so
for formatting purposes I added in a newline. I then returned an ArrayList of Strings 
containing the contents of the what the author posted. The tweetedAbout method was like the
getTweets method but instead we were comparing a substring to the content and we
already had a contains method in the other class so I used that to compare the content
that the author had posted to what the user was asking was in any of their tweets.
Because of the possibility of a user being able to tweet more than one thing, I used
for loops for both of my methods to go through the entire ArrayList. For the main method,
I referenced Oracle for how to read in a line and how to use BufferedReader and 
explored its different methods, trying to think of ways of how to separate the first
word from the rest. But then I realized that inputLine was a String and I could
use substrings and the indexOf method to determine the index of the first space
and separate the author from the content. I then created a new object of the TweetClass
and then added that into the ArrayList. After the while loop, I ran some tests to
see if my methods would work whether the author had wrote one tweet or more than one
tweet. I used the try-catch statement supplied to us by the example.