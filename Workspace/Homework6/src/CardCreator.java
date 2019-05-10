import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 6 Card Creator
 * 
 * This class defines the thread task that will
 * "come up with" and submit greeting card ideas
 * to the print queue.  We have added the code
 * necessary to read from the file, but it's up to
 * you to handle turning off the printer (keeping
 * track of how many threads are open) and adding
 * the read-in line from the inspiration file to
 * the queue.
 * 
 * @author jc5pz
 *
 */
public class CardCreator implements Runnable {
    
    /**
     * Print queue to add new card ideas
     */
    private PrintQueue printQueue;
    
    /**
     * Inspiration file name
     */
    private String filename;
    
    
    /**
     * CardCreator Constructor
     * @param d is PrintQueue object
     * @param filename is Filename
     */
    public CardCreator(PrintQueue d, String filename) {
        printQueue = d;
        this.filename = filename;
    }
    /**
     * Run method that is the main method for the thread
     */
    @Override
    public void run(){
        int x = 0;
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(filename));
            while (s.hasNextLine()) {
                x++;                        
                printQueue.enqueue(s.nextLine());       
                Thread.sleep(1000);                    
            }
        } catch (IOException e) {
            System.out.println("Could not read file");     
        } catch (InterruptedException e) {                  
            e.printStackTrace();
        } finally {  
            if (s != null)                
                s.close(); 
        }
        if (x >= 12) {
        	printQueue.turnOff();
            System.exit(0);
        }
    }
}
    
    

