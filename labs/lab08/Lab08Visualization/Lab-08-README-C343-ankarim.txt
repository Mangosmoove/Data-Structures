Arinah Karim, ankarim
CSCI-C 343 / Fall 2020
Lab 08
10/17/2020, 6:44pm

I first copied and pasted all the source code I had from problem set 5. Then I started working
with the PS05Model class. I changed the 2D array to a 1D array. Then I changed the randomize method
so that the highest value an element could have would be the height of the JFrame. Then I worked on
the sorting method which I kept as sortRows. I used Bubble Sort to sort throught PS05 so I also used
it here too. I made the appropriate changes to only account for sorting through a 1D array of values.
I then called setChanged and notifyObservers methods whenever the inner for loop was executed for
the animation of moving elements. I had some client code at the end of the class to ensure that the
Bubble sort method actually worked. 
Then I went to the view class. I changed it a lot compared to what
I had in Problem set 5 because I couldn't get it to work in that set. However, I was able to make it work
in Problem set 7 so I copied the View class I made in there. I changed the drawPoint method to only take
in an x-position and a value because all the elements would be drawn along the same y.
In the main of the Controller class, I instantiated objects of Model and View and assigned the Controller
object I made to be the observer of the model class. The Controller class was essentially the same I had 
in problem set 7 but I made a call to the clear method from the View class to keep redrawing. I went 
through a for loop of all the elements in the Model class' array and called on drawPoint to draw it.
