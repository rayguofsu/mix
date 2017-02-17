Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

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
  public List<Integer> postorderTraversal(TreeNode root) {
     LinkedList<Integer> list = new LinkedList<Integer>();
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode p = root;
     while (!stack.isEmpty() || p != null){ 
         if (p != null){
            stack.push(p);
            //doing it backwardly
            list.addFirst(p.val); //has to use linkedlist, since only linkedlist has addFirst
            p = p.right;
         }
         else{
            p = stack.pop().left;
         }
     }
     return list;
  }
}




