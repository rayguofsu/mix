414. Third Maximum Number

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

public class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
public class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++){
            max = nums[i] > max ? nums[i] : max;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == max) continue;
            sec = nums[i] > sec ? nums[i] : sec;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == max || nums[i] == sec) continue;
            third = nums[i] > third ? nums[i] : third;
            flag = true;
        }
        return flag ? third : max;
    }
}


