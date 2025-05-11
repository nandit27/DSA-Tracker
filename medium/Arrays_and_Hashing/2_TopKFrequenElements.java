import java.util.*;
 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        List<int[]> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            temp.add(new int[]{entry.getValue(), entry.getKey()});
        }
        
        Collections.sort(temp, (a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < k; i++) {
            ans.add(temp.get(i)[1]);
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}