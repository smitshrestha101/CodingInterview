package array;

import java.util.HashMap;

public class TwoSums {

	public int[] findTwoSums(int[] input, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				return new int[] { map.get(input[i]), i };
			} else {
				map.put(target - input[i], i);
			}
		}
		return null;
	}
}
