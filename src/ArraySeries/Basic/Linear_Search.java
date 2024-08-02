package ArraySeries.Basic;

public class Linear_Search {
    static int search(int arr[],int n,int num) {
        int i;
        for(i=0;i<n;i++) {
            if(arr[i]==num)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int num = 4;
        int n = arr.length;
        int val = search(arr,n,num);
        System.out.println(val);
    }
}
