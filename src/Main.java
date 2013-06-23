import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		RandomArrayGenerator rag = new RandomArrayGenerator();

		SortStatistic sortStat = new SortStatistic();
		sortStat.setBiggestNumber(10000);
		sortStat.setNumberIncrease(2);
		sortStat.setNumberOfArrays(20);
		sortStat.setSeed(0);

		ArrayList<int[]> arrayList = rag.getRandomArrays(
				sortStat.getNumberOfArrays(), sortStat.getNumberIncrease(),
				sortStat.getSeed(), sortStat.getBiggestNumber());

		MergeSortAlgorithm ms = null;
		
		for(int[] array : arrayList) {
			ms = new MergeSortAlgorithm(array);
			ms.sort(0, array.length-1);
			sortStat.addCompareCounter(ms.getCompareCounter());
			sortStat.addWriteAccessCounter(ms.getWriteCounter());
		}

		CSVWriter csvWrite = new CSVWriter(sortStat);
		csvWrite.writeStatistic();
		csvWrite.writeCompares();
		csvWrite.writeWritingAccesses();
		
		// QuickSortAlgorithm qsa = new QuickSortAlgorithm(intArr);
		// System.out.println("Compare Counter (MERGESORT): "+
		// Integer.toString(ms.getCompareCounter()));
		// System.out.println("Write Counter (MERGESORT): "+
		// Integer.toString(ms.getWriteCounter()));
	}
}
