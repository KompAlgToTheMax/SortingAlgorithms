public class QuickSortAlgorithm {

	public static int[] intArr = null;
	private int compareCounter = 0;
	private int writeCounter = 0;

	public QuickSortAlgorithm(int[] arr) {
		intArr = arr;
	}

	public int getCompareCounter() {
		return compareCounter;
	}

	public int getWriteCounter() {
		return writeCounter;
	}

	public void sort(int low, int high) {
		int i = low, j = high, tmp;
		int pivot = intArr[(low + high) / 2];

		{
			compareCounter++;
			while (intArr[i] < pivot) {
				compareCounter++;
				i++;
			}
			compareCounter++;
			while (intArr[j] > pivot) {
				compareCounter++;
				j--;
			}

			if (i <= j) {
				tmp = intArr[i];
				writeCounter += 2;
				intArr[i] = intArr[j];
				intArr[j] = tmp;
				i++;
				j--;
			}
		}

		if (low < j) {
			sort(low, j);
		}
		if (i < high) {
			sort(i, high);
		}
	}
}
