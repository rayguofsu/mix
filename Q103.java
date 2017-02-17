Binary Tree Zigzag Level Order Traversal
Total Accepted: 56185 Total Submissions: 199229 Difficulty: Medium

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

















        //idea is to use two stack; stackLeft is pushed in val left first;
        //stackRight pop and pushed to stackLeft; and stackLeft pop and pushed to stackRight;
        //therefore zigzag behavior achieved
        Stack<TreeNode> stackLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackRight = new Stack<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        stackRight.push(root);
        while (!stackLeft.isEmpty() || !stackRight.isEmpty()){
            List<Integer> listR = new ArrayList<>;
            List<Integer> listL = new ArrayList<>();
            int sizeR = stackRight.size();
            for (int i = 0; i < sizeR; i++){
            //for (int i = 0; i < stackRight.size(); i++){
                TreeNode n = stackRight.pop();
                listR.add(n.val);
                if (n.left!= null) stackLeft.push(n.left);
                if (n.right != null) stackLeft.push(n.right);
            }
            int sizeL = stackLeft.size();
            for (int i = 0; i < sizeL; i++){
            //for (int i = 0; i < stackLeft.size(); i++){ //wrong when pop size will change, stupid
                TreeNode n = stackLeft.pop();
                listL.add(n.val);
                if (n.right != null) stackRight.push(n.right);
                if (n.left != null) stackRight.push(n.left);
            }
            if (listR.size() > 0) res.add(listR);
            if (listL.size() > 0) res.add(listL);
        }
        return res;
    }
}
