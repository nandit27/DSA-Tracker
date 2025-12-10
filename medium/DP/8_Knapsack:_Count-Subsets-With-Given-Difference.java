import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int n = arr.length;
        int diff = 1;
        int sum = 0;
        for(int num: arr) sum += num;
        if((diff + sum) % 2 != 0){
            System.out.println(0);  // no such partition possible
            return;
        }
        int s1 = (diff + sum) / 2;
        int ans = countSubsetsWithGivenDiff(arr, n, s1);
        System.out.println(ans);
    }

    private static int countSubsetsWithGivenDiff(int[] arr, int n, int sum){
        int[][] t = new int[n + 1][sum + 1];
        // Initialization 
        for(int i = 0; i <= n; i++)
            t[i][0] = 1; // sum 0 is always possible
        
        for(int j = 1; j <= sum; j++)
            t[0][j] = 0; // no items → cannot form positive sum

        // DP filling
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j){
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}