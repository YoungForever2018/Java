package linkedList;

public class SingleLinkedStack {

	public static void main(String[] args) {

		
	}

	private SingleLinkedList linkedList;
	
	public SingleLinkedStack() {
		linkedList = new SingleLinkedList();
	}
	
	/**
	 * Ìí¼ÓÔªËØ
	 * @param object
	 */
	public void push(Object object) {
		linkedList.addHead(object);
	}
	
	/**
	 * ÒÆ³ıÕ»¶¥ÔªËØ
	 */
	public Object pop() {
		return linkedList.removeHead();
	}
	
	/**
	 * ÅĞ¶ÏÊÇ·ñÎª¿Õ
	 * @return
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	@Override
	public String toString() {
		return linkedList.toString();
	}
}
