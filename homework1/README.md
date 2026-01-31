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
A LinkedList makes more sense and is faster for Suho’s ticket processor, because removing the next ticket from the front is O(1) with a LinkedList but O(n) with an ArrayList given that it requires shifting elements. An ArrayList can be good if it requires frequent index-based access to the tickets.   

## When measuring actual runtime, is the LinkedList version Suho wrote, or your ArrayList version faster? Does this change when the list size is small versus when it is very large?
When list size is small (10), runtime of LinkedList is around 7.3 milliseconds on average and runtime of ArrayList is around 7.6 milliseconds on average. Although LinkedList is slightly faster, the runtime is similar to ArrayList. When list size is very large (50000), runtime of LinkedList is around 450 milliseconds on average and runtime of ArrayList is around 470 milliseconds on average. LinkedList is faster than ArrayList.

## If you ignore queue creation times, does that affect which ticket processor version is faster?
Ignoring queue creation time can slightly affect results for small queues, where creation time is a large fraction of runtime. However, for large queues, the runtime is dominated by ticket removal, and the LinkedList implementation remains faster due to O(1) front removals compared to O(n) removals in an ArrayList.

## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?).
Your report should answer the following questions:
* What did you learn from this experience?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?
* How does the theoretical time complexity compare with your findings?

In this experiment, I evaluated two implementations of a ticket processing system: one using a LinkedList and the other using an ArrayList. The main lesson from this exercise is that the choice of data structure is driven by the usage pattern needed, and the runtime is aligned with theoretical complexity. Although both data structures support constant-time insertion at the end, the cost of removing elements differs significantly. In a queue-style workflow where tickets are repeatedly removed from the front, a LinkedList requires O(1) removal time, while an ArrayList requires O(n) time due to element shifting. This difference becomes more important as the queue size grows.

Based on the measured runtimes, the LinkedList implementation is the better choice for Suho’s ticket processor when the system behaves as a queue and frequently removes the next ticket from the front. For small queues created using createShortQueue (size 10), the average runtime of the LinkedList implementation was approximately 7.3 milliseconds, while the ArrayList implementation averaged 7.6 milliseconds, showing similar performance. For large queues created using createLongQueue (size 50,000), the difference became more noticeable: the LinkedList implementation averaged approximately 450 milliseconds, while the ArrayList implementation averaged approximately 470 milliseconds.

While ignoring queue creation time can slightly affect results for small queues due to heavier creation overhead, it does not change the overall conclusion for large queues where processing time dominates. An ArrayList may still be appropriate in scenarios where index-based access or frequent iteration is required, and front removals are rare.

Overall, the experimental findings align with theoretical time complexity expectations. As the queue size grows, the difference between O(1) and O(n) removal cost becomes significant and explains the observed performance trends. This exercise reinforced the importance of matching data structure choice to actual usage patterns and analyzing theoretical complexity. 


# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?
For Javier's algorithm, time complexity is O(n*logn) and Ω(n*logn). Space complexity is O(n) and Ω(n).


## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

