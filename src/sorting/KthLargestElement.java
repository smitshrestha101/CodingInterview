package sorting;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}

	public int findKthLargestQuickSelect(int[] nums, int k) {
		quickSelect(nums, 0, nums.length - 1, nums.length - k);
		return nums[nums.length - k];
	}

	private int quickSelect(int[] nums, int left, int right, int indexRequired) {

		if (left < right) {
			int partitionIndex = partition(nums, left, right);
			if (partitionIndex == indexRequired) {
				return nums[partitionIndex];
			} else if (partitionIndex > indexRequired) {
				return quickSelect(nums, left, partitionIndex - 1, indexRequired);
			} else {
				return quickSelect(nums, partitionIndex + 1, right, indexRequired);
			}
		}
		return -1;
	}

	private void quickSort(int[] nums, int left, int right) {

		if (left < right) {
			int partitionIndex = partition(nums, left, right);
			quickSort(nums, left, partitionIndex - 1);
			quickSort(nums, partitionIndex + 1, right);
		}
	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int partitionIndex = left;
		for (int j = left; j < right; j++) {
			if (nums[j] < pivot) {
				swap(nums, partitionIndex, j);
				partitionIndex++;
			}
		}
		swap(nums, partitionIndex, right);
		return partitionIndex;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
