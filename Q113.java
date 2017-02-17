// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//For example:
//Given the below binary tree and sum = 22,
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//return
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {













        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfsPre(root, sum, res, list);
        return res;
    }
    private void dfsPre(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list){
        if (root == null) return;
        int remainSum = sum - root.val;
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);
        if (remainSum == 0 && root.left == null && root.right == null){
            res.add(newList);
            return;
        }
        dfsPre(root.left, remainSum, res, newList);
        dfsPre(root.right, remainSum, res, newList);
        
    }
}




public class Solution {//similar to Q112; easy one
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfsPre(root, 0, sum, result, list);
        return result;
    }

    private void dfsPre(TreeNode root, int endSum, int sum, List<List<Integer>> result, List<Integer> list){
        if (root == null) return;
        List<Integer> newList = new ArrayList<Integer>(list); //shallow copy
        endSum += root.val;
        newList.add(root.val);
        if (endSum == sum && root.left == null && root.right == null){
           result.add(newList);
        }
        dfsPre(root.left, endSum, sum, result, newList);
        dfsPre(root.right, endSum, sum, result, newList);
    }
}
