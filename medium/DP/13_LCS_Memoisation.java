import java.util.*;

public class HelloWorld {
    //LCS - Longest Common Subsequence - Memoisation
    public int[][] t;
    public static void main(String[] args){
        String x = "abcdgh";
        String y = "abedfhr";
        t = new int[x.length()+1][y.length()+1];
        int ans = LCS(x,y,x.length(),y.length());
        System.out.println(ans);
    }
    public static int LCS(String x, String y, int n, int m){
       if(n == 0 || m == 0) return 0;
       if(t[n][m] != -1) return t[n][m];
       if(x.charAt(n-1) == y.charAt(m-1)){
           t[n][m] =  + LCS(x,y,n-1,m-1);
       }
       else{
           t[n][m] = Math.max(LCS(x,y,n-1,m), LCS(x,y,n,m-1));
       }
       return t[n][m];
    }
}