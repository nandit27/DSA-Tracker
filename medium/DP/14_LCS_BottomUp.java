import java.util.*;

public class HelloWorld {
    //LCS - Longest Common Subsequence - Bottom Up
    static int[][] t;
    public static void main(String[] args){
        String x = "abcdgh";
        String y = "abedfhr";
        t = new int[x.length()+1][y.length()+1];
        int ans = LCS(x,y,x.length(),y.length());
        System.out.println(ans);
    }
    public static int LCS(String x, String y, int n, int m){
       if(n == 0 || m == 0) return 0;
       for(int i=0;i<n+1;i++){
           for(int j=0;j<m+1;j++){
               if(i == 0 || j == 0) t[i][j] = 0;
           }
       }
       for(int i=1;i<n+1;i++){
           for(int j=1;j<m+1;j++){
               if(x.charAt(i-1) == y.charAt(j-1)){
                   t[i][j] = 1 + t[i-1][j-1];
               }
               else{
                   t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
               }
           }
       }
       return t[n][m];
    }
}