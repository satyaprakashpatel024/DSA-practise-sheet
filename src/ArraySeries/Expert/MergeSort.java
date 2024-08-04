package ArraySeries.Expert;

import java.util.ArrayList;

public class MergeSort {
	private static void merge(int[] arr,int low,int mid,int high){
		ArrayList<Integer> list = new ArrayList<>();
		int left = low, right = mid+1;
		while(left<=mid && right<=high){
			if(arr[left]<arr[right]){
				list.add(arr[left++]);
			}else{
				list.add(arr[right++]);
			}
		}
//		if any element left in first array
		while(left<=mid){
            list.add(arr[left++]);
        }
//		if any element left in second array
		while(right<=high){
            list.add(arr[right++]);
        }
        for(int k=low; k<=high; k++){
            arr[k] = list.get(k-low);
        }
	}
	public static void mergeSort(int arr[],int s,int e){
		if(s>=e) return;
        int mid = s+(e-s)/2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);
        merge(arr, s, mid, e);
	}
	public static void main(String[] args) {
		int arr[] = {9,8,7,6,5,4,3,2,1};
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
	}
}
