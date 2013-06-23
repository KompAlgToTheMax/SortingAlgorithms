public class MergeSortAlgorithm {

	private int[] intArr = null;
	private int compareCounter = 0;
	private int writeCounter = 0;

	public MergeSortAlgorithm(int[] arr) {
		intArr = arr;
	}

	public int getCompareCounter() {
		return compareCounter;
	}

	public int getWriteCounter() {
		return writeCounter;
	}

	public int[] sort(int l, int r) {
		compareCounter++;
		if (l < r) {
			int q = (l + r) / 2;

			sort(l, q);
			sort(q + 1, r);
			merge(l, q, r);
		}
		return intArr;
	}

	private void merge(int l, int q, int r) {
		int[] arr = new int[intArr.length];
		int i, j;
		for (i = l; i <= q; i++) {
			writeCounter++;
			arr[i] = intArr[i];
		}
		for (j = q + 1; j <= r; j++) {
			writeCounter++;
			arr[r + q + 1 - j] = intArr[j];
		}
		i = l;
		j = r;
		for (int k = l; k <= r; k++) {
			compareCounter++;
			if (arr[i] <= arr[j]) {
				writeCounter++;
				intArr[k] = arr[i];
				i++;
			} else {
				writeCounter++;
				intArr[k] = arr[j];
				j--;
			}
		}
	}
}
