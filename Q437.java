437. Path Sum III


You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        pathSumR(root, map, 0, sum);
        return countGlobal;
    }
    int countGlobal = 0;
    private void pathSumR(TreeNode root, Map<Integer, Integer> map, int sum, int target){
        if (root == null) return;
        sum += root.val;
        if (map.containsKey(sum - target)){
            countGlobal += map.get(sum-target);
        }
        if (map.containsKey(sum)){
            map.put(sum, map.get(sum)+1);
        }
        else map.put(sum, 1);
        pathSumR(root.left, map, sum, target);
        pathSumR(root.right, map, sum, target);
        map.put(sum, map.get(sum)-1);
    }
}
