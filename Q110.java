110. Balanced Binary Tree
Total Accepted: 95990 Total Submissions: 287587 Difficulty: Easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

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
    public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1){
            return false;
        }
        else{
            return true;
        }
    }
    //this function using post-order DFS; not only check height, but also check ballance
    //ballence has higher priority than height calculation
    //i.e. if left or right not ballanced, immeidiately return -1 to indicate unballenced
    //if both left and right ballanced; then return the max height to next recursion;
    //every node is visited only once
    public int checkHeight(TreeNode n){
        if (n == null) return 0;
        int leftH = checkHeight(n.left);
        //below has higher priority then checkHeight(n.right)
        if (leftH == -1){
            return -1;
        }
        int rightH = checkHeight(n.right);
        if (rightH == -1){
            return -1;
        }
        //if both left and right are ballenced; then compare the height of left and right
        if (Math.abs(leftH - rightH) > 1){
            return -1;
        }
        //if left and right has height diff <= 1; then return the lower priority height to next recursion
        return Math.max(leftH, rightH) + 1;
    }
}
