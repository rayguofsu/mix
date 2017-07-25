 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers? 
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
        
        
    }
    
    
    
    
    
   /* private int globalCnt = 0;
    public int combinationSum4(int[] nums, int target) {//slow O(N!)
        Arrays.sort(nums);
        helper(nums, target, 0);
        return globalCnt;
    }
    private void helper(int[] nums, int target, int sum){
        if (sum == target){
            globalCnt++;
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (target < sum + nums[i]) break;
            helper(nums, target, sum + nums[i]);
        }
    
    }
    */

