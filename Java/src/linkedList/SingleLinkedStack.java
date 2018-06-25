package linkedList;

public class SingleLinkedStack {

	public static void main(String[] args) {

		
	}

	private SingleLinkedList linkedList;
	
	public SingleLinkedStack() {
		linkedList = new SingleLinkedList();
	}
	
	/**
	 * ���Ԫ��
	 * @param object
	 */
	public void push(Object object) {
		linkedList.addHead(object);
	}
	
	/**
	 * �Ƴ�ջ��Ԫ��
	 */
	public Object pop() {
		return linkedList.removeHead();
	}
	
	/**
	 * �ж��Ƿ�Ϊ��
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
