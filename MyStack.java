import java.util.ArrayList;
import java.util.List;

public class MyStack<T> implements StackInterface<T>{

	
	/**
	 * int length for the initial size of the Stack
	 */
	private int length=100;
	/**
	 * ListNode<T> topNode the first node in the Linked List
	 */
	private ListNode<T> topNode;
	/**
	 * int size the actual size of the Stack 
	 */
	private int size = 0;

	/**
	 * This method creates the Linked List
	 *
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

		private ListNode<T> getNextNode() {
			return next;
		}

		private void setNextNode(ListNode<T> nextNode) {
			next = nextNode;
		}
	}

	/**
	 * This method return the size of the Stack
	 * @return the size of the Stack
	 */
	public int getLength()
	{
		return size;
	}

	/**
	 * Default constructor
	 */
	public MyStack() {
		length = 0;
		topNode = null;
	}
	
	
	/**
	 * This method set the length of the Stack
	 * @param length
	 */
	public MyStack(int length) {
		this.length = length;
		topNode = null;
	}

	/**
	 *This method return if the Stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return topNode==null;
	}

	/**
	 *This method returns if the Stack is full
	 */
	@Override
	public boolean isFull() {
		return size==length;
	}

	/**
	 *This method deletes and returns the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}

		T result = topNode.getData();
		topNode = topNode.getNextNode();
		size--;
		return result;
	}

	/**
	 *This methods returns the element at the top of the Stack, does not pop it off the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException("This should have caused an StackUnderflowException");
		}
		return topNode.getData();
	}

	/**
	 *This method returns the number of elements in the Stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 *This method adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {

		boolean success = true;
		if(isFull()) {
			throw new StackOverflowException();
		}

		ListNode<T> temp = new ListNode<T>(e);
		temp.setNextNode(topNode);
		topNode = temp;
		size++;

		return success;
	}

	/**
	 * This method returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size];

		int i = 0;
		ListNode<T> currentNode = topNode;
		while((i<size) && (currentNode != null)) {
			result[i] = currentNode.getData();
			i++;
			currentNode = currentNode.getNextNode();
		}

		String re = "";
		for(int j = result.length-1; j>=0; j--) {
			if(j==0) {
				re+=(String)result[j];
			}else
				re+=(String)result[j]+delimiter;

		}

		return re;

	}
	
	 /**
	  * This method fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size];
		List<T> returnList=new ArrayList<T>(); 
		returnList.addAll(list);
		ListNode<T> childNode=topNode;
		ListNode<T> lastNode=null;
		
		if(topNode!=null) {
			while((childNode=childNode.getNextNode())!=null) {
				lastNode=childNode;
			};
			
			ListNode<T> listSubNode=null; 
			for(int i=0;i<list.size();i++) {
				ListNode<T> listTempNode = new ListNode<T>(list.get(i));
				if(i==list.size()-1) {
					listTempNode.setNextNode(listSubNode);
					lastNode.setNextNode(listTempNode);
				}else if(i==0){
					listTempNode.setNextNode(null);
				}else {
					listTempNode.setNextNode(listSubNode);
				}
				listSubNode=listTempNode;
			}
			
			size+=list.size();
		}else {
			ListNode<T> listSubNode=null; 
			for(int i=0;i<list.size();i++) {
				ListNode<T> listTempNode = new ListNode<T>(list.get(i));
				if(i==list.size()-1) {
					listTempNode.setNextNode(listSubNode);
					topNode=listTempNode;
				}else if(i==0){
					listTempNode.setNextNode(null);
					listSubNode=listSubNode;
					
				}else {
					listTempNode.setNextNode(listSubNode);
				}
				listSubNode=listTempNode;
			}
			
			size=list.size();
		
		}
		
	
	}
	
	/**
	 * This method returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {

		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size];

		int i = 0;
		ListNode<T> currentNode = topNode;
		while((i<size) && (currentNode != null)) {
			result[i] = currentNode.getData();
			i++;
			currentNode = currentNode.getNextNode();
		}

		String re = "";
		for(int j = result.length-1; j>=0; j--) {
			re+=String.valueOf(result[j]);

		}
		
		System.out.println(re);

		return re;
	}
	

}
