package strings;

public class ValidPalindrome {

	public boolean validPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		if (s.length() <= 2)
			return true;

		int leftPointer = 0, rightPointer = s.length() - 1;

		while (leftPointer < rightPointer) {
			if (s.charAt(leftPointer) != s.charAt(rightPointer)) {

				return isPalindrome(s, leftPointer + 1, rightPointer) || isPalindrome(s, leftPointer, rightPointer - 1);
			}
			leftPointer++;
			rightPointer--;
		}
		return true;

	}

	public boolean isPalindrome(String s, int leftPointer, int rightPointer) {

		while (leftPointer < rightPointer) {
			if (s.charAt(leftPointer) == s.charAt(rightPointer)) {
				leftPointer++;
				rightPointer--;
			} else {
				return false;
			}
		}

		return true;
	}
}
