package recursion;

public class Factorial {

	public int findFactorialRecursive(int number) {
		if (number == 0 || number == 1)
			return 1;

		return number * findFactorialRecursive(number - 1);
	}

	public int findFactorialIterative(int number) {
		if (number == 0)
			return 1;
		int factorial = 1;
		for (int i = number; i >= 1; i--) {
			factorial *= i;
		}
		return factorial;
	}

}
