 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 





public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        int max = leftMax[0];  //need to have this here; and leftMax and rightMax stores the max from left to i and right to i
        for (int i = 1; i < len; i++){
            leftMax[i] = max;
            max = Math.max(height[i], max);
        }
        max = height[len - 1];
        for (int i = len - 2; i >= 0; i--){
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }
        int total = 0;
        for (int i = 1; i < len - 1; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            total = water < 0 ? total : total + water;
        }
        return total;
    }
}
