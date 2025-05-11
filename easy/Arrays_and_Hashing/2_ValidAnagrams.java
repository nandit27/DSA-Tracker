import java.util.*;
 
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> freqMap1 = new HashMap<>();
        for(char c: s.toCharArray()) freqMap1.put(c,freqMap1.getOrDefault(c,0)+1);
        for(char c: t.toCharArray()) freqMap1.put(c,freqMap1.getOrDefault(c,0)-1);
        boolean flag = true;
        for(int val: freqMap1.values()){
            if(val != 0) return false;
        }
        return true;
    }
}