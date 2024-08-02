package ArraySeries.Basic;

public class Left_Rotate_an_array {
//    brute force approach time complexity of O(N) and space complexity of O(N)
    static void rotateArray1(int arr[], int n) {
        int temp[]=new int[n];
        for (int i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }
        temp[n - 1] = arr[0];
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i]+" ");
        }
    }
//  optimal approach time complexity of O(N) and space complexity of O(1)
    static void rotateArray2(int arr[], int n) {
        int temp = arr[0]; // storing the first element of array in a variable
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp; // assigned the value of variable at the last index
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]) {
        int n=5;
        int arr[]= {1,2,3,4,5};
        rotateArray1(arr, n);
    }
}
