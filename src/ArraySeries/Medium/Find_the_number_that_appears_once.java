package ArraySeries.Medium;

import java.util.HashMap;
import java.util.Map;

public class Find_the_number_that_appears_once {
//    better approach 1
    public static int getSingleElement(int []arr) {
        //size of the array:
        int n = arr.length;
        // Find the maximum element:
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        // Declare hash array of size maxi+1
        // And hash the given array:
        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        //Find the single element and return the answer:
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
//    better approach 2
    public static int getSingleElement1(int []arr) {
        //size of the array:
        int n = arr.length;
        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        //Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
//    optimal approach
    public static int getSingleElement2(int []arr) {
        //size of the array:
        int n = arr.length;
        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }

    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}
