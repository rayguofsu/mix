// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (root != null){
            if (root.val <= max && min <= root.val){
                return root;
            }
            else if (root.val > max){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return  null;
    }

//this is similar to 4-7, but quite simple than it, as 4-7 is not BST; only BT
public class Q235{
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;
        TreeNode small = null;
        TreeNode large = null;
        if (q.val > p.val){
           large = q;
           small = p;
        }
        else{
           small = q;
           large = p;
        }
        //this is abostultely right; as we go down from the top; 
        //by this order from top -> down; we must have already visited common ances
       //
        while (root != null){
           //this is the condition where we meet the common ances
           //as it tells small on root's left and large is on root's right
           //so root must be the common ances
           if (small.val <= root.val && root.val <= large.val){
               return root;
           } 
          //if root is not common, then either both on left or both on right
           if (root.val > large.val){  //go left
               root = root.left;
           }
           else if (root.val < small.val){ //go right
               root = root.right;
           }
        }
        return null; //if root == null or the tree does not cover both p & q;
    }

    public static void main(String[] args){
       TreeNode a = new TreeNode(5);
       TreeNode b = new TreeNode(2);
       TreeNode c = new TreeNode(6);
       a.left = b;
       a.right = c;
       TreeNode dd =  lowestCommonAncestor(a, b, c);
       System.out.println(dd.val);
    }
}
