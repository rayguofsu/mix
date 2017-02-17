/*199. Binary Tree Right Side View
Total Accepted: 34561 Total Submissions: 104944 Difficulty: Medium

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while (!que.isEmpty()){
            int count = que.size();
            TreeNode node = null;
            while (count > 0){
                node = que.poll();
                count--;
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
            }
            if (node != null){
                res.add(node.val);
            }
        }
        return res;
    }
}



public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list; //cannot return null, it seems
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        rightSideR(q, list, 1);
        return list;
    }
    private void rightSideR(Queue<TreeNode> q, List<Integer> list, int count){
        //the idea is to use q for BFS (level order); then use an counter to know how many elements in the next level, then when popping q reaches the counter, add it to list
        int newCount = 0;
        if (q.isEmpty()) return;
        TreeNode r = null;
        while (count > 0){
            r = q.remove();
            count--;
            if (r.left != null){
                q.add(r.left);
                newCount++;
            }
            if (r.right != null){
                q.add(r.right);
                newCount++;
            }
        }
        if (r != null) list.add(r.val);
        rightSideR(q, list, newCount);
    }
}
