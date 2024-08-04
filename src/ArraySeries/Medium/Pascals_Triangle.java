package ArraySeries.Medium;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
//	approach 1
	public static long nCr(int n, int r) {
		long res = 1;
		// calculating nCr:
		for (int i = 0; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}
		return res;
	}
	public static int pascalTriangle(int r, int c) {
		int element = (int) nCr(r - 1, c - 1);
		return element;
	}
//  approach 2
	static void pascalTriangle(int n) {
		long ans = 1;
		System.out.print(ans + " "); // printing 1st element
		// Printing the rest of the part:
		for (int i = 1; i < n; i++) {
			ans = ans * (n - i);
			ans = ans / i;
			System.out.print(ans + " ");
		}
		System.out.println();
	}
//	approach 3
	public static List<Integer> generateRow(int row) {
		long ans = 1;
		List<Integer> ansRow = new ArrayList<>();
		ansRow.add(1); //inserting the 1st element
		//calculate the rest of the elements:
		for (int col = 1; col < row; col++) {
			ans = ans * (row - col);
			ans = ans / col;
			ansRow.add((int)ans);
		}
		return ansRow;
	}
	public static List<List<Integer>> pascalTriangle2(int n) {
		List<List<Integer>> ans = new ArrayList<>();
		//store the entire pascal's triangle:
		for (int row = 1; row <= n; row++) {
			ans.add(generateRow(row));
		}
		return ans;
	}

	public static void main(String[] args) {
		int r = 5; // row number
		int c = 3; // col number
		int element = pascalTriangle(r, c);
		System.out.println("The element at position (r,c) is: " + element);
	}
}
