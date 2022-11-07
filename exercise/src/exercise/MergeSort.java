package exercise;

import java.util.ArrayList;

public class MergeSort {
	
	public static void mergesort(int[] arr, int start, int end) {
		int[] temp = new int[arr.length];
		int mid = (start+end)/2;
		if (start < end) {
			mergesort(arr, start,mid);
			mergesort(arr, mid+1, end);
		}
		
		int i=start;
		int j=mid+1;
		int cnt=start;
		
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				temp[cnt++] =arr[i++];
			}
			else {
				temp[cnt++]=arr[j++];
			}
		}
		
		while (i<=mid) {
			temp[cnt++] = arr[i++];
		}
		while (j<=end) {
			temp[cnt++] = arr[j++];
		}
		
		for (int k=start; k<=end; k++) {
			arr[k]=temp[k];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4,5,1,2,3,6};
	
		mergesort(arr, 0,arr.length-1);
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
