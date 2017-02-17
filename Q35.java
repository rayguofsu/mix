//Search Insert Position
//
//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0 
public class Solution {
 public int searchInsert(int[] nums, int target) {//found online but easy to understand
    int res = 0, low = 0, high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (target > nums[mid]) {
            low = mid + 1;
            res = mid + 1;
        } else if (target < nums[mid]) {
            high = mid - 1;
            res = mid;
        } else {
            return mid;
        }
    }
    return res;
}



        //if (target < nums[0]) return 0;
        if (target <= nums[0]) return 0; //adding "=", return 0 if match happens at index 0
        for (int i = 0; i < nums.length - 1; i++){
           if (nums[i] == target){
              return i;
           }
           else if (nums[i] < target && target <= nums[i + 1]){
              return i + 1;
           }
        }
        return nums.length;
    }
}
