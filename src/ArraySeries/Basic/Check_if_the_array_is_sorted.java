package ArraySeries.Basic;

public class Check_if_the_array_is_sorted {
//    brute force approach : time complexity O(N^2)
    static boolean isSorted(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    return false;
            }
        }
        return true;
    }
//    optimised approach : time complexity O(N)
    static boolean isSorted2(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }

        return true;
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5}, n = 5;
        System.out.println(isSorted(arr, n));
    }
}
