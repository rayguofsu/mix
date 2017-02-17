270. Closest Binary Search Tree Value

 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution { //by myself
    public int closestValue(TreeNode root, double target) {
        double diff = root.val - target;
        int res = root.val;
        while(root != null){
            double newDiff = root.val - target;
            if (Math.abs(newDiff) < Math.abs(diff)){
                res = root.val;
                diff = newDiff;
            }
            if (newDiff < 0){
              root = root.right;
            }
            else{
              root = root.left;    
            }
        }
        return res;
    }
}
