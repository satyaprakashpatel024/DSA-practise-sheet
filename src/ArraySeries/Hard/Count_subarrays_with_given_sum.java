package ArraySeries.Hard;

import java.util.HashMap;

public class Count_subarrays_with_given_sum {
    // Given an array and a target sum, find all subarrays with sum equals to target.
    public static int countSubArrays1(int []arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0,1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            int rem = sum-k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        int ans = countSubArrays1(arr,k);
        System.out.println("Total number of subarrays with given k sum : "+ans);
    }
}
