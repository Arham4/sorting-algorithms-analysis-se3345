# Sorting Algorithms Analysis Program

A battle of sorting algorithms. Given data generated (either in-order, reverse-order, 
almost-in-order, or randomized), sorting algorithms are put to the test to determine who will
be the victor. The entire program is made with adherence to Software Engineering principles to
allow for the easy expansion of this program should one wish to use, for example, a new data type
(for example, Strings instead of Integers), or a new sorting algorithm.

This was made for SE 3345 (Data Structures and Algorithmic Analysis) at the University of 
Texas at Dallas, taught by Professor Ziaullah Kamran Khan.

## Setup

The [JavaFX SDK](https://gluonhq.com/products/javafx/) is required to be made into a user-made
library and supported by your project. Once it is set up, one may execute the program from 
`project1.Main`.

## Features

* A graphical user interface.

![Picture of the graphical user interface](https://i.imgur.com/tbutrpV.png)

* A choice of sorts (as shown in the image above) already made, generified so one may
use a data type other than the Integer class provided.
    * The Radix, Bucket, and Merge sorts are specifically Integer sorts. However, one may
    make a subclass of the merge sort to implement it with different data types.

* Segregated data generation to allow customized generation of data for different data types.
    * One may simply extend the base interface with a new interface of their specified type and
    make data generators using the newly made base class (as shown with 
    `project1.generator.integer.IntegerDataGenerator`).
    
## What could be improved?
The `project1.gui.GUIController` should be segregated to have separate handlers for each data type. This way, one
can even more easily make their own custom data types supported. While right now it involves
simply replacing all usages of `Integer` with `YourClassHere` and disabling the Radix and Bucket sorts,
this isn't easy to tell without proper abstraction.

## Final analysis
For integers, the fastest algorithm for a data set that was already in order was the Insertion 
sort. However, it was pretty much tied with the Bucket sort. The insertion sort runs at such a
fast timing since in its best case, it is of O(n) run time. Insertion sort would linearly keep 
going forward and noticing that the current item and the items ahead are already sorted in place. 
In the same way, the bucket sort, usually O(n + k) time, runs at O(n) time since the maximum 
number is equivalent to the size of the array anyways. 

The fastest algorithm for a data set that was in reverse order was the bucket sort algorithm. It 
performs so fast due to the lack of “comparisons,” in sorting algorithm terminology. Albeit 
there are comparisons performed, they aren’t performed for the sake of sorting.

The fastest algorithm for a data set that was almost in order was the bucket sort algorithm. This 
was tested to ensure fairness by making sure all sorts use the same data set (made clones so as 
to not pass an already sorted data set to another sorting algorithm), as the latter randomly 
generated numbers (hence the “almost” order) could be different case to case, giving different 
results, had this not been ensured.

The fastest algorithm for a data set that was completely randomly generated was the bucket sort 
algorithm. This was tested to ensure fairness by making sure all sorts use the same data set 
(made clones to not pass an already sorted data set to another sorting algorithm). 