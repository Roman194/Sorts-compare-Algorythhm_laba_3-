# Sort algorythms compare
## Note
This project shows the difference between required time for different sort algorythms. </br>
## Values generation
Every time when project starts run, it generate N (8000) double pseudorandom values of exponential distribution. </br>
As Java standart libraries can generate only uniform distribution values, custom realization of convertation of generated values from unifrom to exponential distribution was used. </br>
This convertation is based on calculation of table of intervals for current N and distribution. It can be visualized in Excel file like on screenshot below. </br>
![image](https://github.com/user-attachments/assets/1df35f32-a225-4eb7-9e10-a37ee65fec17) </br>
In this screenshot the difference of the current P num and the next one is probability of matching the number to current interval (num before dot). 
To make this probability suitable for N values, this P is multiplies on N and we get a count of numbers in the current interval.
So the next interval will starts from previous interval end plus count of values in the current one.
As we can see after Num = 9 the count of numbers is zero and the interval isn't increase. For this reason, the program counts interval only to 9 Num (in general case it should do that only first zero count of numbers). </br>
To make the ratio part of double values, the difference between generated uniform number and interval start and between interval end and interval start are used (the result of their division). </br>
## Used algorythms
* Buble sort
* Cocktail sort
* Selection sort
* Insertion sort
* Gnome (Stupid) sort
* Shell sort
* Heap sort
* Quick Lomuto sort
* Quick Hoare sort
* Merge sort
## Used metricks
Only for simple ones:
* Compares count (C)
* Relative swaps count (M = swaps / N)
For all algorythms:
* Time (ms)
* Relative time (ms / as time per average time)
## The result
As the result the comparison table is prints to console. It should be similar to screenshot below </br>
![image](https://github.com/user-attachments/assets/88a914fd-6df3-4a8f-bd44-39c8bbc6fa1a)


