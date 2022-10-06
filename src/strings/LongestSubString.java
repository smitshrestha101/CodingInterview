package strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {
	public int lengthOfLongestSubstringBrute(String s) {
		System.out.println(s.length());
		if (s == null || s.isEmpty())
			return 0;
		if (s.isBlank())
			return 1;

		int longest = 0;

		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> set = new HashSet<>();
			for (int j = i; j < s.length(); j++) {
				char character = s.charAt(j);
				if (!set.contains(character)) {
					set.add(character);
					longest = Math.max(longest, set.size());
				} else {
					break;
				}
			}
		}
		return longest;

	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1)
			return 1;

		int leftPointer = 0, rightPointer = 0, longest = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		while (rightPointer < s.length()) {
			char rightPointerChar = s.charAt(rightPointer);
			if (!map.containsKey(rightPointerChar)) {
				longest = Math.max(longest, rightPointer - leftPointer);
			} else {
				if (map.get(rightPointerChar) < leftPointer) {
					longest = Math.max(longest, rightPointer - leftPointer);
				} else {
					leftPointer = map.get(rightPointerChar) + 1;
				}
			}
			map.put(rightPointerChar, rightPointer);
			rightPointer++;
		}
		return longest;
	}

}
