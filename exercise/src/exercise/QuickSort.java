package exercise;

public class QuickSort {
	
	public static int partition(int[] arr, int start, int end) {
		int pivotItem = arr[start];
		int j=start;
		
		for (int i=start+1; i<=end; i++) {
			if (arr[i] < pivotItem) {
				j++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		int pivotPoint = j;
		int temp = arr[pivotPoint];
		arr[pivotPoint] = arr[start];
		arr[start]=temp;
		
		return pivotPoint;
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		int pivotPoint;
		if (start < end) {
			pivotPoint = partition(arr, start, end);
			quicksort(arr, start, pivotPoint-1);
			quicksort(arr, pivotPoint+1,end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {15,22,13,27,12,10,20,25};
		quicksort(arr,0,arr.length-1);
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
