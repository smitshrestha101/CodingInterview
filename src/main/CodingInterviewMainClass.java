package main;

import linkedList.ListNode;
import linkedList.ReverseLinkedListII;

public class CodingInterviewMainClass {

	public static void main(String[] args) {
//		// TwoSums
//		TwoSums twoSums = new TwoSums();
//		System.out.println(Arrays.toString(twoSums.findTwoSums(new int[] { 1, 3, 7, 9, 2 }, 11)));

//		MaxContainerArea
//		MaxContainerArea maxContainerArea = new MaxContainerArea();
//		System.out.println(maxContainerArea.maxArea(new int[] { 2, 3, 4, 5, 18, 17, 6 }));

//		TypedOutStrings
//		TypedOutStrings typedOutStrings = new TypedOutStrings();
//		System.out.println(typedOutStrings.backspaceCompare("ab#z##c", "ab#c"));

//		ValidPalindrome vp = new ValidPalindrome();
//		System.out.println(vp.validPalindrome("ab"));

//		ReversedLinkedListII
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;

		ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
		ListNode resultNode = reverseLinkedListII.reverseBetween(head, 3, 5);
		while (resultNode != null) {
			System.out.println(resultNode.val);
			resultNode = resultNode.next;

		}
	}

}