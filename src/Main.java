import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		RandomArrayGenerator rag = new RandomArrayGenerator();

		SortStatistic sortStatQS = new SortStatistic();
		sortStatQS.setBiggestNumber(Integer.SIZE);
		sortStatQS.setNumberIncrease(10);
		sortStatQS.setNumberOfArrays(100);
		sortStatQS.setSeed(0);

		ArrayList<int[]> arrayList = rag.getRandomArrays(
				sortStatQS.getNumberOfArrays(), sortStatQS.getNumberIncrease(),
				sortStatQS.getSeed(), sortStatQS.getBiggestNumber());

		QuickSortAlgorithm qsa = null;

		for (int[] array : arrayList) {
			qsa = new QuickSortAlgorithm(array);
			qsa.sort(0, array.length - 1);
			sortStatQS.addCompareCounter(qsa.getCompareCounter());
			sortStatQS.addWriteAccessCounter(qsa.getWriteCounter());
		}

		CSVWriter csvWriteQS = new CSVWriter("QS", sortStatQS);
		csvWriteQS.writeStatistic();
		csvWriteQS.writeCompares();
		csvWriteQS.writeWritingAccesses();

		MergeSortAlgorithm ms = null;

		SortStatistic sortStatMS = new SortStatistic();
		sortStatMS.setBiggestNumber(10000);
		sortStatMS.setNumberIncrease(2);
		sortStatMS.setNumberOfArrays(10);
		sortStatMS.setSeed(0);

		for (int[] array : arrayList) {
			ms = new MergeSortAlgorithm(array);
			ms.sort(0, array.length - 1);
			sortStatMS.addCompareCounter(ms.getCompareCounter());
			sortStatMS.addWriteAccessCounter(ms.getWriteCounter());
		}

		CSVWriter csvWriteMS = new CSVWriter("MS", sortStatMS);
		csvWriteMS.writeStatistic();
		csvWriteMS.writeCompares();
		csvWriteMS.writeWritingAccesses();
	}
}
