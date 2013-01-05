package algorithms;

public class MyLinkedList {
	
	private ListNode head;

	public MyLinkedList(ListNode head) {
		this.head = head;
	}
	
	public void addFirst(ListNode newNode) {
		newNode.setNext(head);
		head = newNode;
	}
	
	public void reverse() {
		ListNode t;
		ListNode y = head; 
		ListNode r = null; 
		
		while(y != null) {
			t = y.getNext(); // save
			y.setNext(r); 
			r = y; // now last
			y = t; // now first
		}
	}

}
