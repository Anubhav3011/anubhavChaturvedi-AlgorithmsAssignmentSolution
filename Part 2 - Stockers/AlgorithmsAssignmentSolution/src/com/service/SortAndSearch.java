package com.service;

public class SortAndSearch<T extends Number> {

	private boolean descOrder;

	public T[] getSortedArray(T[] array, boolean descOrder, T[] temp) {
		this.descOrder = descOrder;
		// Recursively Perform Merge SortArrays
		mergeSort(array, temp, 0, array.length - 1);
		return array;
	}

	// Merge Sort Recursion
	private void mergeSort(T[] array, T[] temp, int myLeft, int myRight) {

		if (myLeft < myRight) {
			int center = (myLeft + myRight) / 2;
			mergeSort(array, temp, myLeft, center);
			mergeSort(array, temp, center + 1, myRight);
			merge(array, temp, myLeft, center + 1, myRight);
		}
	}

	// Merge Sort Algorithm
	private void merge(T[] array, T[] temp, int left, int myRight, int rightMost) {
		int leftEnd = myRight - 1;
		int k = left;
		int num = rightMost - left + 1;

		while (left <= leftEnd && myRight <= rightMost) {
			if (descOrder ? (array[left].doubleValue() > array[myRight].doubleValue())
					: (array[left].doubleValue() < array[myRight].doubleValue()))
				temp[k++] = array[left++];
			else
				temp[k++] = array[myRight++];
		}

		while (left <= leftEnd)
			temp[k++] = array[left++];

		while (myRight <= rightMost)
			temp[k++] = array[myRight++];

		for (int i = 0; i < num; i++, rightMost--)
			array[rightMost] = temp[rightMost];

	}

	// Binary Search
	public int searchKey(T[] array, T key) {
		return (binarySearch(array, 0, array.length - 1, key));
	}

	// Binary Search Algorithm
	public int binarySearch(T[] array, int left, int right, T key) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			if (array[mid].doubleValue() == key.doubleValue())
				return mid;

			if (array[mid].doubleValue() > key.doubleValue())
				return binarySearch(array, left, mid - 1, key);

			return binarySearch(array, mid + 1, right, key);
		}
		return -1;
	}
}
