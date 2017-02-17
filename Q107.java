//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//return its bottom-up level order traversal as:
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //difference between list, array, arraylist, Set<Integer>, HashSet<Integer>
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if (root == null) return result;

      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.add(root);
      //breadth first search 
      while (!q.isEmpty()){
         List<Integer> list = new ArrayList<Integer>();
         int size = q.size();
         //one for loop for each level
         for (int i = 0; i < size; i++){
           TreeNode n = q.poll();
           list.add(n.val);
           //adding children for next level and next while iteration
           if (n.left != null) q.add(n.left);
           if (n.right != null) q.add(n.right);
         }
         //for arraylist or array, index 0 is at the top
         result.add(0, list);
       }
      return result;
    }









//    List<List<Integer>> result = new ArrayList<List<Integer>>();
//    if(root==null) return result;
//    Queue<TreeNode> q = new LinkedList<>();
//    q.add(root);
//    while(q.size()>0){
//        List<Integer> list = new ArrayList<>();
//        int size = q.size();
//        for(int i=0; i<size; i++){
//            TreeNode node = q.poll();
//            list.add(node.val);
//            if(node.left!=null) q.add(node.left);
//            if(node.right!=null) q.add(node.right);
//        }
//        result.add(0,list);
//    }
//    return result;

}
