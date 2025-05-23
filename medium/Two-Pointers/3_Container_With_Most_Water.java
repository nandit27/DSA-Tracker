import java.util.*;
 
class Solution {
    public int maxArea(int[] height) {
        int maxiArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int area = (right-left) * Math.min(height[left],height[right]);
            if(area > maxiArea) maxiArea = Math.max(maxiArea,area);
            else{
                if(height[left] < height[right]) left++;
                else right--;
            }
        }
        return maxiArea;
    }
}