package ArraySeries.Medium;

import java.util.HashMap;

public class _2Sum_Problem {
    //	Approach 1
    public static String twoSum(int n, int []arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                return "YES";
            }

            mpp.put(arr[i], i);
        }
        return "NO";
    }
    //	approach 2
    public static int[] twoSum2(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }
            mpp.put(arr[i], i);
        }
        return ans;
    }


    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }
}
