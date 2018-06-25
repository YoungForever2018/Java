package linkedList;

public class DoubleLinkedQueue {

	public static void main(String[] args) {

	}

	private DoubleLinkedList linkedList;
	
	public DoubleLinkedQueue() {
		linkedList = new DoubleLinkedList();
	}
	
	public void insert(Object object) {
		linkedList.addTail(object);
	}
	
	public void remove(){
		linkedList.removeHead();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public int size() {
		return linkedList.size();
	}
	
	public String toString() {
		return linkedList.toString();
	}
}
