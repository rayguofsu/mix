Given preorder and inorder traversal of a tree, construct the binary tree.

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

public TreeNode buildTree(int[] preorder, int[] inorder) {
















    int preStart = 0;
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;
 
    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
}
//has new understanding; the first time, assume that we have a dummy node used as root; so its left node is construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
//(i.e. left and right subtree in next level is mixed together,i.e. preStart to preEnd for preorder; and inStart to inEnd); so each recursion gives next level mixed version of left subtree and rightTree//


//From the pre-order array, we know that first element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array. 
//
//Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. Recursively, we can build up the tree.
//

public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
        return null;
    }
 
    int val = preorder[preStart];
    TreeNode p = new TreeNode(val);
 
    //find parent element index from inorder
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(val == inorder[i]){
            k=i;
            break;
        }
    }
                           //lefttree start and ending index   
    p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
                           //righttree start and ending index
    p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
    return p;
}
/* this solution works (mine) but code not clean
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
       TreeNode root = new TreeNode(preorder[0]);
       buildTreeR(preorder, inorder, root, 0, 0, inorder.length - 1); 
       return root;
    }
    private void buildTreeR(int[] preorder, int[] inorder, TreeNode root, int rootPre, int s, int e){
       int rootIn = Integer.MAX_VALUE;
       for (int i = s; i <= e; i++){
          if (inorder[i] == root.val){
             rootIn = i;
             break;
          }
       }
       if (rootIn > s){ //this means it has left tree
          root.left = new TreeNode(preorder[rootPre + 1]);
          buildTreeR(preorder, inorder, root.left, rootPre + 1, s, rootIn - 1);
       }
       else{
          root.left = null;
       }
       if (rootIn < e){
          int rootIndex = rootPre + rootIn - s  + 1;
          root.right = new TreeNode(preorder[rootIndex]);
          buildTreeR(preorder, inorder, root.right, rootIndex, rootIn + 1, e);
       }
       else{
         root.right = null;
       }
    }
}
*/
