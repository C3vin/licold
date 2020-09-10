public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            
            StringBuilder sb = new StringBuilder();
            
            dfs(root, sb);

            return sb.toString();
        }
    
        // pre-order
        private void dfs(TreeNode root, StringBuilder sb) {
            
            if (root == null) return;
             
            sb.append(root.val + ",");
            
            dfs(root.left, sb);    dfs(root.right, sb);
            
            return;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
         
            String[] arr = data.split(",");
            
            TreeNode root; 
            
            if( arr[0].equals("") ) {
                
                 root = null; 
                
            } else {
            
                    root = new TreeNode( Integer.parseInt( arr[0] ) );

                    for (int i = 1; i< arr.length; i++) {

                            root = buildBST(  root, Integer.parseInt( arr[i] )  );     
                    }
            }
           
            return root;
        }
 
        public TreeNode buildBST(TreeNode root, int v) {
            
            if (root == null) return new TreeNode(v);
            
            if (v < root.val) {
                root.left = buildBST(root.left, v);
            } else {
                root.right = buildBST(root.right, v);
            }
            return root;
        }
}