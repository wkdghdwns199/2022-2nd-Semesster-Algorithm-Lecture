/*
  public class QuickSort {
  
  static int[] S = {15, 22, 13, 27, 12, 10, 20, 25};
  
  public static int partition(int low, int high) { int i,j; int pivotItem =
  S[low]; System.out.println("!"+S[low] + " : "); j=low; for (i=low + 1;
  i<=high; i++) { if (S[i] < pivotItem) { j++; System.out.print("!!"); for (int
  k=0; k<S.length-1; k++) { System.out.print(S[k]+" "); } System.out.println();
  int temp = S[i]; S[i] = S[j]; S[j]=temp; } } int pivotPoint = j; int temp =
  S[low]; S[low] = S[pivotPoint]; S[pivotPoint] = temp;
  
  return pivotPoint; }
  
  public static void quickSort(int low, int high){ int pivotPoint; if (high >
  low) { pivotPoint = partition(low, high); for (int i=0; i<S.length-1; i++) {
  System.out.print(S[i]+" "); } System.out.println(); quickSort(low, pivotPoint
  - 1); quickSort(pivotPoint +1, high);
  
  } }
  
  public static void main(String[] args) { quickSort(0,S.length-1); for (int
  i=0; i<S.length-1; i++) { System.out.println(S[i]); } } }
 */

public class QuickSort {
	static int[] S = { 15, 22, 13, 27, 12, 10, 20, 25 };

	public static int partition(int start, int end) {
		

			int pivotItem = S[end];
			int j = end;

			for (int i = end-1; i >=0; i--) {
				if (S[i] > pivotItem) {
					j--;
					int temp = S[i];
					S[i] = S[j];
					S[j] = temp;
				}
			}
			int pivotPoint = j;
			int temp = S[end];
			S[end] = S[pivotPoint];
			S[pivotPoint] = temp;

			return pivotPoint;

			
	}

	public static void quickSort(int start, int end) {
		int pivotPoint;
		if (start <end) {
			pivotPoint = partition(start ,end);
			quickSort(start, pivotPoint - 1);
			quickSort(pivotPoint + 1, end);
		}
	
	}

	public static void main(String[] args) {
		quickSort(0, S.length - 1);
		for (int i = 0; i < S.length - 1; i++) {
			System.out.println(S[i]);
		}
	}
}