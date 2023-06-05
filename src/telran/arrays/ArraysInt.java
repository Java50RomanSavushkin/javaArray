package telran.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysInt {
	public static int[] addNumber(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;
		return res;
	}

	public static int[] insertNumber(int[] array, int index, int number) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	public static int[] removeNumber(int[] array, int index) {
		// returns array with no number at the given index
		int[] res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, res.length - index);
		return res;
	}

	public static int[] insertNumberSorted(int[] arraySorted, int number) {
		// takes sorted array and number to insert.
		// returns sorted array with the given number at a proper position.
		// apply the standard method of the class Arrays int binarySearch(int[]
		// arraySorted, int key)
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertNumber(arraySorted, index, number);
	}

	public static int searchNumber(int[] array, int number) {
		// searching for the given number in the given array
		// returns index value for the number if exist otherwise -1
		int index = 0;
		while (index < array.length && array[index] != number) {
			index++;
		}
		return index < array.length ? index : -1;
	}

	public static int binarySearchNumber(int[] array, int number) {

		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && array[middle] != number) {
			if (number < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left <= right ? middle : -1;
	}

	public static int myBinarySearchNumber(int[] array, int number) {
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		int result = -1;
		while (left <= right) {
			if (array[middle] == number) {
				result = middle;
				right = middle - 1;
			} else if (number < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		if (result != -1) {
			return result;
		} else {
			return -(left + 1);
		}
	}

	public static void quickSort(int[] array) {
		Arrays.sort(array); // O[N*LogN]
	}

	public static void bubbleSort(int[] array) {
		int length = array.length;
		boolean flSorted = false;
		do {
			length--;
			flSorted = true;
			for (int i = 0; i < length; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flSorted = false;
				}
			}
		} while (!flSorted);
	}

	private static void swap(int[] array, int i, int j) {
//      swap with no additional variable		
//		array[i] = array[i] + array[j];
//		array[j] = array[i] - array[j];
//		array[i] = array[i] - array[j];
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static int getRandomInt(int min, int max) {
		Random gen = new Random();
		return gen.nextInt(min, max + 1);
	}

}