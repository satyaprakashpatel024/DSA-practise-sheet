package ArraySeries.Medium;

public class Grid_Unique_Paths {
	static int uniquePaths(int m, int n) {
		int N = n + m - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++)
			res = res * (N - r + i) / i;
		return (int)res;
	}

	public static void main(String[] args) {
		int totalCount= uniquePaths(2,3);
		System.out.println("The total number of Unique Paths are "+totalCount);
	}
}
