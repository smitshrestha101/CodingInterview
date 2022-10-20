package sorting;

import java.util.Arrays;

public class BasicSorting {

	public int[] bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	public int[] selectionSort(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			int smallestVal = array[i];
			int smallestIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (array[j] < smallestVal) {
					smallestVal = array[j];
					smallestIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[smallestIndex];
			array[smallestIndex] = temp;
		}
		return array;
	}

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(array, left, right);
			quickSort(array, left, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		int partitionIndex = left;
		int pivot = array[right];
		for (int j = left; j < right; j++) {
			if (array[j] < pivot) {
				swap(array, partitionIndex, j);
				partitionIndex++;
			}
		}
		swap(array, partitionIndex, right);
		return partitionIndex;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

}
