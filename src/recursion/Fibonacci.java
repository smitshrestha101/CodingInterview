package recursion;

public class Fibonacci {

	public int findFibonacciIterative(int num) {
		int a = 0;
		int b = 1;
		int counter = 2;
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		while (counter <= num) {
			int temp = a + b;
			a = b;
			b = temp;
			counter++;
		}
		return b;
	}

	public int findFibonacciRecursive(int num) {
		if (num < 2)
			return num;
		return findFibonacciRecursive(num - 1) + findFibonacciRecursive(num - 2);
	}

}
