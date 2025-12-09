import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;

        boolean result = subsetSum(arr, n, sum);
        System.out.println(result);

        boolean equal = equalSumPartition(arr, n);
        System.out.println(equal);
    }

    // -------- SUBSET SUM DP ---------
    private static boolean subsetSum(int[] arr, int n, int sum){
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

        return t[n][sum];
    }

    // -------- EQUAL SUM PARTITION ---------
    private static boolean equalSumPartition(int[] arr, int n){
        int sum = 0;
        for(int x : arr) sum += x;

        if(sum % 2 != 0) return false; // odd sum → cannot partition

        return subsetSum(arr, n, sum / 2);
    }
}