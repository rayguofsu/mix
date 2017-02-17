94. Binary Tree Inorder Traversal
Total Accepted: 109964 Total Submissions: 284079 Difficulty: Medium

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

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
Explanation

The basic idea is referred from here: using stack to simulate the recursion procedure: for each node, travel to its left child until it's left leaf, then pop to left leaf's higher level node A, and switch to A's right branch. Keep the above steps until cur is null and stack is empty. As the following:

Runtime = O(n): As each node is visited once

Space = O(n)

public List<Integer> inorderTraversal(TreeNode root) {//better but similar solution to mine ; remember it
    List<Integer> res = new LinkedList<Integer>();
    if (root == null) return res;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) { 
        while (cur != null) {// Travel to the left leaf
            stack.push(cur);
            cur = cur.left;             
        }        
        cur = stack.pop(); // Backtracking to higher level node A
        res.add(cur.val);  // Add the node to the result list
        cur = cur.right;   // Switch to A'right branch
    }
    return res;
}



/*public class Solution {//in order: left; current; right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null){
            if (root.left != null){
                stack.push(root); //push to record only when it has left; and in-order is left, current, right
                root = root.left;
            }
            else{//left == null here
                list.add(root.val);
                //below is to assign root to right node either lower(child) right or upper(parent record) right then restart the previous while loop
                while(root.right == null){
                    if (stack.isEmpty()) return list;
                    root = stack.pop();//pop up parent node
                    list.add(root.val); //visit parent node
                }
                root = root.right; //goes to right when has right and re-start while loop
            }
        }
        return list;
    }
}
*/
