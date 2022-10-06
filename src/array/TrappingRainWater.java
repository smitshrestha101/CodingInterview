package array;

public class TrappingRainWater {

	// two pointers solution
	public int trap(int[] height) {
		int total = 0;
		int maxLeft = 0, maxRight = 0;
		int leftPointer = 0;
		int rightPointer = height.length - 1;

		while (leftPointer < rightPointer) {
			if (height[leftPointer] <= height[rightPointer]) {
				if (height[leftPointer] < maxLeft) {
					total += (maxLeft - height[leftPointer]);
				} else {
					maxLeft = height[leftPointer];
				}
				leftPointer++;
			} else {
				if (height[rightPointer] < maxRight) {
					total += (maxRight - height[rightPointer]);
				} else {
					maxRight = height[rightPointer];
				}
				rightPointer--;
			}
		}
		return total;
	}

	// dynamic programming solution
	/*
	 * int trap(vector<int>& height) { if(height.empty()) return 0; int ans = 0; int
	 * size = height.size(); vector<int> left_max(size), right_max(size);
	 * left_max[0] = height[0]; for (int i = 1; i < size; i++) { left_max[i] =
	 * max(height[i], left_max[i - 1]); } right_max[size - 1] = height[size - 1];
	 * for (int i = size - 2; i >= 0; i--) { right_max[i] = max(height[i],
	 * right_max[i + 1]); } for (int i = 1; i < size - 1; i++) { ans +=
	 * min(left_max[i], right_max[i]) - height[i]; } return ans; }
	 */

	// stack solution
	/*
	 * int trap(vector<int>& height) { int ans = 0, current = 0; stack<int> st;
	 * while (current < height.size()) { while (!st.empty() && height[current] >
	 * height[st.top()]) { int top = st.top(); st.pop(); if (st.empty()) break; int
	 * distance = current - st.top() - 1; int bounded_height = min(height[current],
	 * height[st.top()]) - height[top]; ans += distance * bounded_height; }
	 * st.push(current++); } return ans; }
	 */

}
