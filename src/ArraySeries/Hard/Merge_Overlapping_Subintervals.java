package ArraySeries.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Overlapping_Subintervals {
//	brute force
	public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
		int n = arr.length; // size of the array
		//sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) { // select an interval:
			int start = arr[i][0];
			int end = arr[i][1];

			//Skip all the merged intervals:
			if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
				continue;
			}

			//check the rest of the intervals:
			for (int j = i + 1; j < n; j++) {
				if (arr[j][0] <= end) {
					end = Math.max(end, arr[j][1]);
				} else {
					break;
				}
			}
			ans.add(Arrays.asList(start, end));
		}
		return ans;
	}
//	optimal approach
	public static List<List<Integer>> mergeOverlappingIntervals1(int[][] arr) {
		int n = arr.length; // size of the array
		//sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// if the current interval does not
			// lie in the last interval:
			if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			}
			// if the current interval
			// lies in the last interval:
			else {
				ans.get(ans.size() - 1).set(1,
						Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
		List<List<Integer>> ans = mergeOverlappingIntervals(arr);
		System.out.print("The merged intervals are: \n");
		for (List<Integer> it : ans) {
			System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
		}
		System.out.println();
	}
}
