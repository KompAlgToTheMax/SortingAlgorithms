import java.util.Random;

public class RandomArrayGenerator {

	/**
	 * @param digits: Anzahl der Zufallszahlen und somit Größe des Arrays.
	 * @param seed: Seedwert für Pseudozufallszahlengenerator.
	 * @param biggestNumber: Die Zahlen im Array liegen zwischen 0 und biggestNumber.
	 * @return: Ein mit Zufallszahlen gefülltes Array.
	 */
	public int[] getRandomArray(int digits, int seed, int biggestNumber) {

		int[] a = new int[digits];
		Random generator = new Random(seed);

		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(generator.nextInt(biggestNumber));
		}
		
		return a;
	}
}
