/*96. Unique Binary Search Trees
Total Accepted: 75061 Total Submissions: 204011 Difficulty: Medium

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class Solution {
    public int numTrees(int n) { //DP
        int[] num = new int[n + 1];
        //num[n] is the total unique BST for totally n number(1, 2, .. n)
        num[0] = 1;
        //当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
//以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。

//num[n] = ∑ num[j] * num[ n - 1 - j]     0<=j<=n-1 (here for each partial sum, j  is the root)

//Another explanartion by sb else:
//Let count[i] be the number of unique binary search trees for i. The number of trees are determined by the number of subtrees which have different root node. For example,
//  (count is num here)
//i=0, count[0]=1 //empty tree

//i=1, count[1]=1 //one tree

//i=2, count[2]=count[0]*count[1] // 1 is root  (c0 is number of left subtrees; c1 is number of right subtrees)
//            + count[1]*count[0] // 2 is root

//i=3, count[3]=count[0]*count[2] // 1 is root
//            + count[1]*count[1] // 2 is root
//            + count[2]*count[0] // 3 is root

//i=4, count[4]=count[0]*count[3] // 1 is root
//            + count[1]*count[2] // 2 is root
//            + count[2]*count[1] // 3 is root
//            + count[3]*count[0] // 4 is root
        for (int i = 1; i <= n; i++){
            int sum = 0;
            for (int j = 0; j < i; j++){
                sum += num[j] * num[i - 1 - j];
            }
            num[i] = sum;
        }
        
        return num[n];
    }
}
