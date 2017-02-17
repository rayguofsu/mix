/*331. Verify Preorder Serialization of a Binary Tree
Total Accepted: 1161 Total Submissions: 3535 Difficulty: Medium

One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
*/

//Solution. I came up with the first solution naturally by using recursion. The idea is that if current is ‘#’, we simply return true. If current is a number, call validHelper 2 times with pos++. In the end, return true if pos == list.length – 1.
public class Solution {
    public boolean isValidSerialization(String preorder){//nice trick: return both boolean and single integer via int[];

       if (preorder == null || preorder.length() == 0) return false;
       String[] str = preorder.split(",");
       int[] index = new int[]{-1};
       boolean valid =  simulatePre(str, index);
       if (!valid || index[0] != str.length - 1) return false;// in the end, pos[0] should equal len - 1
       return true;                                           //otherwise cannot handle 1, #, #, 1 case
    }
    private boolean simulatePre(String[] str, int[] indx){//this is exactly like pre-roder transversal
       indx[0]++;
       if (indx[0] >= str.length) return false;
       if (str[indx[0]].equals("#")) return true; //very importance, cannot use == here
       // if is a number, call 2 times.
       return simulatePre(str, indx) && simulatePre(str, indx);
    }
}









