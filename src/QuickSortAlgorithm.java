public class QuickSortAlgorithm {

	public static int[] intArr = null;
	private int compareCounter = 0;
	
	public QuickSortAlgorithm(int[] arr) {
		intArr = arr;
	}
	
	public int getCompareCounter() {
		return compareCounter;
	}

	public int[] sort(int left, int right) {
		compareCounter++;
		if (left < right) {
			int indexPivot = partition(left, right);
			sort(left, indexPivot);
			sort(indexPivot + 1, right);
		}
		return intArr;
	}

	int partition(int left, int right) {
		
		int low = left - 1;
		int high = right + 1;
		int pivot = intArr[(left + right) / 2];

		do {
			low++;
		} while (intArr[low] < pivot);

		do {
			high--;
		} while (intArr[high] > pivot);

		compareCounter++;
		if (low < high) {
			int k = intArr[low];
			intArr[low] = intArr[high];
			intArr[high] = k;
		} else {
			return high;
		}
		return -1;
	}

}
