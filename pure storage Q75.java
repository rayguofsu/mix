/*75. Sort Colors
Total Accepted: 87750 Total Submissions: 257075 Difficulty: Medium

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
below solution use the least number of swap: //asked by pure storage
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = 0, one = 0, two = 0;
        for (int i= 0; i < nums.length; i++){
            if (nums[i] == 2) two++;
            else if (nums[i] == 1){
                one++;
                nums[i - two] = 1;
                if (two > 0) nums[i] = 2;
            }
            else if (nums[i] == 0){
                zero++;
                nums[i - one - two] = 0;
                if (two > 0){
                    nums[i] = 2;
                }
                if (one > 0){
                    nums[i - two] = 1;
                }
            }
        }
    }
}



public class Solution {
    public void sortColors(int[] nums) {














        //Way 1: use two pass:  iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

        // use one pass:
        //for one pass, can use for loop and if (num[i] ==0){System.arraycopy(c1 + c2)} 
        //if (nums[i] == 1){System.arraycopy(c2), c1++}; if (nums[i] == 2){c2++}
        //3 ifs's order matters; like priority
        /* this is one pass solution, but may not be faster than two pass, as on same entries the value could be changed N times for worst case
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < nums.length; i++){ //similar to my solution of moving zeros
            if (nums[i] == 0){
                System.arraycopy(nums, i-c1-c2, nums, i-c1-c2+1, c1+c2);
                nums[i-c1-c2] = 0;
            }
            else if (nums[i] == 1){
                System.arraycopy(nums, i-c2, nums, i-c2+1, c2);
                nums[i-c2] = 1;
                c1++;
            }
            else if (nums[i] == 2){
                c2++;
            }
        }
        */
        //this is the two pass solution: results show this is faster than one pass solution
        int c1 = 0;
        //int c2 = 0;
        int c0 = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                c1++;
            }
            if (nums[i] == 0){
                c0++;
            }
        }
        //c2 = nums.length - c1 - c0;
        int i = 0;
        while (i < c0){
            nums[i] = 0;
            i++;
        }
        while (i < c1 + c0){
            nums[i] = 1;
            i++;
        }
        while (i < nums.length){
            nums[i] = 2;
            i++;
        }
    }
}

