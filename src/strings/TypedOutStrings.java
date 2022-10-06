package strings;

import java.util.ArrayList;
import java.util.List;

public class TypedOutStrings {

	public boolean backspaceCompareBruteForce(String s, String t) {
		char[] arrayS = s.toCharArray();
		char[] arrayT = t.toCharArray();

		List<Character> listS = new ArrayList<>();
		List<Character> listT = new ArrayList<>();

		if (arrayS != null && arrayS.length > 0) {
			for (char c : arrayS) {
				if (c != '#') {
					listS.add(c);
				} else if (c == '#' && !listS.isEmpty()) {
					listS.remove(listS.size() - 1);
				}
			}
		}

		if (arrayT != null && arrayT.length > 0) {
			for (char c : arrayT) {
				if (c != '#') {
					listT.add(c);
				} else if (c == '#' && !listT.isEmpty()) {
					listT.remove(listT.size() - 1);
				}
			}
		}

		if (listS.size() == 0 && listT.size() == 0) {
			return true;
		} else if (listS.size() != listT.size()) {
			return false;
		} else {
			for (int i = 0; i < listS.size(); i++) {
				if (listS.get(i) != listT.get(i)) {
					return false;
				}
			}
			return true;
		}

	}

	public boolean backspaceCompare(String s, String t) {
		int pointerS = s.length() - 1;
		int pointerT = t.length() - 1;

		while (pointerS >= 0 || pointerT >= 0) {
			if (s.charAt(pointerS) == '#' || t.charAt(pointerT) == '#') {
				if (s.charAt(pointerS) == '#') {
					pointerS = movePointer(pointerS, s);
				}

				if (t.charAt(pointerT) == '#') {
					pointerT = movePointer(pointerT, t);
				}
			} else {
				if (s.charAt(pointerS) != t.charAt(pointerT)) {
					return false;
				} else {
					pointerS--;
					pointerT--;
				}
			}
		}
		return true;

	}

	private int movePointer(int pointer, String str) {
		int counter = 2;
		while (counter > 0) {
			pointer--;
			counter--;

			if (str.charAt(pointer) == '#') {
				counter += 2;
			}
		}
		return pointer;
	}

}

class Solution {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;

		while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
			while (i >= 0) { // Find position of next possible char in build(S)
				if (S.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else
					break;
			}
			while (j >= 0) { // Find position of next possible char in build(T)
				if (T.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else
					break;
			}
			// If two actual characters are different
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
				return false;
			// If expecting to compare char vs nothing
			if ((i >= 0) != (j >= 0))
				return false;
			i--;
			j--;
		}
		return true;
	}
}
