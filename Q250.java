250. Count Univalue Subtrees

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5

return 4. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {//similar to my solution, but complement return boolean
    public int countUnivalSubtrees(TreeNode root) {
        int[] arr = new int[1];
        postOrder(arr, root);
        return arr[0];
    }
    public boolean postOrder (int[] arr, TreeNode node) {
        if (node == null) return true;
        boolean left = postOrder(arr, node.left);
        boolean right = postOrder(arr, node.right);
        if (left && right) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            arr[0]++;
            return true;
        }
        return false;
    }
}

public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }
    
    private boolean dfs(TreeNode root, int[] count){
        if (root == null) return true;
        boolean left = dfs(root.left, count);
        boolean right = dfs(root.right, count);
        if (left && right){//only when both left and right are true, to consider to do count++ (count++ is for adding cur root node to gen a new such tr)
            if (root.right == null && root.left == null){
                count[0]++; //if left and right both null; so current node is one such tree
                return true;
            }
            else if (root.left==null){
                if (root.right.val == root.val){
                    count[0]++;//if left is null, and cur node equals right, adding cur node gives a new such tr
                    return true;
                }
            }
            else if (root.right == null){
                if (root.left.val == root.val){
                    count[0]++;
                    return true;
                }
            }
            else{
                if (root.right.val == root.left.val && root.right.val == root.val){
                    count[0]++;//if left.val == right.val==root.val; adding cur root node give a new such tree
                    return true;
                }
            }
        }
        return false;
        
    }
}
