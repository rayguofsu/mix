98. Validate Binary Search Tree
Total Accepted: 74279 Total Submissions: 364247 Difficulty: Medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*//

public class Solution {

    public boolean isValidBST(TreeNode root) {//[2147483647] without valid protection, it goes wrong; as we should not return false
      //CC150: ORIGIANL Q4.5 Solution 1
      //simple: just use recursion; when goes left, max got updated; when goes right, min got updated
      //the two flag signals are used for cases whether node.val = INTEGER_MAX/MIN
      //when the flag vaid signal is false, it means the max/min has not been updated at leaset once, it is still Integer.MAX/MIN, in other words, node's value can be whatever small if min_valid is false, if you make valid now, then after compare (>=) will return false;

      //The time complexity for this solution is 0(N), where N is the number of nodes in the
      //tree. We can prove that this is the best we can do, since any algorithm must touch all N
      //nodes.
      //Due to the use of recursion, the space complexity is 0( log N) on a balanced tree.There
      //are up to 0(log N) recursive calls on the stack since we may recurse up to the depth
      //of the tree.
       if (root == null) return true;
       return isValidBSTR(root, Integer.MAX_VALUE, Integer.MIN_VALUE, false, false);
    }
    
    public boolean isValidBSTR(TreeNode root, int max, int min, boolean maxValid, boolean minValid){
       if (root == null) return true;
       if (maxValid && root.val >= max) return false;
       if (minValid && root.val <= min) return false;
       return isValidBSTR(root.left, root.val, min, true, minValid) && isValidBSTR(root.right, max, root.val, maxValid, true);
    }
    
}
