import java.util.ArrayList;
import java.util.Random;

public class RandomArrayGenerator {

	public ArrayList<int[]> getRandomArrays(int numberOfArrays,
			int numberIncrease, int seed, int biggestNumber) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		int size = numberIncrease;

		for (int i = 0; i < numberOfArrays; i++) {
			list.add(getRandomArray(size, seed, biggestNumber));
			size *= numberIncrease;
		}
		return list;
	}

	public int[] getRandomArray(int digits, int seed, int biggestNumber) {

		int[] a = new int[digits];
		Random generator = new Random(seed);

		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(generator.nextInt(biggestNumber));
		}
		return a;
	}
}
