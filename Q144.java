144. Binary Tree Preorder Traversal
Total Accepted: 107628 Total Submissions: 276940 Difficulty: Medium

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()){
            if (root == null) root = stack.pop();
            res.add(root.val);
            if (root.right != null) stack.push(root.right);
            root = root.left;
        }
        return res;
    }
}



public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //first just draw the pre-order tree tranvertial graph,as preorder sequence is root, left, right
        //then the idea is to use while loop; since pre-order, just add root.val to list first
        //then goes down to child node, left child has higher priority; when no child node, then pull from record and go its right (just like the pre-order tranvertial graph)
        //record only contains node which has both left and child
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>(); //use to save parent node
        while (root != null){
            result.add(root.val);
            if (root.right != null && root.left != null){
                stack.push(root);  //push node to stack only if stack has both left and right
            }
            root = root.left == null ? root.right : root.left;  //update node: goes to child node, left has higher priority
            if (root == null){
                if (stack.isEmpty()){
                    return result;
                }
                else{
                    root = stack.pop().right;  //this is key: after node updated, if it is null, then it means last visited node has
                    //no left or right, therefore need to pop from record; and goes right, pre-order tranversial is just like this
                }
            }
        }
        return result;
    }
    /*    List<Integer> result = new ArrayList<Integer>();
        //Trivial Recursion Solution T: O(n) Space: O(log(base2) n)
        preOrderRecursion(root, result);
        return result;
    }
    
    private void preOrderRecursion(TreeNode root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        preOrderRecursion(root.left, list);
        preOrderRecursion(root.right, list);
    }*/
}
