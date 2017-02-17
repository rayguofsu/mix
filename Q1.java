1. Two Sum
Total Accepted: 208401 Total Submissions: 933810 Difficulty: Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully. 

public class Solution {





    /*Naive solution O(N^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == tmp){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }
    */
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //there are brutal force O(N^2); one-pass solution O(N); and two-pass solution O(N); below is one-pass solv
    //but this solution has same run time as naive method (which use two for loop);(not true, see below)
    //but run time result shows this is faster, beat %59 vs beat %27
    public int[] twoSum(int[] nums, int target) {//it is O(N), see below
        int[] result = new int[2];
        map.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++){
            if (map.get(nums[i]) != null){    //it turns out this is the same as below commented, search containsKey(?) with size N map is faster than going through an array with length N
            //that is because: time complexity for get() is O(1) according to API java doc:
          //  This implementation provides constant-time performance for the basic operations (get and put), assuming the hash function //disperses the elements properly among the buckets.
            //Generally O(1), but if we using bad hashCode function we need add more elements to one bucket and it can be O(n) in worst case
            
            //if (map.containsKey(nums[i])){//contains is also O(1); Since containsKey() is just a get() that throws away the retrieved value, it's O(1) (assuming the hash function works properly, again).
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            else{
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
    
}
