package ArraySeries.Hard;

import java.util.HashMap;
import java.util.Map;

public class Longest_subarray_with_given_sum_K_positives {
//    excessive bruteforce approach : Time Complexity :- near about O(N^3)
    public static int getLongestSubarray1(int []a, long k) {
        int n = a.length; // size of the array.
        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }
                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
//    bruteforce : Time Complexity :- About O(N^2)
    public static int getLongestSubarray2(int []a, long k){
        int n = a.length;
        int len = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                if(sum == k){
                    len = Math.max(len, j-i+1);
                }
                else if(sum > k){
                    break;
                }
            }
        }
        return len;
    }
//    better approach with the help of hashmap Time Complexity:- O(N) and Space Complexity:- O(N)
    public static int getLongestSubarray3(int []a, long k){
        int n = a.length; // size of the array.
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];
            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;
            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
//    optimised approach : two pointer : Time Complexity :- O(N) and space complexity :- O(1)
    public static int getLongestSubarray4(int []a, long k){
        int left = 0,right = 0;
        int sum = a[0];
        int maxlen = 0;
        int n = a.length;
        while(right<n){
            while(left<right && sum>k){
                sum -= a[left];
                left++;
            }
            if(sum==k) maxlen = Math.max(maxlen,right-left+1);
            right++;
            if(right<n) sum+=a[right];
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,1,1,1,1,4,2,3};
        long k = 10;
        int len = getLongestSubarray4(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
