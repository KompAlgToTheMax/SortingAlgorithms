public class SortingProcedureQS {

	private int biggestNumber = 0;
	private int initialArraySize = 0; 
	private int arrayIncrease = 0;
	private int numberOfArrays = 0;
	private int seed = 0;
	private SortStatistic sortStat = null;

	public SortingProcedureQS(int biggestNumber, int initialArraySize,int arrayIncrease,
			int numberOfArrays, int seed, SortStatistic sortStat) {
		this.biggestNumber = biggestNumber;
		this.arrayIncrease = arrayIncrease;
		this.initialArraySize = initialArraySize;
		this.numberOfArrays = numberOfArrays;
		this.seed = seed;
		this.sortStat = sortStat;
	}

	/**
	 * Die Methode instantiiert den RandomArrayGenerator und lässt sich von
	 * diesem mit Zufallszahlen gefüllte Array in verschiedenen Größen zurückgeben.
	 * Des weiteren wird ein Quicksort-Algorithmus instantiiert, mit dessen sort-
	 * Methode die Arrays sortiert werden. Die Ergebnisse der Sortiervorgänge 
	 * (Vergleiche/schreibende Zugriffe) werden in der proceed-Methode in das
	 * SortStatistic-Objekt geschrieben.
	 * 
	 * @return: Ein gefülltes SortStatistic-Objekt.
	 */
	public SortStatistic proceed() {
		RandomArrayGenerator rag = new RandomArrayGenerator();

		sortStat.setBiggestNumber(biggestNumber);
		sortStat.setArrayIncrease(arrayIncrease);
		sortStat.setNumberOfArrays(numberOfArrays);
		sortStat.setSeed(seed);
		
		QuickSortAlgorithm qsa = null;

		int size = initialArraySize;
		
		
		for (int i = 1; i <= (arrayIncrease * numberOfArrays); i++) {
			int[] array = rag.getRandomArray(size, seed, Integer.MAX_VALUE);

			qsa = new QuickSortAlgorithm(array);
			qsa.sort(0, array.length - 1);

			sortStat.addCompareCounter(qsa.getCompareCounter());
			sortStat.addWriteAccessCounter(qsa.getWriteCounter());

			size += arrayIncrease;
		}

		return sortStat;
	}

}
