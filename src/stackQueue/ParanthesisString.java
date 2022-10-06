package stackQueue;

import java.util.ArrayList;
import java.util.Stack;

public class ParanthesisString {

	public String minRemoveToMakeValid(String s) {
		if (s.isEmpty())
			return s;

		StringBuilder finalString = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		ArrayList<Integer> leftParanthesisIndex = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (currentChar == ')') {
				if (!stack.isEmpty()) {
					finalString.append(currentChar);
					stack.pop();
				}
			} else if (currentChar == '(') {
				stack.add(currentChar);
				leftParanthesisIndex.add(finalString.length());
				finalString.append(currentChar);
			} else {
				finalString.append(currentChar);
			}
		}
		while (!stack.isEmpty()) {
			finalString.deleteCharAt(leftParanthesisIndex.get(leftParanthesisIndex.size() - 1));
			leftParanthesisIndex.remove(leftParanthesisIndex.size() - 1);
			stack.pop();
		}
		return finalString.toString();

	}
}
