import java.util.Arrays;

public class Queue<E> {
	private static final int INITSIZE = 10; //initial array size
	private E[] items;
	private int numItems;
	private int head; //the index of beginning of the queue
	private int tail; //the index of end of the queue
	/*
	 * NOTE: tail refers to the next available index to insert an element, so in a sense the index after the last element of the queue
	 * For example, if queue = [0, 3, 2, 4, null, null, ...]
	 *                          ^head        ^ tail
	 */

	/**
	 * Constructor
	 */
	public Queue() {
		items = (E[]) new Object[INITSIZE];
		numItems = 0;
		head = 0; 
		tail = 0;
	}

	/**
	 * enqueues the element to the end of the queue
	 * @param object to enqueue to the queue
	 */
	public void enqueue(E obj) {
		growIfNecessary();
		items[tail] = obj;
		tail++;
		numItems++;

		//TODO: implement the enqueue method
	}

	/**
	 * dequeues from the front of the queue
	 * Return null if the queue is empty
	 * @return the value dequeued
	 */
	public E dequeue() {
		if(isEmpty()) {
			return null;
		}
		head++;
		numItems--;
		return items[head-1];
		//TODO: implement the dequeue method

	}

	/**
	 * @return whether the queue is empty or not
	 */
	public boolean isEmpty() {
		if(head == tail) {
			return true;
		}
		//TODO: implement isEmpty method
		return false;
	}

	public void growIfNecessary() {
		if(items.length == numItems+head) {
			//double the length of the original stack
			E[] newItems = (E[]) new Object[2*items.length];

			int index = 0; //index to insert in the new array
			int count = 0;
			while(count < numItems) {
				newItems[index] = items[head];

				//increment head and index
				index ++;
				head ++;
				count ++;

				//if head is past the length of the array, loop back around to 0
				if(head >= items.length) {
					head = 0;
				}
			}

			//set the queue to be the new queue
			items = newItems;

			//set the head of the queue to be 0
			head = 0;

			//set the tail of the queue to be numItems
			tail = numItems;
		}
	}

	/**
	 * Prints the queue
	 */
	public void printQueue() {
		String queue = "";
		int index = head;
		int count = 0;
		while(count < numItems) {
			queue += items[index] + " ";
			count ++;
			index ++;
			if(index >= items.length - 1) {
				index = 0;
			}
		}

		System.out.println("Queue of Size " + numItems + ": " + queue);
		System.out.println("Queue in Array Form: " + Arrays.toString(items));
	}

	/**
	 * Reverses the given queue using a stack
	 * Use the stack that you implemented earlier in the lab
	 * @param queue: the queue you want to flip
	 */
	public static <T> Queue reverseQueue(Queue<T> queue ) {
		Stack<T> s = new Stack<T>();

        while(!queue.isEmpty()) {

            s.push(queue.dequeue());

        }

        Queue<T> q = new Queue<T>();

        

        while (!s.isEmpty()) {

            q.enqueue(s.pop());

        }

        return q;
	}

	//for main method testing
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.enqueue("Hi");

		q.enqueue("Lol");

		q.enqueue("Geek");

		q.enqueue("D");
		q.enqueue("C");
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("E");
		q.enqueue("R");

		q.enqueue("P");
		q.enqueue("O");
		//  System.out.println(q.tail);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.head + " " + q.tail);
		System.out.println(q.dequeue());
		System.out.println(q.head + " " + q.tail);
		q.enqueue("T");
		System.out.println(q.head + " " + q.tail);
		System.out.println(q.dequeue());
		System.out.println(q.head + " " + q.tail);
		q.enqueue("Hi");
		q.enqueue("Lol");
		q.enqueue("Geek");
		q.enqueue("D");
		q.enqueue("C");
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("E");
		System.out.println(q.numItems);
		System.out.println(q.head + " " + q.tail);
		q.enqueue("R");
		q.enqueue("P");
		q.enqueue("O");
		reverseQueue(q).printQueue();
	}
}