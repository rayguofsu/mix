297. Serialize and Deserialize Binary Tree
Total Accepted: 9161 Total Submissions: 35946 Difficulty: Medium

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

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
    Here I use typical BFS method to handle a binary tree. I use string n to represent null values. The string of the binary tree in the example will be "1 2 3 n n 4 5 n n n n ".

When deserialize the string, I assign left and right child for each not-null node, and add the not-null children to the queue, waiting to be handled later.

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
    
    
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder str = new StringBuilder();
        queue.offer(root);
        int length = 0;
        while (!queue.isEmpty()){
           TreeNode tmp = queue.poll();
           if (tmp == "null"){
              str.append("null,");
           }
           else{
              str.append(tmp.value + ",");
              //only at here we just update the actual length we want
              length = str.length;
              queue.offer(tmp.left);
              queue.offer(tmp.right);
           }
        }
        str.delete(length, str.length - 1); //delete last "," also the trailing "null" strings
        System.out.println("String is " + str.toString());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length == 0 || data == "null") return null;
        String[] nodes = data.split(',');
        TreeNode root = deserHelper(nodes, 0, 0, false);
    }
    private TreeNode deserHelper(String[] nodes, int level, int index, boolean leftNode){
        TreeNode root = new TreeNode();
        if (level == 0) root.val = Integer.parseInt(nodes[0]);
        else{
           int first = 2 << (level -1) -1; //here is index in String[] for first element on this level
           int pos;
           if (leftNode) pos = first + index;
           else pos = first + index + 1;
           String tmp = nodes[pos];
           if (tmp == "null") root = null;
           else root.val = Integer.parseInt(tmp);
        }
        if (root != null){
           int newIndex = 2 * index;
           root.left = deserHelper(nodes, level + 1, newIndex, true);
           root.right = deserHelper(nodes, level + 1, newIndex + 1, false);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
