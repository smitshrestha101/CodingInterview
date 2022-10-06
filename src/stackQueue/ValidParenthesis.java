package stackQueue;

import java.util.Stack;

public class ValidParenthesis {

	public boolean isValid(String s) {
		if (s.isEmpty())
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char character = s.charAt(i);
			if (character == '(' || character == '{' || character == '[')
				stack.add(character);
			if (character == ')' || character == '}' || character == ']') {
				if (stack.isEmpty())
					return false;
				char stackReturnedChar = stack.pop();
				if (!checkForRightParenthesis(stackReturnedChar, character))
					return false;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}

	private boolean checkForRightParenthesis(char stackReturnedChar, char currentChar) {
		if (stackReturnedChar == '(' && currentChar == ')') {
			return true;
		} else if (stackReturnedChar == '[' && currentChar == ']') {
			return true;
		} else if (stackReturnedChar == '{' && currentChar == '}') {
			return true;
		}
		return false;

	}
}
