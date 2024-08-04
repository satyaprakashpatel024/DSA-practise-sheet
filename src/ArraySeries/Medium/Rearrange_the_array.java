package ArraySeries.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class Rearrange_the_array {
//	approach 1
	public static int[] RearrangebySign(int[] A, int n){
		// Define 2 vectors, one for storing positive
		// and other for negative elements of the array.
		ArrayList<Integer> pos=new ArrayList<>();
		ArrayList<Integer> neg=new ArrayList<>();
		// Segregate the array into positives and negatives.
		for(int i=0;i<n;i++){
			if(A[i]>0) pos.add(A[i]);
			else neg.add(A[i]);
		}
		// Positives on even indices, negatives on odd.
		for(int i=0;i<n/2;i++){
			A[2*i] = pos.get(i);
			A[2*i+1] = neg.get(i);
		}
		return A;
	}
//  approach 2
	public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A) {
		int n = A.size();
		// Define array for storing the ans separately.
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
		// positive elements start from 0 and negative from 1.
		int posIndex = 0, negIndex = 1;
		for (int i = 0; i < n; i++) {
			// Fill negative elements in odd indices and inc by 2.
			if (A.get(i) < 0) {
				ans.set(negIndex, A.get(i));
				negIndex += 2;
			}
			// Fill positive elements in even indices and inc by 2.
			else {
				ans.set(posIndex, A.get(i));
				posIndex += 2;
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		// Array Initialisation.
		int n = 4;
		int A[]= {1,2,-4,-5};
		int[]ans= RearrangebySign(A,n);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
