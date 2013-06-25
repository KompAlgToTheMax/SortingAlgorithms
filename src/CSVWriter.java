import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVWriter {

	SortStatistic ss;
	FileWriter writer;
	File writingAccesses;
	File comparingOperations;
	File sortingStatistic;
	String measurementName;
	Date now;
	SimpleDateFormat sdf;
	String timeStamp;

	public CSVWriter(String measurementName,SortStatistic ss) {
		this.ss = ss;
		this.measurementName = measurementName;
		this.now = new Date();
		this.sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		timeStamp = sdf.format(now);
		File dir = new File(timeStamp);
		dir.mkdir();
	}

	public void writeStatistic() {
		
		sortingStatistic = new File(timeStamp+"/"+measurementName+"_sortingStatistic.txt");

		try {
			writer = new FileWriter(sortingStatistic, false);
			writer.write("Number of arrays: " + ss.getNumberOfArrays());
			writer.write(System.getProperty("line.separator"));
			writer.write("Biggest number: " + ss.getBiggestNumber());
			writer.write(System.getProperty("line.separator"));
			writer.write("Number increase: " + ss.getNumberIncrease());
			writer.write(System.getProperty("line.separator"));
			writer.write("Seed: " + ss.getSeed());

			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeWritingAccesses() {
		
		writingAccesses = new File(timeStamp+"/"+measurementName+"_writingAccesses.txt");

		try {
			writer = new FileWriter(writingAccesses, false);

			for(int value : ss.getWriteAccesses()) {
				writer.write(Integer.toString(value));
				writer.write(System.getProperty("line.separator"));
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCompares() {

		comparingOperations = new File(timeStamp+"/"+measurementName+"_comparingOperations.txt");

		try {
			writer = new FileWriter(comparingOperations, false);

 			for(int value : ss.getValuesCompares()) {
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