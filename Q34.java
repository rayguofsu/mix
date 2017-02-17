34. Search for a Range
Total Accepted: 71731 Total Submissions: 252267 Difficulty: Medium

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 

public class Solution {
    public int[] searchRange(int[] nums, int target) {










                //So easy to use 2 Binary Search methods
        // 1 BS is to find the left boarder  with O(log n)
        // 1 BS is to find the right boarder with O(log n)
        //totally O(2*log N) = O(log N)
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int l = 0;
        int r = nums.length - 1;
        //get left boundary
        while (l <= r){
           int mid = (l + r) / 2;
           if (nums[mid] >= target){
              if (nums[mid] == target){
                 res[0] = mid;
                 //break: cannot have it here; as we are to find the left most one!!!
              }
              r = mid - 1;
           }
           else{// if (nums[mid] < target)
              l = mid + 1;
           }
        }
        
        //get right boundary
        r = nums.length - 1;
        //l = res[0];  //l will stop here for sure; not needed here!
        if (res[0] != -1){
          while (l <= r){
             int mid = (l + r) / 2;
             if (nums[mid] > target){
               r = mid - 1;
             }
             else{  //<= target
               if (nums[mid] == target){
                 res[1] = mid;
               }
               l = mid + 1;
             }
           }
        }
        return res;
    }
}
