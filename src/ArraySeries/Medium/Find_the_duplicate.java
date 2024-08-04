package ArraySeries.Medium;

public class Find_the_duplicate {
	static int findDuplicate1(int[] arr) {
		int n = arr.length;
		int freq[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (freq[arr[i]] == 0) {
				freq[arr[i]] += 1;
			} else {
				return arr[i];
			}
		}
		return 0;
	}
	public static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	public static void main(String args[]) {
		int arr[] = {1,3,4,2,3};
		System.out.println("The duplicate element is " + findDuplicate(arr));
	}
}
