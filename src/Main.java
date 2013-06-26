
public class Main {

	public static void main(String[] args) {

		RandomArrayGenerator rag = new RandomArrayGenerator();

		SortStatistic sortStat = new SortStatistic();
		sortStat.setBiggestNumber(Integer.MAX_VALUE);
		sortStat.setNumberIncrease(1);
		sortStat.setNumberOfArrays(10000);
		sortStat.setSeed(0);

		QuickSortAlgorithm qsa = null;

		int size = sortStat.getNumberIncrease();
		
		for (int i = 1;i<(sortStat.getNumberIncrease()*sortStat.getNumberOfArrays());i++) {
			int[] array = rag.getRandomArray(size, 0, Integer.MAX_VALUE);
			
			qsa = new QuickSortAlgorithm(array);
			qsa.sort(0, array.length - 1);
			
			sortStat.addCompareCounter(qsa.getCompareCounter());
			sortStat.addWriteAccessCounter(qsa.getWriteCounter());
			
			size+=sortStat.getNumberIncrease();
		}

		CSVWriter csvWriteQS = new CSVWriter();
		csvWriteQS.setSortStatistic(sortStat);
		csvWriteQS.setMeasurementName("QS");
		csvWriteQS.writeStatistic();
		csvWriteQS.writeCompares();
		csvWriteQS.writeWritingAccesses();

		MergeSortAlgorithm ms = null;

		
		sortStat = new SortStatistic();
		sortStat.setBiggestNumber(Integer.MAX_VALUE);
		sortStat.setNumberIncrease(1);
		sortStat.setNumberOfArrays(10000);
		sortStat.setSeed(0);

		
		int sizeMS = sortStat.getNumberIncrease();
		
		for (int i = 1;i<(sortStat.getNumberIncrease()*sortStat.getNumberOfArrays());i++) {
			int[] array = rag.getRandomArray(sizeMS, 0, Integer.MAX_VALUE);
			
			ms = new MergeSortAlgorithm(array);
  			ms.sort(0, array.length - 1);
			
  			sortStat.addCompareCounter(ms.getCompareCounter());
  			sortStat.addWriteAccessCounter(ms.getWriteCounter());
			
			sizeMS+=sortStat.getNumberIncrease();
		}
		
		CSVWriter csvWriteMS = new CSVWriter();
		csvWriteMS.setSortStatistic(sortStat);
		csvWriteMS.setMeasurementName("MS");
		csvWriteMS.writeStatistic();
		csvWriteMS.writeCompares();
		csvWriteMS.writeWritingAccesses();
	}
}
