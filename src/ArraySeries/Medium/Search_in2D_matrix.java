package ArraySeries.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Search_in2D_matrix {
//	liner search or brute force approach
	public static boolean linearSearchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
		int n = matrix.size(), m = matrix.get(0).size();

		// traverse the matrix:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix.get(i).get(j) == target)
					return true;
			}
		}
		return false;
	}
//  better approach : binary search
	public static boolean binarySearch(ArrayList<Integer> nums, int target) {
		int n = nums.size(); //size of the array
		int low = 0, high = n - 1;

		// Perform the steps:
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums.get(mid) == target) return true;
			else if (target > nums.get(mid)) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}
//	optimal approach
	public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
		int n = matrix.size();
		int m = matrix.get(0).size();

		for (int i = 0; i < n; i++) {
			if (matrix.get(i).get(0) <= target && target <= matrix.get(i).get(m - 1)) {
				return binarySearch(matrix.get(i), target);
			}
		}
		return false;
	}

	public static boolean searchMatrixBinary(ArrayList<ArrayList<Integer>> matrix, int target) {
		int n = matrix.size();
		int m = matrix.get(0).size();

		//apply binary search:
		int low = 0, high = n * m - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int row = mid / m, col = mid % m;
			if (matrix.get(row).get(col) == target) return true;
			else if (matrix.get(row).get(col) < target) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}


	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
		matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

		boolean result = searchMatrix(matrix, 8);
		System.out.println(result ? "true" : "false");
	}
}
