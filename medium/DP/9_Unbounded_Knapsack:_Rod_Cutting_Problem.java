import java.util.*;

public class HelloWorld {
    int[] t;
    public static void main(String[] args){
        int[] length = {1,2,3,4,5};
        int[] price = {8,6,2,1,3};
        int N = length.length;
        int rodLength = 5;

        int ans = rodCutting(length,price,N,rodLength);
        System.out.println(ans);
    }
    public static int rodCutting(int[] length, int[] price, int N, int rodLength){
        int[][] t = new int[N+1][rodLength+1];
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= rodLength; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[N][rodLength];
    }
}