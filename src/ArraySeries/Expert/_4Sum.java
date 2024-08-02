package ArraySeries.Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _4Sum {
//    Excessive bruteforce approach with time complexity of O(N^4) + space complexity of O(M*4)
    public static List<List<Integer>> fourSum(int []arr,int target){
        HashSet<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l] == target){
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            temp.sort(null);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
//    better approach with time complexity of O(N^3) + space complexity of O(M*4)
    public static List<List<Integer>> fourSum2(int []arr, int target){
        HashSet<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                HashSet<Integer> hs = new HashSet<>();
                for(int k=j+1; k<n; k++){
                    int fourth = target-(arr[i]+arr[j]+arr[k]);
                    if(hs.contains(fourth)){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        temp.sort(null);
                        set.add(temp);
                    }
                    hs.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
//    optimised approach : Two pointer with time complexity of O(NlogN)+O(N^3) and space complexity O(1)
    public static List<List<Integer>> fourSum3(int []arr,int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j!=(i+1) && arr[j]==arr[j-1]) continue;
                int k=j+1,l=n-1;
                while(k<l){
                    int sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==target) {
                        ans.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++;
                        l--;
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr,0));
        System.out.println(fourSum2(arr,0));
        System.out.println(fourSum3(arr,0));
    }
}
