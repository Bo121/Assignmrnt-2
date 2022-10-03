import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{

	/**
	 * int length the size of the Queue
	 */
	private int length;
	/**
	 * ListNode<T> firstNode The first node in the Queue
	 */
	private ListNode<T> firstNode;
	/**
	 * ListNode<T> lastNode The last node in the Queue
	 */
	private ListNode<T> lastNode;
	/**
	 * int size the number of elements in the queue
	 */
	private int size=0;

	/**
	 * Default constructor
	 */
	public MyQueue() {
		firstNode = lastNode = null;
	}
	
	/**
	 * This methods sets the length of the queue
	 * @param length the length of the queue
	 */
	public MyQueue(int length) {
		this.length = length;
		firstNode = lastNode = null;
	}
	
	/**
	 * This method creates the Linked List
	 * @param <T> Generic type
	 */
	@SuppressWarnings("hiding")
	private class ListNode<T> {
		private T data;
		private ListNode<T> next;
		
		private ListNode(T dataPortion) {
			this(dataPortion, null);
		}
		
		private ListNode(T dataPortion, ListNode<T> nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		private ListNode<T> getNextNode() {
			return next;
		}
		
		private void setNextNode(ListNode<T> nextNode) {
			next = nextNode;
		}
	}

	/**
	 * This method determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return firstNode==null;
	}

	/**
	 * This method determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return size == length;
	}
	
	public T getFront() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			return firstNode.getData();
		}
	}
	
	/**
	 * This method deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if(firstNode == null) {
			lastNode = null;
		}
		size--;
		
		return front;
	}


	/**
	 * This method returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This method adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		boolean success = true;
		if(isFull()) {
			throw new QueueOverflowException();
		}
		
		ListNode<T> newNode = new ListNode<T>(e, null);
		if(isEmpty()) {
			firstNode = newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
		size++;
		
		return success;
	}

	/**
	 * This method returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size];

		int i = 0;
		ListNode<T> currentNode = firstNode;
		while((i<size) && (currentNode != null)) {
			result[i] = currentNode.getData();
			i++;
			currentNode = currentNode.getNextNode();
		}

		String re = "";
		for(int j = 0; j<result.length; j++) {
			if(j==result.length-1) {
				re+=(String)result[j];
			}else
				re+=(String)result[j]+delimiter;
		}
		System.out.println(re);

		return re;
		
	}

	/**
	  * This method fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This method returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size];

		int i = 0;
		ListNode<T> currentNode = firstNode;
		while((i<size) && (currentNode != null)) {
			result[i] = currentNode.getData();
			i++;
			currentNode = currentNode.getNextNode();
		}

		String re = "";
		for(int j = 0; j<result.length; j++) {
			re+=String.valueOf(result[j]);

		}
		System.out.println(re);

		return re;
	}
}
	