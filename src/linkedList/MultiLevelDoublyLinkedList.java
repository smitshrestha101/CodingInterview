package linkedList;

public class MultiLevelDoublyLinkedList {

	public Node flatten(Node head) {
		Node currentNode = head;
		Node childNode = null;

		while (currentNode != null) {
			if (currentNode.child != null) {
				childNode = currentNode.child;
				while (childNode.next != null) {
					childNode = childNode.next;
				}
				Node next = currentNode.next;
				currentNode.next = currentNode.child;
				currentNode.child.prev = currentNode;
				childNode.next = next;
				if (next != null)
					next.prev = childNode;
				currentNode.child = null;
			}
			currentNode = currentNode.next;
		}
		return head;
	}
}
