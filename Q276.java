276. Paint Fence

 There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers. 
 
 public int numWays(int k, int n){
    int[] dp = {0, k, k*k, 0};
    if (n <= 2) return dp[n];
    for (int i = 3; i <= n; i++){
       dp[3] = dp[2] * (k - 1) + dp[1] * (k - 1);
       dp[1] = dp[2];
       dp[2] = dp[3];
    }
    return dp[3];
 }思路是这样：
 
 第一个有K种，第二完后有K*K种，第三个：
 K - 1 - (k - 1)    i.e. dp[1] *（ｋ　－　１）; 表示第二个和第一个一样颜色，第三个不同的一共几种
 ｋ　－　(ｋ－１)　－　１　　　ｉ．ｅ．　k *（ｋ－１）　　＊1  表示第二个和第一个不同， 但第三个和第二个相同。
 k - (k -1)  - (k - 1) i.e. ｋ　＊　(k - 1) * (k - 1) 表示第二个和第一个不同，但第三个可以和第一个相同，但不和第二个相同
 
 众合一下，k *（ｋ　－　１）　＊　１　＋k*(k-1)*(k-1) = k*k*(k-1) = dp[2] * (k-1)
 
 
 FROM ON LINE: 这种给定一个规则，计算有多少种结果的题目一般都是动态规划，因为我们可以从这个规则中得到递推式。根据题意，不能有超过连续两根柱子是一个颜色，也就意味着第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。假设dp[1]是第一根柱子及之前涂色的可能性数量，dp[2]是第二根柱子及之前涂色的可能性数量，则dp[3]=(k-1)*dp[1] + (k-1)*dp[2]。

递推式有了，下面再讨论下base情况，所有柱子中第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。
 
 public class Solution {
    public int numWays(int n, int k) {
        // 当n=0时返回0
        int dp[] = {0, k , k*k, 0};
        if(n <= 2){
            return dp[n];
        }
        for(int i = 2; i < n; i++){
            // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
 

public class Solution {
    
public int numWays(int n, int k) {
    if(n == 0) return 0;
    else if(n == 1) return k;
    int diffColorCounts = k*(k-1);
    int sameColorCounts = k;
    for(int i=2; i<n; i++) {
        int temp = diffColorCounts;
        diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
        sameColorCounts = temp;
    }
    return diffColorCounts + sameColorCounts;
}
/*
We divided it into two cases.

    the last two posts have the same color, the number of ways to paint in this case is sameColorCounts.

    the last two posts have different colors, and the number of ways in this case is diffColorCounts.

The reason why we have these two cases is that we can easily compute both of them, and that is all I do. When adding a new post, we can use the same color as the last one (if allowed) or different color. If we use different color, there're k-1 options, and the outcomes shoule belong to the diffColorCounts category. If we use same color, there's only one option, and we can only do this when the last two have different colors (which is the diffColorCounts). There we have our induction step.

Here is an example, let's say we have 3 posts and 3 colors. The first two posts we have 9 ways to do them, (1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3). Now we know that

diffColorCounts = 6;

And

sameColorCounts = 3;

Now for the third post, we can compute these two variables like this:

If we use different colors than the last one (the second one), these ways can be added into diffColorCounts, so if the last one is 3, we can use 1 or 2, if it's 1, we can use 2 or 3, etc. Apparently there are (diffColorCounts + sameColorCounts) * (k-1) possible ways.

If we use the same color as the last one, we would trigger a violation in these three cases (1,1,1), (2,2,2) and (3,3,3). This is because they already used the same color for the last two posts. So is there a count that rules out these kind of cases? YES, the diffColorCounts. So in cases within diffColorCounts, we can use the same color as the last one without worrying about triggering the violation. And now as we append a same-color post to them, the former diffColorCounts becomes the current sameColorCounts.

Then we can keep going until we reach the n. And finally just sum up these two variables as result.

Hope this would be clearer.

*/    
    
    

}
