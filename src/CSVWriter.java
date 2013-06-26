import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

	SortStatistic ss;
	FileWriter writer;
	File writingAccesses;
	File comparingOperations;
	File sortingStatistic;
	String measurementName;
	String output;
	FileReader fr;
	BufferedReader br;

	public CSVWriter() {

	}

	public void setSortStatistic(SortStatistic ss) {
		this.ss = ss;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public void createMeasurementDir() {
		output = "output";
		File dir = new File(output);
		dir.mkdir();
	}

	public void writeStatistic() {

		sortingStatistic = new File(output.toString() + "/" + "Statistic.txt");

		try {
			writer = new FileWriter(sortingStatistic, false);
			writer.write("Number of arrays: " + ss.getNumberOfArrays());
			writer.write(System.getProperty("line.separator"));
			writer.write("Biggest number: " + ss.getBiggestNumber());
			writer.write(System.getProperty("line.separator"));
			writer.write("Array increase: " + ss.getArrayIncrease());
			writer.write(System.getProperty("line.separator"));
			writer.write("Seed: " + ss.getSeed());
			writer.write(System.getProperty("line.separator"));
			writer.write("Smallest array includes " + ss.getArrayIncrease()
					+ " elements.");
			writer.write(System.getProperty("line.separator"));
			writer.write("Biggest array includes " + ss.getArrayIncrease()
					* ss.getNumberOfArrays() + " elements.");
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeWritingAccesses() {

		String path = output.toString() + "/" + measurementName
				+ "_writingAccesses.txt";
		
		writingAccesses = new File(path);

		
		if (writingAccesses.exists()) {
			try {

				fr = new FileReader(path);
				br = new BufferedReader(fr);
				StringBuffer buffer = new StringBuffer();

				for (int value : ss.getWriteAccesses()) {
					buffer.append(br.readLine().concat(" ")
							.concat(Integer.toString(value)));
					buffer.append(System.getProperty("line.separator"));
				}

				writer = new FileWriter(writingAccesses, false);
				writer.write(buffer.toString());
				writer.close();
				br.close();
				fr.close();

			} catch (Exception ex) {

			}
		} else {

			try {
				writer = new FileWriter(writingAccesses, false);

				for (int value : ss.getWriteAccesses()) {
					writer.write(Integer.toString(value));
					writer.write(System.getProperty("line.separator"));
				}
				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeCompares() {

		String path = output.toString() + "/" + measurementName
				+ "_comparingOperations.txt";

		comparingOperations = new File(path);

		if (comparingOperations.exists()) {
			try {

				fr = new FileReader(path);
				br = new BufferedReader(fr);
				StringBuffer buffer = new StringBuffer();

				for (int value : ss.getValuesCompares()) {
					buffer.append(br.readLine().concat(" ")
							.concat(Integer.toString(value)));
					buffer.append(System.getProperty("line.separator"));
				}

				writer = new FileWriter(comparingOperations, false);
				writer.write(buffer.toString());
				writer.close();
				br.close();
				fr.close();

			} catch (Exception ex) {

			}
		} else {

			try {
				writer = new FileWriter(comparingOperations, false);

				for (int value : ss.getValuesCompares()) {
					writer.write(Integer.toString(value));
					writer.write(System.getProperty("line.separator"));
				}

				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}