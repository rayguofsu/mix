/*101. Symmetric Tree
Total Accepted: 93531 Total Submissions: 281402 Difficulty: Easy

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5

The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
*/

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
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return fun(root.left, root.right);
}

public boolean fun(TreeNode l, TreeNode r) {//O(log n) for space if balenced BT; and O(n) for run time?
    if (l == null && r == null) {
        return true;
    }
    if (l == null || r == null) {
        return false;
    }
    if(l.val != r.val){
        return false;
    }else{  //this is exactly for binary tree; as 1->2; then for next time 2 becomes 4
        return fun(l.left, r.right) && fun(l.right, r.left);
    }
}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*public class Solution {
//iterative
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return symmetricIterative(root.left, root.right);
}

private boolean nodeMatch(TreeNode left, TreeNode right){
   if (left == null && right == null) return true;
   if (left == null || right == null) return false;
   return left.val == right.val;
}

private boolean symmetricIterative(TreeNode left, TreeNode right){
   Queue<TreeNode> que = new LinkedList<>();
   que.offer(left);
   que.offer(right);
   while(!que.isEmpty()){
       left = que.poll();
       right = que.poll();
       if (nodeMatch(left, right) == false) return false;
       if (left != null){ //no need to check on right; as if right == null, it will return false by above line already
          que.offer(left.left);
          que.offer(right.right);
          que.offer(left.right);
          que.offer(right.left);
       }
   }
   return true;
}

}
*/

