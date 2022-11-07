/*
 * public class MergeSort {
 * 
 * private int[] arr = {27,10,12,20,25,13,15,22}; int[] temp = new
 * int[arr.length];
 * 
 * public void mergeSort(int start, int end){
 * 
 * if (start < end ) { int mid = (int) ((start + end)/2); mergeSort(start, mid);
 * mergeSort(mid+1, end);
 * 
 * int leftIndex =start; int rightIndex = mid+1; int mergeIndex = start;
 * 
 * 
 * System.out.println(start + " " +mid +" " + (mid+1) + " " + end); while
 * ((leftIndex <= mid) && (rightIndex <= end)) {
 * System.out.println("!"+leftIndex + " " +mid +" " + rightIndex + " " + end);
 * System.out.println("!!" +arr[leftIndex] + " vs" + arr[rightIndex]); if
 * (arr[leftIndex] < arr[rightIndex]) { temp[mergeIndex++] = arr[leftIndex++]; }
 * else { temp[mergeIndex++] = arr[rightIndex++]; } }
 * 
 * if (leftIndex > mid) { while (rightIndex <= end) { temp[mergeIndex++] =
 * arr[rightIndex++]; } } else if (rightIndex > end) { while (leftIndex <= mid)
 * { temp[mergeIndex++] = arr[leftIndex++]; } }
 * 
 * for (int i=start; i<=end; i++) { arr[i] = temp[i]; }
 * 
 * } }
 * 
 * public void go() {
 * 
 * int n=arr.length; mergeSort(0,n-1); for (int i=0; i<n; i++) {
 * System.out.println(arr[i]); }
 * 
 * } }
 */

public class MergeSort{
	
	private int[] arr = {27,10,12,20,25,13,15,22}; 
	int[] temp = new int[arr.length];
	
	public void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (int)(start + end) /2;
			mergeSort(start , mid);
			mergeSort(mid+1, end);
			
			int leftTempArray = start;
			int rightTempArray = mid+1;
			int mergeArray = start;
			while ((leftTempArray <= mid) && (rightTempArray <= end)) {
				if (arr[leftTempArray] < arr[rightTempArray]) {
					temp[mergeArray++] = arr[leftTempArray++];
				}
				else {
					temp[mergeArray++] = arr[rightTempArray++];
				}
			}
			
			if (rightTempArray<=end) {
				while (rightTempArray<=end) {
					temp[mergeArray++] = arr[rightTempArray++];
				}
				
			}
			else if (leftTempArray <= mid) {
				while (leftTempArray <=mid) {
					temp[mergeArray++] = arr[leftTempArray++];
				}
			}
			
			for (int i=start; i<=end; i++) {
				arr[i]=temp[i];
			}
		}
	}
	
	public void go() {
		mergeSort(0,arr.length-1);
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}