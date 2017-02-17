236. Lowest Common Ancestor of a Binary Tree
Total Accepted: 34047 Total Submissions: 119131 Difficulty: Medium

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//This algorithm runs in O(n) time on a balanced tree.This is because covers is called on
//2n nodes in the first call (n nodes for the left side, and n nodes for the right side). After
//that, the algorithm branches left or right, at which point covers will be called on 2n/2
//nodes, then 2n/4, and so on.This results in a runtime of 0(n).
//CrackingTheCodinglnterview.com 231
//Solutions to Chapter 4 | Trees and Graphs
//We know at this point that we cannot do better than that in terms of the asymptotic
//runtime since we need to potentially look at every node in the tree. However, we may
//be able to improve it by a constant multiple.

//public class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //cc150 original; use solution 2 O(n)//why so slow at run time?
//        if (!covers(root, p) || !covers(root, q)) return null;
//        return lowestR(root, p, q);
//    }
//    private TreeNode lowestR(TreeNode root, TreeNode p, TreeNode q){
//        if (root == null || root == p || root == q) return root;
//        boolean coverP = covers(root.left, p);
//        boolean coverQ = covers(root.left, q);
//        if (coverP != coverQ){
//            return root;
//        }
//        TreeNode node = coverP ? root.left : root.right;
//        return lowestR(node, p, q);
//    }
//    private boolean covers(TreeNode root, TreeNode p){
//        if (root == null) return false;
//        if (p == root) return true;
//        return covers(root.left, p) || covers(root.right, p);
//    }
//}



//java Solution: Comparing the root to p and q at each iteration
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//best solution
//this is under the assumption that p and q both under this tree
//if one is under, the other is not under; then the one under this tree will be the result
//if going over an example, you will see clear what the code does; it is not pre/post/in DFS
//as DFS not only has pre/post/in.
//the code below will have the found p and q bubble up during the recursion
    if(root==null || root==p || root==q)
        return root;
    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);
    if(left!=null && right!=null) //here it means p and q are both found at left and right repectively.
        return root;              //so return root here
    return (left==null)?right:left;
}


//LeetCode – Lowest Common Ancestor of a Binary Search Tree (Java)
// 
//
//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//Analysis
//
//This problem can be solved by using BST property, i.e., left < parent < right for each node. There are 3 cases to handle. Java Solution
//
//public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//    TreeNode m = root;
// 
//    if(m.val > p.val && m.val < q.val){
//        return m;  
//    }else if(m.val>p.val && m.val > q.val){
//        return lowestCommonAncestor(root.left, p, q);
//    }else if(m.val<p.val && m.val < q.val){
//        return lowestCommonAncestor(root.right, p, q);
//    }
// 
//    return root;
//}
