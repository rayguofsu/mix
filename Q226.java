//Invert a binary tree.
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
//to
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
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
    public TreeNode invertTree(TreeNode root) { 








        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
    }
}













      //old solution: if (root == null) return null; //missied this at first
      //old solution: if (root.left == null && root.right == null){
      //old solution:    return root;
      //old solution: }
      //old solution: //pre-order visits parents first; which is more intuitive
      //old solution: //invert parent node first; then invert chilren; every node spot only visited once
      //old solution: TreeNode rightBuff = root.right;
      //old solution: root.right = root.left;
      //old solution: root.left = rightBuff;
      //old solution: invertTree(root.left);
      //old solution: invertTree(root.right);
      //old solution: return root;
    }
}



}
