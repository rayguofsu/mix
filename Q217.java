Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 


import java.util.Set;
import java.util.HashSet;
public class Solution {
    public boolean containsDuplicate(int[] nums) {


















        Set<Integer> alreadyPresent = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (alreadyPresent.contains(nums[i])){
                return true;
            }
            alreadyPresent.add(nums[i]);
        }
        return false;
    }
}
