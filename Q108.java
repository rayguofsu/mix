Convert Sorted Array to Binary Search Tree
Total Accepted: 59204 Total Submissions: 168476 Difficulty: Medium

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution { //very similar to cc150 Q, as I remembered
    //is Run Time and space both O(n) where n is the length of nums??
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedToBSTR(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode sortedToBSTR(int[] nums, int start, int end){
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedToBSTR(nums, start, middle - 1);
        root.right = sortedToBSTR(nums, middle + 1, end);
        return root;
    }
}
