package linkedList;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {

		ListNode currentNode = head;
		ListNode next;
		ListNode prev = null;
		while (currentNode != null) {
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}

		return prev;
	}

}
