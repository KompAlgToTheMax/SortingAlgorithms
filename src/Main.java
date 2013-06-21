import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		RandomArrayGenerator rag = new RandomArrayGenerator();

//		MergeSortAlgorithm ms = new MergeSortAlgorithm(intArr);
//		QuickSortAlgorithm qsa = new QuickSortAlgorithm(intArr);

		ArrayList<int[]> dataList = rag.getRandomArrays(10, 10, 0,1000);

//		System.out.println("Compare Counter (MERGESORT): "+ Integer.toString(ms.getCompareCounter()));
//		System.out.println("Write Counter (MERGESORT): "+ Integer.toString(ms.getWriteCounter()));

		for(int i = 0;i<dataList.size();i++) {
			System.out.println("Array:"+i);
			for(int j = 0;j<dataList.get(i).length;j++) {
				System.out.println(j+": "+dataList.get(i)[j]);
			}
		}
		
		
	}
}
