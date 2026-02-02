package homework1.src;

import java.util.LinkedList;
import java.util.List;

public class TicketProcessor {
    public static void main(String[] args) {
       
        long start = System.nanoTime(); // start testing runtime
        processTicketsLinkedList();
        long end = System.nanoTime(); // end testing runtime
        System.out.println("Run time was " + (end - start) / 1000000.0 + " milliseconds."); // print runtime
    }

    public static void processTicketsLinkedList() {

        LinkedList<String> ticketQueue = new LinkedList<>();

        // Uncomment the queue length you want to test with
        createShortQueue(ticketQueue);
        // createLongQueue(ticketQueue);

        
        while (!ticketQueue.isEmpty()) {
            // grab the first item in the list
            String currentTicket = ticketQueue.remove(0); 
            
            System.out.println("Processing: " + currentTicket);

            System.out.println("Finished! Remaining in line: " + ticketQueue.size());
            System.out.println("---------------------------");
        }
    }

    public static void createShortQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 50; i++) {
            queue.add("Ticket #" + i);
        }
    }

    public static void createLongQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 50000; i++) {
            queue.add("Ticket #" + i);
        }
    }
}