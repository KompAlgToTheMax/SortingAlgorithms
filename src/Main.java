public class Main {

	public static void main(String[] args) {

		
		RandomArrayGenerator rag = new RandomArrayGenerator();
//		int[] intArr = rag.getRandomArray(111,10000);
		
		int[] intArr = {1,2,3,4,5};	
//		for(int k = 0; k<intArr.length;k++) {
//			System.out.println(intArr[k]);
//		}

		MergeSortAlgorithm ms = new MergeSortAlgorithm(intArr);
		QuickSortAlgorithm qsa = new QuickSortAlgorithm(intArr);

		
//		int[] arrMS = ms.sort(0, intArr.length - 1);
//		for (int i = 0; i < arrMS.length; i++) {
//			System.out.println(i + 1 + ": " + arrMS[i]);
//		}
//		System.out.println("Compare Counter (MERGESORT): "+ Integer.toString(ms.getCompareCounter()));
		
		
		int[] arrQS = qsa.sort(0, intArr.length-1);
		
		for (int i = 0; i < arrQS.length; i++) {
			System.out.println(i + 1 + ": " + arrQS[i]);
		}
		System.out.println("Compare Counter (QUICKSORT): "+ Integer.toString(qsa.getCompareCounter()));
	}
}
