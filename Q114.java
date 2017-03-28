114. Flatten Binary Tree to Linked List
Total Accepted: 74686 Total Submissions: 245134 Difficulty: Medium

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

click to show hints.
Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
    public void flatten(TreeNode root) {
        if (root != null) help(root);
    }
    private TreeNode help(TreeNode root){
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = help(root.left);
        TreeNode right = help(root.right);
        if (left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right == null ? left : right;//incase it is 
        //     1
        //    /
        //   2
        //  /
        // 3 
    }
}
         
         
         

public class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null) {
            return;
        }
        
        TreeNode tail = root;
        while(null != tail) {
            TreeNode left = tail.left;
            TreeNode right = tail.right;
            
            tail.left = null;
            if(left != null) {
                tail.right = left;
                while(left.right != null) {
                    left = left.right;
                }
                
                left.right = right;
            }
            
            tail = tail.right;
        }
        
    }
}





public void flatten(TreeNode root) {
            if(root!=null){
                flattenRoot(root);
            }
       }
      /** this methid returns the last preorder node of the root*/
      public TreeNode flattenRoot(TreeNode root){
          TreeNode last = root;
          TreeNode left = root.left, right = root.right; // grab the left and right 
          root.left = root.right = null; // reset left and right to avoid any pointer pitfalls in recursion
          if(left != null){ // check if we need to traverse left node child
              last = flattenRoot(left); // flat the left child first which will return the last child in its path
              root.right = left; // set root's right to its according to preorder
          }
          // till now we have left node flatten list and last pointer of left node 
          if(right != null){ // if right node exists 
              last.right = right; // assign last node right to current node's right as per preorder
              last = flattenRoot(right); // now assign last to last node of right preorder.
          }
          return last;
      }



Solve it using a stack and post-order-traversal , Java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public void flatten(TreeNode root) {
    TreeNode cur = root;
    TreeNode prev = null;
    while(cur != null){
        if(cur.left == null) cur = cur.right;
        else {
            prev = cur.left;
            while(prev.right != null) prev = prev.right;
            prev.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
        }
    }
}



public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        dfs(root, que);
        root = que.poll();
        while (!que.isEmpty()){
            TreeNode next = que.poll();
           // System.out.println("just popped "+ next.val);
            root.left = null;
            root.right = next;
            root = root.right;
        }
    }
    private void dfs(TreeNode root, Queue<TreeNode> que){
        if (root == null) return;
        que.offer(root);
       // System.out.println("just added "+root.val);
        dfs(root.left, que);
        dfs(root.right, que);
    }
}


public class Solution {

public void flatten(TreeNode root) {
    if(root == null){return;}
    Stack<TreeNode> stack = new Stack<>();
    dfs(root, stack);
    root = stack.pop();
    while (!stack.isEmpty()){
       root.left = null;
       root.right = stack.pop();
       root = root.right;
    }
    root.left = null;
    root.right = null;
}


public void dfs(TreeNode root, Stack<TreeNode> stack){//this is also post-order DFS, but starting from right(this gives the exact opposite order of pre-order DFS starting from left); storing it to a stack; then just pop by order and connect the popped ones by order
    if(root == null){return;}
    if(root.right != null){
        dfs(root.right, stack);
    }
    if(root.left != null){
        dfs(root.left, stack);
    }
    stack.push(root);
}

}
