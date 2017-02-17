Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {//similar to Q105//to start, postorder last entry is root
    public TreeNode buildTree(int[] inorder, int[] postorder) {
              if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
              return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1); 
    }

    private TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd){
       if (inStart > inEnd || poStart > poEnd) return null;
       TreeNode node = new TreeNode(postorder[poEnd]);
       int i = 0;
       for (i = inStart; i < inEnd; i++){
            if (inorder[i] == node.val){
               break;
            };
       }
       node.left = construct(inorder, inStart, i - 1, postorder, poStart, poStart + i - 1 - inStart);
       node.right = construct(inorder, i + 1, inEnd, postorder, poStart + i - inStart, poEnd - 1);
       return node;
    }

}
