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

		/**
		 * l ist der erste Teil-Array-Index, r ist der letzte Teil-Array-Index.
		 * Wenn r und l gleich sind, ist das Teil-Array nur noch ein Element
		 * groß. Dies ist die Abbruchbedingung für die Rekursion.
		 */
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
		/**
		 * Das zu sortierende Array wird fortlaufend rekursiv in zwei Teile aufgeteilt. 
		 * Die Teilstücke werden über ein Hilfsarray (arr) sortiert und im Ausgangsarray 
		 * zusammengeführt.
		 */
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
