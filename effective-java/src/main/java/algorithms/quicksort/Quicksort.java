package algorithms.quicksort;

public class Quicksort {
	private static int[] numbers = {22,21,45,65,32};//,99,34,20};
	public Quicksort() {
		super();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quicksort q = new Quicksort();
		q.quicksort(0, numbers.length - 1);
		for(int i:numbers) {
			System.out.println("i " + numbers[i]);
		}
	}
	private void quicksort(int low, int high) {
		int i = low;
		int j = high;
		
		int pivot = numbers[low + (high-low)/2];
		while(i < j) {
			while(numbers[i] < pivot) {
				i++;
			}
			
			while(numbers[j] > pivot) {
				j--;
			}
			exchange(i,j);
			for(int k: numbers) {
				System.out.println("k " + k);
			}
			if(low < j) {
				quicksort(low,j);
			}
			if(i < high) {
				quicksort(i,high);
			}
		}
		
	}
	
	private void exchange(int i, int j) {
		if(i <= j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
	}
}
