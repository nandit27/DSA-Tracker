import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{2,3,7,8,10};
        int sum = 11;
        boolean[][] t = new boolean[arr.length + 1][sum + 1];
        int n = arr.length;
        for(int i=0;i<=n;i++) t[i][0] = true;
        for(int j=0;j<=sum;j++) t[0][j] = false;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(i==0) t[i][j] = false;
                if(j==0) t[i][j] = true;
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        } 
        System.out.println(t[n][sum]);
        sc.close();
    }
}