package ArraySeries.Hard;

import java.util.HashMap;

public class Count_number_of_subarrays_with_given_xor_K {
//    bruteforce approach time complexity near about O(N^3)
    public static int findSubarrayXorK(int arr[], int K) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int xor = 0;
                for(int k=i; k<=j; k++){
                    xor ^= arr[k];
                }
                if(xor==K) count++;
            }
        }
        return count;
    }
//    better approach time complexity of O(N^2)
    public static int findSubarrayXorK2(int arr[], int K) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            int xor = arr[i];
            if(xor==K) count++;
            for(int j=i+1; j<arr.length; j++){
                xor ^= arr[j];
                if(xor==K) count++;
            }
        }
        return count;
    }
//    optimised approach with time complexity of O(N) and Space complexity of O(N)
    public  static int findSubarrayXorK3(int []arr,int K){
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int Xor = 0;
        for (int j : arr) {
            Xor = j ^ Xor;
            int x = Xor ^ K;
            count += map.getOrDefault(x, 0);
            map.put(Xor, map.getOrDefault(Xor, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {4 ,94, 39, 36, 88, 87, 39, 67, 11, 6};
        int k = 15;
        int ans = findSubarrayXorK3(arr, k);
        System.out.println(ans);
    }
}
