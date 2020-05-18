class Solution {
    
    public TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.right); // last prev == root.right
        
        flatten(root.left);  // go deep into the most right

        root.right = prev;
        root.left = null;

        prev = root;
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


