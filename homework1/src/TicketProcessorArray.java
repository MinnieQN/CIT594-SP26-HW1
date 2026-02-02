package homework1.src;

import java.util.ArrayList;
import java.util.List;

public class TicketProcessorArray {
    public static void main(String[] args) {
        
        long start = System.nanoTime(); // start testing runtime
        processTicketsArrayList();
        long end = System.nanoTime(); // end testing runtime
        System.out.println("Run time was " + (end - start) / 1000000.0 + " milliseconds."); // print runtime

    }

    public static void processTicketsArrayList() {

        ArrayList<String> ticketQueue = new ArrayList<>();

        // Uncomment the queue length you want to test with
        createShortQueue(ticketQueue);
        // createLongQueue(ticketQueue);

        
        while (!ticketQueue.isEmpty()) {
            // grab the first item in the list
            String currentTicket = ticketQueue.remove(ticketQueue.size() - 1); 
            
            System.out.println("Processing: " + currentTicket);

            System.out.println("Finished! Remaining in line: " + ticketQueue.size());
            System.out.println("---------------------------");
        }
    }

    public static void createShortQueue(List<String> queue) {

        for (int i = 50; i > 0; i--) {
            queue.add("Ticket #" + i);
        }
    }

    public static void createLongQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 50000; i > 0; i--) {
            queue.add("Ticket #" + i);
        }
    }
}