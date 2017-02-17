222. Count Complete Tree Nodes
Total Accepted: 24480 Total Submissions: 104008 Difficulty: Medium

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;                  
        int heightL = heightLeft(root.left);
        int heightR = heightRight(root.right); 
        if (heightL == heightR){     //these above 3 lines is for speeding up only; without it the other else itself can return right value but slow
            return (2 << heightL) - 1; //deng bi shu lie // 2<<N is different from 2^N
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    private int heightLeft(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    private int heightRight(TreeNode root){
        int height = 0;
        while (root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}

