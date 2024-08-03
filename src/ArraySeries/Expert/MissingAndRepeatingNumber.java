package ArraySeries.Expert;

public class MissingAndRepeatingNumber {
//	better approach time complexity of O(N) and Space complexity of O(N)
	static int [] findMissingAndRepeating(int[] arr){
		int n = arr.length;
		int freq[]= new int[n+1];
		for(int i:arr){
			freq[i]++;
		}
		int missing = 0,repeating = 0;
		for(int i=1; i<=n; i++){
			if(freq[i]>1) repeating = i;
			else if(freq[i]==0) missing = i;
			else if(missing !=0 && repeating!=0) break;
		}
        return new int[]{missing,repeating};
	}
//	optimal approach time complexity of O(N) and space complexity of O(1)
	static int [] findMissingAndRepeating1(int[] arr){
//		s-sn = x-y formula
//		s2-s2n = x^2-y^2
		int n = arr.length;
		int sn = n*(n+1)/2;
		int s2n = n*(n+1)*(2*n+1)/6;
		int s=0,s2=0;
		for(int i:arr){
			s+=i;
			s2+=i*i;
		}
		int val1 = s-sn;
		int val2 = s2-s2n;
		val2 = val2/val1;
		int repeating = (val2+val1)/2;
		int  missing = repeating-val1;
		return new int[]{missing,repeating};
	}
	public static void main(String[] args) {
		int arr[] = {4,3,6,2,1,1};
		int arr1[] = {1,1,3};
		int []ans = findMissingAndRepeating1(arr1);
		System.out.println(ans[0]+"||"+ans[1]);
		ans = findMissingAndRepeating(arr1);
		System.out.println(ans[0]+"||"+ans[1]);
	}
}
