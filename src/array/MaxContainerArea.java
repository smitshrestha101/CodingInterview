package array;

public class MaxContainerArea {

	public int maxArea(int[] height) {
		int max = 0;
		int leftPointer = 0;
		int rightPointer = height.length - 1;
		// int i =0;

		while (leftPointer < rightPointer) {
			max = Math.max(max, (Math.min(height[leftPointer], height[rightPointer])) * (rightPointer - leftPointer));
			if (height[leftPointer] < height[rightPointer]) {
				leftPointer++;
			} else {
				rightPointer--;
			}
		}
		return max;
	}
}
