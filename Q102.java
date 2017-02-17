102. Binary Tree Level Order Traversal
Total Accepted: 99633 Total Submissions: 305692 Difficulty: Easy

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
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
    //this is exactly code from the other level - orer tranverse except one line different
    public List<List<Integer>> levelOrder(TreeNode root) {










        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //for level order tranverse, it is just one Queue + one while loop
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return result;
        q.add(root);
        
        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
            }  //for the other similar level order tranverse it is add(0, list), to put lower level on top
            //here is to put higher on top
            result.add(list);
        }
        return result;
    }
}
