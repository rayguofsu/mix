31. Next Permutation
Total Accepted: 61386 Total Submissions: 234007 Difficulty: Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


public class Solution {
    public void nextPermutation(int[] nums) {















    /*
    Analysis

Four steps to solve this problem:
1) scan from right to left, find the first element that is less than its previous one.

4 5 9 6 2 1 
  |
  p

2) scan from right to left, find the first element that is greater than p.

4 5 9 6 2 1 
      |
      q

3) swap p and q

4 6 9 5 2 1 


4) reverse elements [p+1, nums.length]

4 6 1 2 5 9 

*/
        if (nums == null || nums.length < 2) return;
        int length = nums.length;
        int p = -1;
        int q = -1;
        for (int i = length - 1; i > 0; i--){
            if (nums[i] > nums[i - 1]){
                p = i - 1;
                break;
            }
        }
        if (p == -1){
            reverse(nums, 0, length -1);
            return;
        }
        for (int i = length - 1; i > p; i--){
            if (nums[i] > nums[p]){
                q = i;
                break;
            }
        }
        //swap p & q;
        int tmp = nums[q];
        nums[q] = nums[p];
        nums[p] = tmp;
        //
        reverse(nums, p + 1, length - 1);
    }
    private void reverse(int[] nums, int left, int right){
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
