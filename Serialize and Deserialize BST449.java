Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. 



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.toString();
    }
    private void serialHelper(TreeNode root, StringBuilder sb){
        if (root == null) return;
        sb.append(root.val).append(" ");
        serialHelper(root.left, sb);
        serialHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        TreeNode dummy = new TreeNode(0);
        String[] strs = data.split(" ");
        deserHelper(strs, 0, true, dummy, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return dummy.left;
    }
    private int deserHelper(String[] strs, int pos, boolean leftNode, TreeNode par, int low, int hi){
        if (pos >= strs.length) return pos;  //irrelivent, cannot return < len; as it will keep looping
      //  System.out.println("strs pos is " + strs[pos] + " pos is " + pos);
        int val = Integer.valueOf(strs[pos]);
        if (val < low || val > hi) return pos - 1;
        TreeNode cur = new TreeNode(val);
        if (leftNode) par.left = cur;
        else par.right = cur;
       // System.out.println("pos1 is " + pos);
        pos = deserHelper(strs, pos + 1, true, cur, low, val);
       // System.out.println("pos2 is " + pos);
        pos = deserHelper(strs, pos + 1, false, cur, val, hi);
        return pos;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
