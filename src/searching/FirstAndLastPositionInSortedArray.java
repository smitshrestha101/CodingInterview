package searching;

public class FirstAndLastPositionInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int foundIndex = binarySearch(nums, target);
		if (foundIndex != -1) {
			int tempLeft = foundIndex;
			int tempRight = foundIndex;
			while (tempLeft > 0 && nums[tempLeft - 1] == target) {
				tempLeft--;
			}
			while (tempRight < nums.length - 1 && nums[tempRight + 1] == target) {
				tempRight++;
			}
			return new int[] { tempLeft, tempRight };
		} else {
			return new int[] { -1, -1 };
		}
	}

	private int binarySearch(int[] nums, int target) {
		int leftPointer = 0;
		int rightPointer = nums.length - 1;
		while (leftPointer <= rightPointer) {
			int midValue = (int) Math.floor((leftPointer + rightPointer) / 2);
			if (nums[midValue] == target) {
				return midValue;
			} else if (nums[midValue] > target) {
				rightPointer = midValue - 1;
			} else {
				leftPointer = midValue + 1;
			}
		}
		return -1;
	}

	public int[] searchRangeOptimal(int[] nums, int target) {
		int foundIndex = binarySearchOptimal(nums, target, 0, nums.length - 1);
		if (foundIndex != -1) {
			int leftIndex = foundIndex;
			int rightIndex = foundIndex;
			while (foundIndex != -1) {
				leftIndex = foundIndex;
				foundIndex = binarySearchOptimal(nums, target, 0, foundIndex - 1);
			}
			foundIndex = rightIndex;
			while (foundIndex != -1) {
				rightIndex = foundIndex;
				foundIndex = binarySearchOptimal(nums, target, foundIndex + 1, nums.length - 1);
			}
			return new int[] { leftIndex, rightIndex };
		} else {
			return new int[] { -1, -1 };
		}
	}

	private int binarySearchOptimal(int[] nums, int target, int leftPointer, int rightPointer) {
		while (leftPointer <= rightPointer) {
			int midValue = (int) Math.floor((leftPointer + rightPointer) / 2);
			if (nums[midValue] == target) {
				return midValue;
			} else if (nums[midValue] > target) {
				rightPointer = midValue - 1;
			} else {
				leftPointer = midValue + 1;
			}
		}
		return -1;
	}


}
