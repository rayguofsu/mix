257. Binary Tree Paths
Total Accepted: 34780 Total Submissions: 128904 Difficulty: Easy

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

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
    public List<String> binaryTreePaths(TreeNode root) {
     //fuck man, I just came to know that String is not passed by reference
     //see the explained here:
     // http://www.programcreek.com/2013/09/string-is-passed-by-reference-in-java/

     //the idea is to use pre-order DFS
     ArrayList<String> result = new ArrayList<String>();//note: can pass arraylist<string> directly to list<string>
     String s = "";  //empty string intially
     DFS(root, s, result);
     return result;
    }
    
    public void DFS(TreeNode root, String s , ArrayList<String> result){
        if (root == null) return;
        if (root.left == null && root.right == null){ //here reaches leaf cell
            result.add(s + root.val); //this is OK, although root.val is not string
            return;
        }
        DFS(root.left, s + root.val + "->", result); //since string is not passed by reference; we can make sure left and right get the same
        DFS(root.right, s + root.val + "->", result); //and will not be affected if earlier recursion modifies string s//
    }
}
