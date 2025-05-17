import java.util.*;
 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        solve(res,0,0,"",n);
        return res;
    }
    public void solve(List<String> res, int left,int right, String s,int n){
        if(s.length() == n*2){
            res.add(s);
            return;
        }
        if(left < n) solve(res,left+1,right,s+"(",n);
        if(right < left) solve(res,left,right+1,s+")",n);
    }
}