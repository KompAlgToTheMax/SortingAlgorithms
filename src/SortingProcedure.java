
public class SortingProcedure {

	private int BiggestNumber = 0;
	private int ArrayIncrease = 0;
	private int NumberOfArrays = 0;
	private int Seed = 0;
	
	public SortingProcedure(int BiggestNumber,int ArrayIncrease,int NumberOfArrays,int Seed) {
		this.BiggestNumber = BiggestNumber;
		this.ArrayIncrease = ArrayIncrease;
		this.NumberOfArrays = NumberOfArrays;
		this.Seed = Seed;
	}
	
	public void proceed() {
		RandomArrayGenerator rag = new RandomArrayGenerator();

		SortStatistic sortStat = new SortStatistic();
		sortStat.setBiggestNumber(BiggestNumber);
		sortStat.setArrayIncrease(ArrayIncrease);
		sortStat.setNumberOfArrays(NumberOfArrays);
		sortStat.setSeed(Seed);

		QuickSortAlgorithm qsa = null;

		int size = sortStat.getArrayIncrease();
		
		for (int i = 1;i<(sortStat.getArrayIncrease()*sortStat.getNumberOfArrays());i++) {
			int[] array = rag.getRandomArray(size, Seed, Integer.MAX_VALUE);
			
			qsa = new QuickSortAlgorithm(array);
			qsa.sort(0, array.length - 1);
			
			sortStat.addCompareCounter(qsa.getCompareCounter());
			sortStat.addWriteAccessCounter(qsa.getWriteCounter());
			
			size+=sortStat.getArrayIncrease();
		}

		CSVWriter csvWrite = new CSVWriter();
		csvWrite.setSortStatistic(sortStat);
		csvWrite.createMeasurementDir();
		csvWrite.setMeasurementName("QS");
		csvWrite.writeStatistic();
		csvWrite.writeCompares();
		csvWrite.writeWritingAccesses();

		MergeSortAlgorithm ms = null;

		sortStat = new SortStatistic();
		sortStat.setBiggestNumber(BiggestNumber);
		sortStat.setArrayIncrease(ArrayIncrease);
		sortStat.setNumberOfArrays(NumberOfArrays);
		sortStat.setSeed(Seed);
		
		int sizeMS = sortStat.getArrayIncrease();
		
		for (int i = 1;i<(sortStat.getArrayIncrease()*sortStat.getNumberOfArrays());i++) {
			int[] array = rag.getRandomArray(sizeMS, Seed, Integer.MAX_VALUE);
			
			ms = new MergeSortAlgorithm(array);
  			ms.sort(0, array.length - 1);
			
  			sortStat.addCompareCounter(ms.getCompareCounter());
  			sortStat.addWriteAccessCounter(ms.getWriteCounter());
			
			sizeMS+=sortStat.getArrayIncrease();
		}
		
		csvWrite.setSortStatistic(sortStat);
		csvWrite.setMeasurementName("MS");
		csvWrite.writeCompares();
		csvWrite.writeWritingAccesses();
	}
	
}
