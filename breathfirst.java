Breadth first Tranverse is a queue, depth first is a stack.

For breadth first, add all children to the queue, then pull the head and do a breadth first search on it, using the same queue.

For depth first, add all children to the stack, then pop and do a depth first on that node, using the same stack.

Queue<TreeNode> queue = new LinkedList<BinaryTree.TreeNode>() ;
public void breadthTranverse(TreeNode root) {
    if (root == null)
        return;
    queue.clear();
    queue.add(root);
    while(!queue.isEmpty()){
        TreeNode node = queue.remove();
        System.out.print(node.element + " ");
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
    }

}
