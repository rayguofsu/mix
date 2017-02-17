300. Longest Increasing Subsequence
Total Accepted: 17777 Total Submissions: 53162 Difficulty: Medium

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n^2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? 
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int index = binarySearch(res, nums[i]);
            
            if (index == res.size()){
                res.add(nums[i]);
            }
            else{
                res.set(index, nums[i]);
            }
        }
        return res.size();
    }
    private int binarySearch(List<Integer> res, int target){
        int lo = 0, hi = res.size()-1;
        while(lo <= hi){
            //System.out.println("index is " + lo +" and " + hi);
            int mid = lo + (hi -lo) /2;
            if (res.get(mid) < target) lo = mid+1;
            else if (res.get(mid) > target) hi = mid-1;
            else return mid;
        }
        return lo;
    }
}














public class Solution {
    //both 2 solutions are good ones.
    public int lengthOfLIS(int[] nums) {//way 1 is of O(nlogn); obviously faster than way2
    //idea is to use a seperate array to keep increasing subsequence by order, increase the size only when necesssary;
    //now there are two cases you want to think: <i>. continue expanding the current array size; <ii> replace entry in this separate sub array with smaller entry just in case we may have smaller, but longer sub array later(we can do this, as it will not increase size, but it will give a chance to smaller but longer sub array); by doing below can achieve both; as for <i>, we only expand by appending; for <ii>, below covers also;
    //
        int[] sub = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++){
            int j = BinarySearchForPosition(sub, 0, size - 1, nums[i]);
            sub[j] = nums[i];
            if (j == size){
                size++;
            }
        }
        return size;
    }
    private int BinarySearchForPosition(int[] sub, int left, int right, int target){
        while (left <= right){//java Arrays has built in BS, but here modify it;
            int mid = left + (right - left) / 2;
            if (sub[mid] == target){
                return mid;
            }
            else if (sub[mid] > target){
                right = mid - 1;
            }
            else{// < target
                left = mid + 1;
            }
        }
        return left;  //if 1, 2, 3, and 0 is the target, then index 0 will be returned to replace array;
                      //if 1, 2, 3, and 4 is the target, then index 3 will be returned to expand array;
    }
    /*
    public int lengthOfLIS(int[] nums) {//way 2 is of O(n^2)
        //idea is to use a separate array, where each entry[i] keeps the size of LIS ending in nums[i]
        //then while traversing the original array, we look back to i - 1 entries of the separate array to calculate the value for the current entry in separate array and update the max// somehow they call this DP for separate array storing the history
        if (nums == null || nums.length == 0) return 0; //saw ppl use this all the time
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;  //worst case: every entry can be a unique LIS with size of 1
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1); //+1 means ending with current nums[i]
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    */
}
