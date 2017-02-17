Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

public class Solution {
    //similar to cc11.3;
    //yes, if no duplicate; then either go to right or left; so O(logN)
    //but if has many duplicate, 2, 2, 2, 2, 2, 4, 5, 2 or 2, 4, 5, 2, 2, 2, 2;
    //by comparing middle to left or right, no way we can decide which side to go;
    //so we have to search both sides, if this case keep coming, we end up searching both sides for many times, so it is O(N) now
    public boolean search(int[] nums, int target) {
       if (nums == null || nums.length == 0) return false;
       return searchR(nums, 0, nums.length - 1, target);
    }

    private boolean searchR(int[] nums, int left, int right, int target){
      // rely on binary search, since it is sorted with at most one reflection point
      int middle = (left + right) / 2;
      if (nums[middle] == target) return true;
      if (left > right) return false;
      if (nums[left] < nums[middle]){ //left half is sorted
         if (nums[left] <= target && target < nums[middle]){
             return searchR(nums, left, middle - 1, target);
         } 
         else{
             return searchR(nums, middle + 1, right, target);
         }
      }
      else if (nums[left] > nums[middle]){//right half is sorted
         if (nums[middle] < target && target <= nums[right]){
             return searchR(nums, middle + 1, right, target);
         }
         else{
             return searchR(nums, left, middle - 1, target);
         }
      }
      else{ //nums[left] == nums[middle] 
         if (nums[middle] != nums[right]){  //only left half has all dupli
             return searchR(nums, middle + 1, right, target);
         }
         else{ //middle == left ==right here,either left half or right half all dupli
             //e.g. 2, 4, 5, 2, 2, 2, 2, 2 or 2, 2, 2, 2, 2, 4, 5, 2
             //based on the info that mid == left == right, we cannot distinguish it
             //so we have to search both sides in this case
             boolean result = searchR(nums, left, middle - 1, target);
             if (!result){
                return searchR(nums, middle + 1, right, target);
             }
             else{
                return true;
             }
         }
      }
      //return false; if put it here, it tells unreacheable return 
    }
}
