package algs.binarysearch;

public class BinarySearch {

	public static int rank(int key, int[] values) {
		int low = 0;
		int high = values.length - 1;
		while(low <= high) {
			int middle = low + (high - low) / 2;
			if(key < values[middle]) {
			  high = middle - 1;
			} else if(key > values[middle]) {
			  low = middle + 1;
			} else {
			  return middle;
			}
		}
		return -1;
	}
}
