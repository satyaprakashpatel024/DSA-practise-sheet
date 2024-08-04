package ArraySeries.Expert;

import java.util.ArrayList;

public class CountInversion {
//	static int count = 0;
	private static int merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); // temporary array
		int left = low;      // starting index of left half of arr
		int right = mid + 1;   // starting index of right half of arr
		int count = 0;
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} // right part
			else {
				temp.add(arr[right]);
			//	update count of inversions by adding difference between indices of left and right halves of arr.
				count += (mid - left + 1);
				right++;
			}
		}
		// if elements on the left half are still left //
		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		//  if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}
		// transferring all elements from temporary to arr //
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
		return count; // returning count of inversions in the given array.  //
	}

	public static int mergeSort(int[] arr, int low, int high) {
		if (low >= high) return 0;
		int mid = (low + high) / 2 ;
		int l = mergeSort(arr, low, mid);  // left half
		int r = mergeSort(arr, mid + 1, high); // right half
		return l+r+ merge(arr, low, mid, high);  // merging sorted halves
	}

	static int countInversion(int []arr){
		return mergeSort(arr, 0, arr.length - 1);
	}
	public static void main(String[] args) {
		int []arr = {5,3,2,4,1};
		int ans = countInversion(arr);
		System.out.println("Total no of count inversion : "+ans);
	}
}
