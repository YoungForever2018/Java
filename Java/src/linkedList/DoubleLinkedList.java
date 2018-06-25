package linkedList;

public class DoubleLinkedList {

	public static void main(String[] args) {

	}
	
	private Node head ;
	private Node tail;
	private int size;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
		size = 0 ;
	}
	
	private class Node{
		private Object data;
		private Node nextNode;
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	public void addHead(Object object){
		Node node = new Node(object);
		if(size == 0){
			head = node;
			tail = node;
		}else{
			node.nextNode = head;
			head = node;
		}
		size++;
	}
	
	public void addTail(Object object){
		Node node = new Node(object);
		if(size == 0){
			head = node;
			tail = node;
		}else{
			tail.nextNode = node;
			tail = node;
		}
		size++;
	}
	
	public boolean removeHead(){
		if(size ==0){
			return false;
		}
		
		if(head.nextNode != null){
			head = head.nextNode;
		}else {
			head = null;
			tail = null;
		}
		size--;
		return true;
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString(){
		if(size==0){
			return "empty";
		}
		
		Node node = head;
		int tempSize = size;
		StringBuilder builder = new StringBuilder();
		while (tempSize >0 ) {
			if(node.nextNode != null){
				builder.append(node.data+"->");
			}else {
				builder.append(node.data);
			}
			node = node.nextNode;
			tempSize--;
		}
		return builder.toString();
	}
}
