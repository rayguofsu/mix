//Given an array of integers, every element appears twice except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
public class Solution {
    public int singleNumber(int[] nums) {
        //idea one: using hashtable<Integer, Boolean> if once only, false, if twice then true. But space cost high
        //idea two: sort first then check every two adjacent entries; but Array.sort(array) cost O(nlogn) and non constant space
        //idea three: using XOR: a^b^c = a^(c^b) = (a^c)^b; the order does not matter
        /* idea one HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], false);
            }
            else{
                map.put(nums[i], true);
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (!map.get(nums[i])) return nums[i];
        }
        return 0;
        */
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++){
            nums[i] ^= nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}
