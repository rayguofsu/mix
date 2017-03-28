     boolean  same (TreeNode root, TreeNode sroot){
    	 
    	 if(root==null)
    		  return false;
    	 if(root.val==sroot.val)
    		return compare(root,sroot);
    	 
		return same(root.left,sroot) || same(root.right,sroot);
    	 
    	 
     }

private boolean compare(TreeNode root, TreeNode sroot) {
		// TODO Auto-generated method stub
	       if(root==null && sroot==null)
	    	    return true;
	       
	       if(root==null || sroot==null)
	    	    return false;
	       
		if(root.val==sroot.val)
			return  compare(root.left, sroot.left) && compare(root.right, sroot.right);
		else
			 return false;
	}
