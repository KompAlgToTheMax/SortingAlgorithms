
public class SortStatistic {
	private int valuesCompares = 0;
	private int writeAccesses = 0;
	private int sortedValues = 0;
	private int seed = 0;
	
	public int getValuesCompares() {
		return valuesCompares;
	}
	public void setValuesCompares(int valuesCompares) {
		this.valuesCompares = valuesCompares;
	}
	public int getWriteAccesses() {
		return writeAccesses;
	}
	public void setWriteAccesses(int writeAccesses) {
		this.writeAccesses = writeAccesses;
	}
	public int getSortedValues() {
		return sortedValues;
	}
	public void setSortedValues(int sortedValues) {
		this.sortedValues = sortedValues;
	}
	public int getSeed() {
		return seed;
	}
	public void setSeed(int seed) {
		this.seed = seed;
	}
}
