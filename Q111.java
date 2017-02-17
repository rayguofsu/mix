Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//at first coded wrong, coded as just return Math.min(left, right) + 1
//it is wrong, since it requires shortest path from root to leaf
//leaf means node with no children; therefore added the if(left == null) else(right==null)

//
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
    public int minDepth(TreeNode root) {
        return minDepthR(root, 0);
    }
    public int minDepthR(TreeNode root, int depth){
        if (root == null) return depth;
        //if (root.left == null && root.right == null) return depth + 1;
        if (root.left == null){
            return minDepthR(root.right, depth + 1);
        }
        else if (root.right == null){
            return minDepthR(root.left, depth + 1);
        }
        else{
            return Math.min(minDepthR(root.left, depth + 1), minDepthR(root.right, depth + 1));
        }
    }
}



public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null){
            //here skip left subtree; as left subtree has no children
            //if right part also has no children, returning below is also fine; as it will return 1; (1 is for current node, which is not null)
            return minDepth(root.right) + 1;
        }
        else if (root.right == null){
            return minDepth(root.left) + 1;
        }
        else{ //if both right or left subtree are not null; then return min of them, + 1 is for current node
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
