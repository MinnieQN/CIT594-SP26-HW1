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
C: O(n*m), Ω(1) where n is rows and m is columns
D: O(n*m), Ω(n*m) where n is rows and m is columns

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

In this experiment, I evaluated two implementations of a ticket processing system: one using a LinkedList and the other using an ArrayList. The main lesson from this experience is that data structure choice must be driven by the specific usage pattern. Although both structures support constant-time insertion, their removal costs differ fundamentally based on how they are used. In a standard queue workflow where tickets are removed from the front, a LinkedList offers O(1) removal, whereas a standard ArrayList requires O(n) due to element shifting. However, I learned that by optimizing the ArrayList implementation, specifically by loading data in reverse and removing from the end, we can achieve O(1) removal time, effectively matching the performance of a LinkedList. 

Measured runtimes confirmed that the LinkedList and the optimized ArrayList share similar performance. For small queues (size 10), runtimes were negligible across the board: the LinkedList averaged 7.3 ms, the standard ArrayList 7.7 ms, and the optimized ArrayList 7.0 ms. For large queues (size 50,000), the distinction became clearer. The standard ArrayList lagged slightly at approximately 470 ms due to the shifting overhead. In contrast, the LinkedList averaged 450 ms, and the optimized ArrayList achieved parity at 449 ms.

For Suho’s ticket processor, I suggest using the LinkedList implementation. While the optimized ArrayList is technically just as fast, it requires treating the list as a Stack (Last-In-First-Out) to avoid the cost of removing from front. This creates a risk of misuse if the data isn't loaded in reverse. The LinkedList naturally supports First-In-First-Out queue behavior, making it the more robust and maintainable choice for this specific task. An ArrayList would be the superior choice only in scenarios requiring frequent index-based access rather than sequential processing.

Overall, the findings align with theoretical expectations. The experiment demonstrated that when the O(n) shifting cost is removed from the ArrayList, its performance converges with the O(1) LinkedList. This reinforces the importance of analyzing not just the data structure itself, but exactly how it will be accessed and modified in production.

# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?
For Javier's algorithm, time complexity is O(n*logn) and Ω(n*logn). Space complexity is O(n) and Ω(n).


## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

Theoretically, both the Javier’s (Iterative) and my (Recursive) algorithms are equivalent. Both exhibit a time complexity of O(nlogn) and a space complexity of O(n). However, in terms of actual runtime performance, the Recursive implementation is significantly more efficient.

Measured runtimes indicated that Javier's iterative approach averaged 1.1 ms, while the recursive implementation averaged 0.4 ms.

The performance difference is due to implementation overhead, which isn't captured by Big O. Javier’s iterative approach utilizes a LinkedList to manage the sort order. This introduces significant system overhead, because every subarray must be wrapped in a "Node" object on the Heap. This results in heavy memory allocation and increased pressure on the Garbage Collector. In contrast, the recursive implementation utilizes the System Call Stack to manage the sorting order. Pushing stack frames is a native, low-cost CPU operation compared to the object instantiation required by the LinkedList. Consequently, while the Big O is the same, the recursive version has smaller constant factors and executes faster.

I recommend using the recursive implementation for this task. It follows the standard algorithmic pattern for Merge Sort, making it easier to maintain and debug. Furthermore, it avoids the unnecessary object creation overhead associated with the queue-based approach, leading to better performance.

The iterative (Javier's) approach should be considered only in environments with extremely constrained stack memory where recursion depth is a concern. However, since the recursion depth is logn, this is rarely an issue in modern Java applications. Therefore, the recursive approach remains the superior choice for general use.

