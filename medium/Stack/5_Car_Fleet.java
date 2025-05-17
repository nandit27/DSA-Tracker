import java.util.*;
 
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] pair = new double[n][2];
        for(int i=0;i<n;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair,(a,b) -> Double.compare(a[0],b[0]));

        Stack<Double> stk = new Stack<>();

        for(int i=n-1;i>=0;i--){
            double time = (target - pair[i][0]) / pair[i][1];

            if(!stk.isEmpty() && time <= stk.peek()){
                continue;
            }
            stk.push(time);
        }
        return stk.size();
    }
}