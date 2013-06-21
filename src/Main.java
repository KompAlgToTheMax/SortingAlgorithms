import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		
		RandomArrayGenerator rag = new RandomArrayGenerator();
		
//		int[] intArr = {1,2,3,4,5};	
//		for(int k = 0; k<intArr.length;k++) {
//			System.out.println(intArr[k]);
//		}

//		MergeSortAlgorithm ms = new MergeSortAlgorithm(intArr);
//		QuickSortAlgorithm qsa = new QuickSortAlgorithm(intArr);

		ArrayList<int[]> dataList = rag.getRandomArrays(10, 10, 0,1000);
		
//		int[] arrMS = ms.sort(0, intArr.length - 1);
//		for (int i = 0; i < arrMS.length; i++) {
//			System.out.println(i + 1 + ": " + arrMS[i]);
//		}
//		System.out.println("Compare Counter (MERGESORT): "+ Integer.toString(ms.getCompareCounter()));
//		System.out.println("Write Counter (MERGESORT): "+ Integer.toString(ms.getWriteCounter()));
		 
		
//		int[] arrQS = qsa.sort(0, intArr.length-1);
//		
//		for (int i = 0; i < arrQS.length; i++) {
//			System.out.println(i + 1 + ": " + arrQS[i]);
//		}
//		System.out.println("Compare Counter (QUICKSORT): "+ Integer.toString(qsa.getCompareCounter()));
	}
}
