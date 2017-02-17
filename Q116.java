/*116. Populating Next Right Pointers in Each Node
Total Accepted: 79046 Total Submissions: 216927 Difficulty: Medium

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {//this solution may not be constant space, as it is recursion
    /*public void connect(TreeLinkNode root) {
        if (root == null || root.left == null){
            return;
        }
        //pre-order DFS
        root.left.next = root.right;
        if (root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    */
        //can do it easily iteratively using BFS
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null){
            return;
        }
        //BFS
        Stack<TreeLinkNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
           TreeLinkNode node = stack.pop();
           if (node.left != null){
              node.left.next = node.right;
              if (node.next !=null){  //here is the key
                 node.right.next = node.next.left;
              }
              stack.push(node.left);
              stack.push(node.right);
           }
        }
    }

}



