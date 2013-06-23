import java.util.ArrayList;

public class SortStatistic {

	private ArrayList<Integer> valuesCompares = new ArrayList<Integer>();
	private ArrayList<Integer> writeAccesses = new ArrayList<Integer>();
	private int numberOfArrays = 0;
	private int biggestNumber = 0;
	private int numberIncrease = 0;
	private int seed = 0;

	public ArrayList<Integer> getValuesCompares() {
		return valuesCompares;
	}

	public void setValuesCompares(ArrayList<Integer> valuesCompares) {
		this.valuesCompares = valuesCompares;
	}

	public ArrayList<Integer> getWriteAccesses() {
		return writeAccesses;
	}

	public void setWriteAccesses(ArrayList<Integer> writeAccesses) {
		this.writeAccesses = writeAccesses;
	}

	public int getNumberOfArrays() {
		return numberOfArrays;
	}

	public void setNumberOfArrays(int numberOfArrays) {
		this.numberOfArrays = numberOfArrays;
	}

	public int getBiggestNumber() {
		return biggestNumber;
	}

	public void setBiggestNumber(int biggestNumber) {
		this.biggestNumber = biggestNumber;
	}

	public int getNumberIncrease() {
		return numberIncrease;
	}

	public void setNumberIncrease(int numberIncrease) {
		this.numberIncrease = numberIncrease;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public void addCompareCounter(int compareCounter) {
		this.valuesCompares.add(compareCounter);
	}

	public void addWriteAccessCounter(int writeAccessCounter) {
		this.writeAccesses.add(writeAccessCounter);
	}
}