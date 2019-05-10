import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 6 document.
 * 
 * @author jc5pz
 *
 */
 
// Don't forget to include the appropriate import statements
 
public class PrintQueue {
    
    private LinkedList<String> toPrint;   // the printer's list of documents
    private Lock documentChangeLock;      // a ReentrantLock lock
    private Condition hasPrintTask;       // a condition object
    private boolean isOn;                 // boolean variable describing if the 
                                          // queue is on (accepting jobs)

    //TODO:  Handle locking and conditions around the
    //       enqueueing and dequeuing of documents
    //       in this PrintQueue's document list (toPrint)
    //       Note: See the BetterBestBank example in Bank.zip
    //       or in zip folder 'Thread Example 6 - Bank Deadlock' 
    //       on Collab.
    //       Bank.zip:  http://tinyurl.com/cs2110bank

    /**
     * Constructor
     */
    public PrintQueue() {
        toPrint = new LinkedList<String>();                      // create the list of documents
        isOn = true;                                             // turn on the print queue
        documentChangeLock = new ReentrantLock();                //Creates Reentrant Lock 
        hasPrintTask = documentChangeLock.newCondition();        //condition object associated with documentChangeLock
    }

    /**
     * Adds the String s (the greeting) onto the end of the print queue
     * @param s is the String that's added to the queue
     */
    public void enqueue(String s) {
        documentChangeLock.lock();                  
        try {    
            toPrint.add(s);                  
            hasPrintTask.signalAll();              
        }
        finally {
            documentChangeLock.unlock();           
        }
    }
    
    /***
     * Removes the first String off the queue and returns it
     * @return the String that was removed
     * @throws InterruptedException
     */
    public String dequeue() throws InterruptedException{
        documentChangeLock.lock();                   
        try {                                        
            while (toPrint.size() == 0) {             
                hasPrintTask.await();
            }
            return toPrint.remove();                        
        }
        finally {
            documentChangeLock.unlock();            
        }
    }
    
    /**
     * Turns off PrintQueue
     */
    public void turnOff(){                      
        isOn = false;     
    }
    
    /**
     * Checks if PrintQueue is on
     * @return true if Print Queue is on, false if not
     */
    public boolean isOn() {
        return isOn; 
    }
    
    
    
    
    
    
   
    
}