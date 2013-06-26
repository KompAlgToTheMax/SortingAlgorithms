import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

	private SortStatistic sortStat;
	private FileWriter writer;
	private File writingAccesses;
	private File comparingOperations;
	private File sortingStatistic;
	private String measurementName;
	private String output;
	private FileReader fr;
	private BufferedReader br;
	private List<Integer> seedList = new ArrayList<Integer>();
	

	
	public void addSeed(int seed) {
		if(!seedList.contains(seed)) {
			seedList.add(seed);
		}		
	}

	public void setSortStatistic(SortStatistic ss) {
		this.sortStat = ss;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public void createMeasurementDir() {
		output = "output";
		File dir = new File(output);
		dir.mkdir();
	}
	

	/**
	 * Mit der Methode writeStatistic wird die Gesamtstatistik für den kompletten
	 * Programmdurchlauf (alle Sortiervorgänge mit beiden Algorithmen) geschrieben.
	 */
	public void writeStatistic() {

		sortingStatistic = new File(output.toString() + "/" + "Statistic.txt");

		try {
			writer = new FileWriter(sortingStatistic, false);
			writer.write("Number of sorted arrays for each seed: " + sortStat.getNumberOfArrays());
			writer.write(System.getProperty("line.separator"));

			writer.write("Total number of sorted arrays: "+seedList.size()*sortStat.getNumberOfArrays());
			writer.write(System.getProperty("line.separator"));
			
			writer.write("Biggest number (Values in arrays between 0 and biggest number): " + sortStat.getBiggestNumber() +"(Integer.MAX_VALUE)");
			writer.write(System.getProperty("line.separator"));
			writer.write("Arraysize increase with each step : " + sortStat.getArrayIncrease());
			writer.write(System.getProperty("line.separator"));
			
			writer.write("Seedvalues: ");
			for(int seed : seedList) {
			 writer.write(seed+" ");
			}
			
			writer.write(System.getProperty("line.separator"));
			writer.write("Smallest array includes " + sortStat.getArrayIncrease()
					+ " elements.");
			writer.write(System.getProperty("line.separator"));
			writer.write("Biggest array includes " + sortStat.getArrayIncrease()
					* sortStat.getNumberOfArrays() + " elements.");
			writer.write(System.getProperty("line.separator"));
			writer.write(System.getProperty("line.separator"));
			writer.write("Jede einzelne Spalte in den Ergebnisdateien MS_writingAccesses.txt, QS_writingAccesses.txt, \n" +
					"MS_comparingOperations.txt und QS_comparingOperations.txt entspricht den Ergebnissen der \n" +
					"Sortierung von Arrays mit dem gleichen Seed-Wert. Hierbei wurde für Spalte n, der Seedwert n \naus der" +
					"Liste (s.o.) verwendet.");
			
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Über die Methode writeWritingAccesses werden die Ergebnisse
	 * einzelner Sortiervorgänge (Anzahl der schreibenden Zugriffe) 
	 * an die jeweiligen Ergebnisdateien angehängt. Existiert die 
	 * Ergebnisdatei für den jeweiligen Sortieralgorithmus noch nicht, 
	 * wird diese erstellt.
	 */
	public void writeWritingAccesses() {

		String path = output.toString() + "/" + measurementName
				+ "_writingAccesses.txt";
		
		writingAccesses = new File(path);

		
		if (writingAccesses.exists()) {
			try {

				fr = new FileReader(path);
				br = new BufferedReader(fr);
				StringBuffer buffer = new StringBuffer();

				for (int value : sortStat.getWriteAccesses()) {
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

				for (int value : sortStat.getWriteAccesses()) {
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

	
	/**
	 * Über die Methode writeCompares werden die Ergebnisse
	 * einzelner Sortiervorgänge (Anzahl der Vergleiche) an die 
	 * jeweiligen Ergebnisdateien angehängt. Existiert die 
	 * Ergebnisdatei für den jeweiligen Sortieralgorithmus noch 
	 * nicht, wird diese erstellt.
	 */
	public void writeCompares() {

		String path = output.toString() + "/" + measurementName
				+ "_comparingOperations.txt";

		comparingOperations = new File(path);

		if (comparingOperations.exists()) {
			try {

				fr = new FileReader(path);
				br = new BufferedReader(fr);
				StringBuffer buffer = new StringBuffer();

				for (int value : sortStat.getValuesCompares()) {
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

				for (int value : sortStat.getValuesCompares()) {
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