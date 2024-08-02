package ArraySeries.Basic;

import java.util.Arrays;

public class Second_Largest_Element {
//    brute force approach : time complexity of (NlogN)
    static private void getElements(int[] arr, int n) {
        if (n == 0 || n==1){
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n - 2];
        System.out.println("Second smallest is "+small);
        System.out.println("Second largest is "+large);
    }
//     better approach time complexity of O(N)
    static private void getElements2(int[] arr, int n) {
    if (n == 0 || n==1) {
        System.out.print(-1);
        System.out.print(" ");
        System.out.print(-1);
        System.out.print("\n");
    }
    int small = Integer.MAX_VALUE;
    int second_small = Integer.MAX_VALUE;
    int large = Integer.MIN_VALUE;
    int second_large = Integer.MIN_VALUE;
    int i;
    for (i = 0;i < n;i++){
        small = Math.min(small,arr[i]);
        large = Math.max(large,arr[i]);
    }
    for (i = 0;i < n;i++) {
        if (arr[i] < second_small && arr[i] != small)
            second_small = arr[i];
        if (arr[i] > second_large && arr[i] != large)
            second_large = arr[i];
    }
    System.out.println("Second smallest is "+second_small);
    System.out.println("Second largest is "+second_large);
}
//     optimal approach only one pass time complexity O(N)
    static private int secondSmallest(int[] arr, int n) {
        if (n < 2) return -1;
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            }
            else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }
//    optimal approach only one pass time complexity O(N)
    static private int secondLargest(int[] arr, int n) {
        if(n<2) return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            }
            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 4, 6, 7, 5};
        int n = arr.length;
        getElements(arr, n);
    }
}
