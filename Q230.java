230. Kth Smallest Element in a BST
Total Accepted: 36253 Total Submissions: 100804 Difficulty: Medium

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

    Try to utilize the property of a BST.
    What if you could modify the BST node's structure?
    The optimal runtime complexity is O(height of BST).
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
        //for follow up
        search(root, k){
        k--;
        if (k == 0){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
        if (root.leftNum > k){
            search(root.left, k);
        }
        else if (root.leftNum < k){
            search(root.right, k - root.leftNum - 1);
        }
        else{
            return root;
        }
    
    //for follow up insert:
        insert(TreeNode parents(initially is just root, ok if k valid), TreeNode root, boolean leftN, boolean righN, int val){
            if (root == null){
                if (leftN) parents.left = new TreeNode(val);
                if (rightN) parents.right = new TreeNode(val);
                return;
            }
            if (root.val > val) insert(root, root.left, val, true, false);
            if (root.val < val) insert(root, root.right, val, false, true);
        }
public class Solution {
    //this is trivial solution O(n)
    //for follow up, it is similar to cc150 chapter 11 Q
    //change the treeNode structure, to add the leftNum value as part of structure, which keeps the num of left childs when insert/delete
    //then when searching for kth smallest, just first k-- and compare it with the root, if root.leftNum < k, then go right, if root.leftNum > k; then go left, if root.leftNum == k, stop and return root;
    //see above code.
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        kthRecursion(root, tmp);
        return tmp.get(k - 1);
        
    }
    public void kthRecursion(TreeNode root, ArrayList<Integer> tmp){
        if (root==null) return;
        kthRecursion(root.left, tmp);
        tmp.add(root.val);
        kthRecursion(root.right, tmp);
    }
}
