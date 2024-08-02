package ArraySeries.Expert;

import java.util.*;

public class _3Sum {
//    Excessive bruteforce approach : Time complexity of O(N^3) and space complexity of O(M*3)
    public static List<List<Integer>> threeSum(int arr[],int K){
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==K){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                        break;
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
//    better approach Time complexity of O(N^2) and space complexity of O(M*3)+O(M)
    public static List<List<Integer>> threeSum2(int arr[],int k){
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            Set<Integer> hs = new HashSet<>();
            for(int j=i+1; j<arr.length; j++){
                int third = -(arr[i]+arr[j]);
                if(hs.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
                    temp.sort(null);
                    set.add(temp);
                }
                hs.add(arr[j]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
//    optimised approach time complexity: O(NlogN)+O(n^2) and space complexity of O(1)
    public static List<List<Integer>> threeSum3(int []arr,int X){
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j=i+1,k=arr.length-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]==X){
                    list.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++; k--;
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(j<k && arr[k]==arr[k+1]) k--;
                }
                else if(arr[i]+arr[j]+arr[k]<X) j++;
                else k--;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[]= {-1,0,1,2,-1,-4};
        int k = 0;
        List<List<Integer>> list = threeSum3(arr,k);
        System.out.println(list);
    }
}
