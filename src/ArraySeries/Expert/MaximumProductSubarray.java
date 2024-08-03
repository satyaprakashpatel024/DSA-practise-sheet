package ArraySeries.Expert;

public class MaximumProductSubarray {
//	prefix and suffix subarray approach
	static int findMaximumProductSubarray(int []arr){
		int pre = 1,suff = 1;
		int maxProduct = Integer.MIN_VALUE;
		int n = arr.length;
		for(int i=0; i<n; i++){
			if(pre==0) pre=1;
			if(suff==0) suff=1;
			pre = pre*arr[i];
			suff = suff*arr[n-i-1];
			maxProduct = Math.max(maxProduct, Math.max(pre, suff));
		}
		return maxProduct;
	}
	public static void main(String[] args) {
		int []arr= {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
		int ans = findMaximumProductSubarray(arr);
		System.out.println(ans);
	}
}
