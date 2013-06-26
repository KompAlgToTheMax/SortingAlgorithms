public class Main {

	public static void main(String[] args) {
		
		/**
		 * k beschreibt die Anzahl der Durchläufe mit verschiedenen Seed-Werten,
		 * in den Ergebnisdateien für jeden Seed-Wert eine Spalte zu finden.
		 */
		for(int k=0;k<10;k++) {
			SortingProcedure sp1 = new SortingProcedure(Integer.MAX_VALUE, 1,10000, k);
			sp1.proceed();
		}
		
	}
}
