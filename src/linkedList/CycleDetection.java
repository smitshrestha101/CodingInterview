package linkedList;

public class CycleDetection {

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode tortoiseNode = head;
		ListNode hareNode = head;
		int counter = 0;
		boolean matchFound = false;

		while (hareNode.next != null && hareNode.next.next != null) {
			tortoiseNode = tortoiseNode.next;
			hareNode = hareNode.next.next;
			if (tortoiseNode == hareNode) {
				matchFound = true;
				break;
			}
			counter++;
		}

		if (!matchFound) {
			return null;
		} else {
			ListNode cycledetectPointer = head;
			while (cycledetectPointer != hareNode) {
				cycledetectPointer = cycledetectPointer.next;
				hareNode = hareNode.next;
			}
			return cycledetectPointer;
		}
	}

}
