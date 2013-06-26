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

		
		// aufteilen und sortieren
		while (i <= j) {
			
			/**
			 * Wandere mit i nach rechts, bis ein Wert größer oder gleich dem
			 * Pivotelement gefunden wurde. Entsprechend wird mit j nach links
			 * gewandert, bis ein Wert kleiner oder gleich dem Pivotelement gefunden
			 * wird:
			 */
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

			/**
			 * Wenn sich i und j noch nicht ueberkreuzt haben, steht rechts ein
			 * kleinerer Wert als links, also werden die Werte bei i und j
			 * vertauscht und i und j weiterbewegt:
			 */
			if (i <= j) {
				tmp = intArr[i];
				writeCounter += 2;
				intArr[i] = intArr[j];
				intArr[j] = tmp;
				i++;
				j--;
			}
		}

		/** 
		 * Rekursion: (nur solange das Teil-Array noch mindestens
		 * zwei Elemente hat, der linke Index also echt kleiner als 
		 * der rechte Index ist.)
		 */
		if (low < j) {
			sort(low, j);
		}
		if (i < high) {
			sort(i, high);
		}
	}
}
