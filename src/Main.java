import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int NUMBER_OF_SEEDS = 10;
	private static int INITIAL_ARRAY_SIZE = 1;
	private static int BIGGEST_NUMBER = Integer.MAX_VALUE;
	private static int ARRAY_INCREASE = 1;
	private static int NUMBER_OF_ARRAYS = 10;

	
	public static void main(String[] args) {
		
		List<SortStatistic> sortStatListQS = new ArrayList<SortStatistic>(); 
		List<SortStatistic> sortStatListMS = new ArrayList<SortStatistic>(); 
	
		/**
		 *  k: beschreibt den aktuellen Seed-Wert und wird von 0 bis NUMBER_OF_SEEDS
		 *     jeweils um 1 inkrementiert. In den Ergebnisdateien ist dies die Anzahl
		 *     der Spalten.
		 *     
		 *  BIGGEST_NUMBER: Die größte Zahl die in den jeweiligen Arrays vorkommt,
		 *  				wobei alle Zahlen im Array zwischen 0 und BIGGEST_NUMBER
		 *  				liegen.
		 *  INITIAL_ARRAY_SIZE: Die initiale Array-Größe.
		 *  ARRAY_INCREASE: Der Wert um den das zu sortierende Array bei jedem Schritt
		 *  				vergrößert wird.
		 *  NUMBER_OF_ARRAYS: Die Anzahl der Arrays, die für jeden einzelnen Seed generiert
		 *  				  werden. In den Ergebnisdateien spiegelt sich dieser Wert in der
		 *  				  Anzahl der Zeilen wieder.
		 */
		for(int k=0;k<NUMBER_OF_SEEDS;k++) {
			// Objekte der SortStatistic-Klasse halten alle wichtigen Werte für die spätere Persistierung.
			SortStatistic sortStat = new SortStatistic();
			// SortingProcedureQS beinhaltet den Ablauf des kompletten Sortierprozesses für Quicksort.
			SortingProcedureQS sp1 = new SortingProcedureQS(BIGGEST_NUMBER,INITIAL_ARRAY_SIZE, ARRAY_INCREASE, NUMBER_OF_ARRAYS, k, sortStat);
			// Die Proceed-Methode von SortingProcedureQS liefert das "gefüllte" Objekt von SortStatistic zurück.
			sortStatListQS.add(sp1.proceed()); 
		}
		
		// Analog zur oberen Schleife, jedoch für Mergesort.
		for(int k=0;k<NUMBER_OF_SEEDS;k++) {
			SortStatistic sortStat = new SortStatistic();
			SortingProcedureMS sp1 = new SortingProcedureMS(BIGGEST_NUMBER,INITIAL_ARRAY_SIZE, ARRAY_INCREASE, NUMBER_OF_ARRAYS, k, sortStat);
			sortStatListMS.add(sp1.proceed()); 
		}
		
		
		/* 
		 * CSVWriter dient zur Persistierung und verwendet hierzu SortStatistic-Instanzen, um
		 * deren Werte in die jeweiligen Dateien zu schreiben.
		 */
		CSVWriter csvWrite = new CSVWriter();
		
		// Methode zum Anlegen der hinterlegten Ordnerstruktur.
		csvWrite.createMeasurementDir();
		
		/*
		 * In den folgenden beiden for-Schleifen werden zum Einen die Ergebnisse der
		 * Sortiervorgänge der Arrays an die Zieldateien angehängt, zum Anderen die
		 * zum Erstellen der Gesamtstatistik "Statistic.txt" benötigten Seedwerte im 
		 * CSVWriter-Objekt angesammelt.
		 */
		for(SortStatistic sortStat : sortStatListQS) {
			csvWrite.setSortStatistic(sortStat);
			csvWrite.setMeasurementName("QS");
			csvWrite.addSeed(sortStat.getSeed());
			csvWrite.writeWritingAccesses();
			csvWrite.writeCompares();
		}
		
		for(SortStatistic sortStat : sortStatListMS) {
			csvWrite.setSortStatistic(sortStat);
			csvWrite.setMeasurementName("MS");
			csvWrite.addSeed(sortStat.getSeed());
			csvWrite.writeWritingAccesses();
			csvWrite.writeCompares();
		}
		
		// Erstellung und Schreiben der Gesamtstatistik.
		csvWrite.writeStatistic();	
	}
}
