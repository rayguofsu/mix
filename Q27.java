27. Remove Element
Total Accepted: 112666 Total Submissions: 334886 Difficulty: Easy

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

    Try two pointers.
    Did you use the property of "the order of elements can be changed"?
    What happens when the elements to remove are rare?
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int len  = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) nums[len++] = nums[i];
        }
        return len;
    }
}


public class Solution {
    public int removeElement(int[] nums, int val) {












        //similar to push 0s to array's back
        int count = 0;  // count of == val entries
        int numCount = 0; // count of != val entries
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                //if (count != 0){ no need to do this
                    nums[i - count] = nums[i];
               // }
                numCount += 1;
            }
            else{ //nums[i] == val here
                count += 1;
            }
        }
        return numCount;
        
    }
}
