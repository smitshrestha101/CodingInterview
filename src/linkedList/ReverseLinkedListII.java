package linkedList;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		int counter = 1;
		ListNode currentNode = head;
		ListNode startNode = head;
		ListNode tailNode = null;
		ListNode next;
		ListNode prev = null;
		ListNode afterStartNode = null;

		while (counter <= right) {
			if (counter == left - 1) {
				startNode = currentNode;
			}
			if (counter == right) {
				tailNode = currentNode;
			}
			if (counter == left) {
				afterStartNode = currentNode;
			}
			if (counter >= left && counter <= right) {
				next = currentNode.next;
				currentNode.next = prev;
				prev = currentNode;
				currentNode = next;
			} else {
				currentNode = currentNode.next;
			}
			counter++;
		}
		startNode.next = prev;
		afterStartNode.next = currentNode;

		if (left > 1) {
			return head;
		} else {
			return prev;
		}
	}

}
