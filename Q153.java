Find Minimum in Rotated Sorted Array
Total Accepted: 68699 Total Submissions: 199704 Difficulty: Medium

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
public class Solution {//similar to older solution
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) return nums[0];//no rotate and one entry case;
        return findMinR(nums, 0, nums.length-1);
        
    }
    private int findMinR(int[] nums, int low, int high){
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[0]) low = mid+1;
            else{
                if (mid >0 && nums[mid-1] > nums[mid]) return nums[mid];
                high = mid-1;
            }
            
            
            
        }
        return -1;
        
        
    }
}


public class Solution { //similar but easier than cc150 11.3
    public int findMin(int[] nums) {
       //there is only one reflection point; on its right is the min
       //it can only be like below two cases: both segments are increasing order;
       //but left segment's elements are all larger than right segment in both cases if there is rotation
       //
       //        _______________        ________________
       //       |__________|____|  or  |___|____________|  
       //       
       //first to check if there is rotation or if it is of length 1 //this is very important as in the recursion function
       //below, it is very hard to return if no reflection point / no rotation
       if (nums[0] <= nums[nums.length - 1]) return nums[0]; //== is to check if length=1
       int result = findMinR(nums, 0, nums.length - 1);
       return result;
    }

    private int findMinR(int[] nums, int start, int end){
       while (start <= end){
          int mid = start + (end - start) / 2;
          if (nums[mid] > nums[0]){
             start = mid + 1;
          }
          else if (nums[mid] < nums[0]){
             if (nums[mid] < nums[mid-1]) return nums[mid];
             end = mid -1;
          }
          else return nums[mid+1];//if mid = 0; it means, start = 0; end = 1; so end is the one; because, it has to have reflection point, it cannot be at index 0;
       }
       return -1;
    }
}


/*

       if (start > end) return 0; //terminate condition: seems useless; without it, it still compiles
       int middle = (start + end) / 2;
       if (middle == 0) return nums[1]; //this line is for case: 9, 1, 2, 5, 6; then 9, 1, are at start and end; middle is at 9; below code cannot access middle - 1, as does not exist
       if (nums[middle] < nums[middle - 1]){ //this is where we find the reflection
          return nums[middle];
       }
       if (nums[middle] > nums[0]){  //reflection is on the right half
          return findMinR(nums, middle + 1, end);
       }
       else{  //reflection is on the left half
          return findMinR(nums, start, middle - 1);
       }
    }
*/
}
