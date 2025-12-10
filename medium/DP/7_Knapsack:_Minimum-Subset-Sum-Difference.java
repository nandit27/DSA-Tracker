import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int n = arr.length;
        int ans = minSubsetSumDiff(arr, n);
        System.out.println(ans);
    }

    private static int minSubsetSumDiff(int[] arr, int n){
        int sum = 0;
        for(int num : arr) sum += num;
        boolean[][] t = new boolean[n + 1][sum + 1];
        // Initialization
        for(int i = 0; i <= n; i++)
            t[i][0] = true; // sum 0 is always possible
        
        for(int j = 1; j <= sum; j++)
            t[0][j] = false; // no items → cannot form positive sum

        // DP filling
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j){
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
       
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(t[n][i] == true){
                int diff = Math.abs(sum - 2*i);
                mini = Math.min(diff,mini);
            }
        }
        return mini;
    }
}