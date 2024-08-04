package ArraySeries.Medium;

public class Subarray_with_maximum_subarray_sum {
//	brute force approach
	public static int maxSubarraySum(int[] arr, int n) {
		int maxi = Integer.MIN_VALUE; // maximum sum
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// subarray = arr[i.....j]
				int sum = 0;
				//add all the elements of subarray:
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				maxi = Math.max(maxi, sum);
			}
		}
		return maxi;
	}
//	better approach
	public static int maxSubarraySum1(int[] arr, int n) {
		int maxi = Integer.MIN_VALUE; // maximum sum
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				// current subarray = arr[i.....j]
				//add the current element arr[j]
				// to the sum i.e. sum of arr[i...j-1]
				sum += arr[j];
				maxi = Math.max(maxi, sum); // getting the maximum
			}
		}
		return maxi;
	}
//	optimal approach
	public static long maxSubarraySum2(int[] arr, int n) {
		long maxi = Long.MIN_VALUE; // maximum sum
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > maxi) {
				maxi = sum;
			}
			// If sum < 0: discard the sum calculated
			if (sum < 0) {
				sum = 0;
			}
		}
		// To consider the sum of the empty subarray
		// uncomment the following check:
		//if (maxi < 0) maxi = 0;
		return maxi;
	}
	public static void main(String args[]) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		int n = arr.length;
		long maxSum = maxSubarraySum(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum);
	}
}
