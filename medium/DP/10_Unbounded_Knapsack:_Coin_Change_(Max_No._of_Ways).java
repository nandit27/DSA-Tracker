import java.util.*;

public class HelloWorld {
    //Coin Change - Max No. Of Ways
    public static void main(String[] args){
        int target = 4;
        int[] coin = {1,2,3};
        int N = coin.length;

        int ans = coinChange(coin,N,target);
        System.out.println(ans);
    }
    public static int coinChange(int[] coin, int N, int target){
        int[][] t = new int[N+1][target+1];
        for(int i=0;i<=N;i++){
            t[i][0] = 1;
        }
        for(int j=0;j<=target;j++){
            t[0][j] = 1;
        }
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= target; j++) {
                if (coin[i - 1] <= j) {
                    t[i][j] = t[i-1][j] + t[i][j - coin[i-1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[N][target];
    }
}