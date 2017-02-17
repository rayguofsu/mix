189. Rotate Array
Total Accepted: 61340 Total Submissions: 300833 Difficulty: Easy

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]
Hint:
Could you do it in-place with O(1) extra space?

Related problem: Reverse Words in a String II

public class Solution {
   /* public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //space of O(k)
        int[] temp = new int[k];   //this will contain the last k element
        System.arraycopy(nums, nums.length - k, temp, 0, k); //copy the last k element
        System.arraycopy(nums, 0, nums, k, nums.length -k); //shift the first nums.length - k back by k
        System.arraycopy(temp, 0, nums, 0, k); //put temp in the first k entries
    }
    */
    
    //second space(O(1))
    public void rotate(int[] nums, int k) {






public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <=0) return;
        int len = nums.length;
        k %= len;
        for (int i = 0; i < k; i++){
            int tmp = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = tmp;
        }
    }
}








        k = k % nums.length;
        int i = 0;
        int tmp = 0;
        while (i < k){
            //O(1) space solution, move array back by one entry each time
            tmp = nums[nums.length - k + i];
            //push back one entry: from start,   to start,  length
            System.arraycopy(nums, i, nums, i+1, nums.length - k);
            nums[i] = tmp;
            i++;
        } 
    }
}
