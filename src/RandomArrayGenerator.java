import java.util.Random;


public class RandomArrayGenerator {

	public int[] getRandomArray(int digits, int highestValue) {
		
		int[] a = new int[digits]; 
		Random generator = new Random(2);
		
		for(int i = 0; i<a.length; i++) {
			
		     a[i] = (int)(generator.nextInt(highestValue));
		}
		
		return a;
	}
}
