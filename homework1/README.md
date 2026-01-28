## Please enter your personal info here:
Name: Qingni Yu

PennKey (e.g., taliem): qingniyu


# Part 1:
## Are Alicia and Lloyd both wrong, or perhaps both right? Is only one of them correct? Why?

They can be both right.

If lst is an ArrayList, Lloyd is correct:

    Function A: O(1)
        lst.size(): O(1)
        lst.get(middle): O(1)
    Getting size and an element from an ArrayList is constant time.

    Function B: O(n) 
        lst.size(): O(1)
        lst.get(0): O(1)
        lst.remove(0): O(n)
        lst.get(lst.size() - 1): O(1)
        lst.remove(lst.size() - 1): O(1)
    Removing the first element from an ArrayList needs to reallocate other elements in the List, so it's linear time.

If lst is a LinkedList, Alicia is correct:

    Function A: O(n)
        lst.size(): O(1)
        lst.get(middle): O(n)
    Getting an element from a LinkedList is linear, because we need to traverse the list.

    Function B: O(1) 
        lst.size(): O(1)
        lst.get(0): O(1)
        lst.remove(0): O(1)
        lst.get(lst.size() - 1): O(1)
        lst.remove(lst.size() - 1): O(1)
    Removing the head or tail element from a LinkedList is constant time.

# Part 2:
## What are the Big O and Big Ω times for snippets C and D?
C: O(n*m), Ω(1)
D: O(n*m), Ω(n*m)

## When measuring actual runtime, does one of the snippets run faster than the other? In what situations? Why do you think this is the case?
C run faster than D in a situation that the target is not in the last row and last column. It is because C immediately break when target is found. D will continue looping all the elements, even though the target is found and saved.

## What else do you notice about the reported runtime? Is it 100% consistent every time you run it?
It's not 100% consistent. The runtime varied a little for each time and the runtime becomes smaller, which means faster, as I ran.

# Part 3:
## Before you make any changes, explain whether you think a LinkedList or an ArrayList makes more sense in this instance. Which do you think will be faster? Why?
An ArrayList makes more sense and is faster. Tracking and managing tickets typically involves iterating through the list, accessing tickets by index, and adding new tickets to the end. A LinkedList requires O(n) time for traversal and index-based access, even though adding to the end is O(1). In contrast, an ArrayList takes O(1) time to access a ticket and O(1) time to append new tickets to the end.   

## When measuring actual runtime, is the LinkedList version Suho wrote, or your ArrayList version faster? Does this change when the list size is small versus when it is very large?


## If you ignore queue creation times, does that affect which ticket processor version is faster?


## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?).
Your report should answer the following questions:
* What did you learn from this experience?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?
* How does the theoretical time complexity compare with your findings?







# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?



## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

