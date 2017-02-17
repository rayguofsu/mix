70. Climbing Stairs
Total Accepted: 93178 Total Submissions: 258411 Difficulty: Easy

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        return climbR(n, dp);
    }
    private int climbR(int n, int[] dp){
        if (n < 0) return 0;
        if (dp[n] > 0) return dp[n];
        dp[n] = climbR(n -1, dp) + climbR(n - 2, dp);
        return dp[n];
    }
}


public class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {



















        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo.containsKey(n)){ //if not using the DP method, the run time will be 2^n; as each call will braches into 2 other call
            return memo.get(n);
        }
        int ways = climbStairs(n - 2) + climbStairs(n - 1);
        memo.put(n, ways);
        return ways;
    }
}
