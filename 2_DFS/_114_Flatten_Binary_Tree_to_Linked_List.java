class Solution {
    
    public void flatten(TreeNode root) {
        
        flatten(root,null);
        
    }
    
    private TreeNode flatten(TreeNode root, TreeNode curr) {
        
        if(root==null) return curr;
        
        curr = flatten(root.right,curr);    
        
        curr = flatten(root.left,curr);
        
        root.right=curr;
        
        root.left = null;
        
        curr = root;
        
        return curr;
    }
    
}

/**
   Explain the question meaning: https://youtu.be/NHdrzNpt1ZI?t=131

		1
	   / \
	  2   5
	 / \   \
	3   4   6
	-----------        
	pre = 5
	cur = 4

		1
	   / 
	  2   
	 / \   
	3   4
		 \
		  5
		   \
			6
	-----------        
	pre = 4
	cur = 3

		1
	   / 
	  2   
	 /   
	3 
	 \
	  4
	   \
		5
		 \
		  6
	-----------        
	cur = 2
	pre = 3

		1
	   / 
	  2   
	   \
		3 
		 \
		  4
		   \
			5
			 \
			  6
	-----------        
	cur = 1
	pre = 2

	1
	 \
	  2
	   \
		3
		 \
		  4
		   \
			5
			 \
			  6


**/


