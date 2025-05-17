import java.util.*;
 
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int wait = 0;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                int idx = stk.pop();
                ans[idx] = i - idx;
            }
            stk.push(i);
        }
        return ans;
    }
}