package algorithms;

public class ListNode {
	private Value<?> value;
	private ListNode next;
	
	public ListNode(Value<?> value) {
		this.value = value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public Value<?> getValue() {
		return value;
	}
}
