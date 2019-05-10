/*
Name: Justin Cai, Ayush Mayur
Computing ID: jc5pz, am3nz

*/


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		growIfNecessary();
		elements[tail] = s;
		tail++;
		currentSize++;
		// TODO: Complete this method to implement the add() method for a Queue
        
        
	}
	
	public String remove(){
		if(tail == head) {
			return null;
		}
		
		head++;
		return elements[head-1];
		
		// TODO: Complete this method to implement the remove() method for a Queue
        
        
	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
        Queue q = new Queue();
        q.add("Hi");
        q.add("Lol");
        q.add("Geek");
        q.add("D");
        q.add("C");
        q.add("A");
        q.add("B");
        q.add("E");
        q.add("R");
        q.add("P");
        q.add("O");
      //  System.out.println(q.tail);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add("T");
        System.out.println(q.head + " " + q.tail);
        System.out.println(q.remove());
        System.out.println(q.head + " " + q.tail);
        q.add("Hi");
        q.add("Lol");
        q.add("Geek");
        q.add("D");
        q.add("C");
        q.add("A");
        q.add("B");
        q.add("E");
        q.add("R");
        q.add("P");
        q.add("O");
        System.out.println(q.head + " " + q.tail);
      //  System.out.print(q.elements);

	}

}