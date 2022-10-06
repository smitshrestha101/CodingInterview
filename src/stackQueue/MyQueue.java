package stackQueue;

import java.util.Stack;

class MyQueue {
	Stack<Integer> firstStack;
	Stack<Integer> secondStack;

	public MyQueue() {
		firstStack = new Stack<>();
		secondStack = new Stack<>();
	}

	public void push(int x) {
		firstStack.push(x);
	}

	public int pop() {
		while (!firstStack.isEmpty()) {
			secondStack.push(firstStack.pop());
		}
		int result = secondStack.pop();
		while (!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());
		}
		secondStack.clear();
		return result;
	}

	public int peek() {

		while (!firstStack.isEmpty()) {
			secondStack.push(firstStack.pop());
		}
		int result = secondStack.peek();
		while (!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());
		}
		secondStack.clear();
		return result;

	}

	public boolean empty() {
		return firstStack.isEmpty();
	}
}
