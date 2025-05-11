import java.util.*;
 
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> vals = new HashSet();

        for(int num : nums){
            vals.add(num);
        }
        int max = 0;
        for(int val : vals){

            if(vals.contains(val-1)) continue;

            int cur = val;
            int len = 1;
            while(vals.contains(cur+1)){
                len += 1;
                cur += 1;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}