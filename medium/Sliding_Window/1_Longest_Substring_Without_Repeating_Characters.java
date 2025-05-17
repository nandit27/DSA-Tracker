import java.util.*;
 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength,i-start+1);
        }
        return maxLength;
    }
}