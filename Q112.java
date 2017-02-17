// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//For example:
//Given the below binary tree and sum = 22,
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        int newSum = sum - root.val;
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
        
        
        
        
        
    }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       if (dfs(root, 0, sum)){
           return true;
       }
       else{
           return false;
       }
    }

    public boolean dfs(TreeNode node, int endingSum, int sum){
       if (node == null) return false;
       //pre-order DFS//
       //below first visiting current node
       int newSum =  endingSum + node.val;  
      //newSum is the new ending sum (sum from root to node.val)
       //below is to satisfy the condition root to leaf
       if (node.left == null && node.right == null){
         if (newSum == sum){
            return true;
         }
       }
       return dfs(node.left, newSum, sum) || dfs(node.right, newSum, sum);
    }
}

