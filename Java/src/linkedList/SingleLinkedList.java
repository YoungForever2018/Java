package linkedList;

public class SingleLinkedList {

	private int size ;   //count of node
	private Node head ;  //head node
	
	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addHead("A");
		linkedList.addHead("B");
		linkedList.addHead("C");
		System.out.println(linkedList.toString());
		
		linkedList.remove("B");
		System.out.println(linkedList.toString());
		
		Node node = linkedList.find("C") ;
		System.out.println(node);
	}

	public SingleLinkedList() {
		size = 0 ;
		head = null;
	}
	
	/*
	 * �ڵ���
	 */
	private class Node{
		private Object data;
		private Node nextNode ;
		
		public Node(Object data) {
			this.data = data ;
		}
	}
	
	/**
	 * ����ͷ�����Ԫ��
	 * @param object
	 * @return
	 */
	public Object addHead(Object object){
		Node newHead = new Node(object);
		if(size ==0){
			head = newHead;
		}else {
			newHead.nextNode = head;
			head = newHead;
		}
		size++;
		return object;
	}
	
	/**
	 * ����ͷ��ɾ��Ԫ��
	 * @author indeed
	 * @return
	 */
	public Object removeHead(){
		Object object = null;
		if(size ==0){
			return object ;
		}else {
		    object = head.data;
			head = head.nextNode ;
		}
		size--;
		return object;
	}
	
	/**
	 * ����ָ��Ԫ��
	 * @param object
	 * @return
	 */
	public Node find(Object object){
		int tempSize = size;

		Node currentNode = head;
		//�ֱ�Ƚ�Ԫ���Ƿ���ָ����object���
		while (tempSize > 0) {
			if(object.equals(currentNode.data)){
				return currentNode;
			}else {
				currentNode = currentNode.nextNode;
			}
			tempSize--;
		}
		return null;
	}
	
	/**
	 * ɾ��ָ��Ԫ��
	 * @param object
	 * @return
	 */
	public boolean remove(Object object){
		boolean b = false;
		if (object == null || size == 0 ) {
			return b ;
		}
		
		Node current = head;
		Node previous = head;
		
		while (!object.equals(current.data)) {
			if(current.nextNode == null){
				return b;
			}
			
			previous = current;
			current = current.nextNode;
		}
		b = true;
		
		if(current == head){
			head = current.nextNode;
		}else{
			previous.nextNode = current.nextNode;
		}
		size--;
		return b;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size==0 ? true:false;
	}
	
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
