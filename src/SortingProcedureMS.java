public class SortingProcedureMS {

	private int biggestNumber = 0;
	private int initialArraySize = 0; 
	private int arrayIncrease = 0;
	private int numberOfArrays = 0;
	private int seed = 0;
	private SortStatistic sortStat = null;

	public SortingProcedureMS(int biggestNumber, int initialArraySize,int arrayIncrease,
			int numberOfArrays, int seed, SortStatistic sortStat) {
		this.biggestNumber = biggestNumber;
		this.initialArraySize = initialArraySize;
		this.arrayIncrease = arrayIncrease;
		this.numberOfArrays = numberOfArrays;
		this.seed = seed;
		this.sortStat = sortStat;
	}

	/**
	 * Die Methode instantiiert den RandomArrayGenerator und lässt sich von
	 * diesem mit Zufallszahlen gefüllte Array in verschiedenen Größen zurückgeben.
	 * Des weiteren wird ein Mergesort-Algorithmus instantiiert, mit dessen sort-
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
		
		MergeSortAlgorithm ms = null;

		int sizeMS = initialArraySize;

		for (int i = 1; i <= (arrayIncrease * numberOfArrays); i++) {
			int[] array = rag.getRandomArray(sizeMS, seed, Integer.MAX_VALUE);

			ms = new MergeSortAlgorithm(array);
			ms.sort(0, array.length - 1);

			sortStat.addCompareCounter(ms.getCompareCounter());
			sortStat.addWriteAccessCounter(ms.getWriteCounter());

			sizeMS += arrayIncrease;
		}

		
		
		return sortStat;
	}

}
