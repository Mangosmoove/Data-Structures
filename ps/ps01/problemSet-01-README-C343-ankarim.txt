C343 / Fall 2020
Problem Set-01
8/30/2020
Arinah Karim, ankarim

These are the results received from Task A-1 about the Java VM:
java.vm.version is 14.0.2+12
java.vm.vendor isAdoptOpenJDK
java.vm.name isOpenJDK 64-Bit Server VM
java.vm.specification.version is 14
java.vm.specification.name is Java Virtual Machine Specification
java.version is 14.0.2
java.vendor is AdoptOpenJDK


These are the results from Task A-2 with the Student class:
Student Information
Name: Burton Guster
Age: 18
Department: Pharmacy
Can drive?: true

Student Information
Name: Shalissa
Age: 20
Department: Media
Can drive?: false

Student Information
Name: Burton Guster
Age: 18
Department: Pharmacy
Can drive?: true

Student Information
Name: Shawn Spencer
Age: 20
Department: Psychology
Can drive?: false

Student Information
Name: Chad
Age: 19
Department: Kelly
Can drive?: true

These are the observations I made:
I was able to see the different attributes for each student regardless of them being an instance of the class or an instance of the
class while also in an array.


Task-B Process
In the RandomChunkOfData class, I knew I would need to make a call to the HammingDNADistance class. Since we needed
to compare 2 sequences of DNA, I thought it would be best to have the parameter for my hammingDistance method take in
2 strings. Then the method would be able to go through each character in the strings (which is something I had to look intof
for quite a bit of time because .equals was not working and I didn't know why so people online with similar problems recommended
exploring the Character class). I had the comparison set to not equal 0, because if it were 0 then the characters would be the
same at the index. Whenever there was a difference, I would increment my variable dist which basically held the total amount
of differences between the two sequences. Back in RandomChunkOfData, I had a for loop to make sure I met the requirement of having
3 comparisons made. I also had a variable n in the main method that was set to 100 because the required length of the sequences was
100. And then I printed out the sequences and the hamming distance for the two sequences.


Task-C
1) Θ(1); it doesn't depend on the size of n, so it's constant time
2) Θ(n); i runs the same amount of times regardless, but j depends linearly on n
3) Θ(n^2); n*n is the equivalent of n^2
4) Θ(n^2); even though in the outer loop, i will run until it is one less than n, that number is so small that we can just say it'll run n times and the inner loop will still run through n-1 iterations because 1 is being added to i which can also just be considered n for any large n
5) Θ(nlog(n)); it is going to run through n iterations for the outer loop but it will run logn time in the inner loop because j*=2 for the step which is halving which is what logn does
6) Θ(nlog(n)); it is going to run through logn iterations for the outer loop but execute the inner loop n times
7) Θ(n^2*log(n)); the loops depend on n, so that would be n^2 and then sorting requires log(n) time
8) Θ(n^2); for array a, there will be a point in the inner loop where A[j] = i