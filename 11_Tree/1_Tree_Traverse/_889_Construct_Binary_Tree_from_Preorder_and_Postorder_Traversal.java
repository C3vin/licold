class Solution {
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < post.length; i++){
            map.put(post[i], i);
        }
        
        return dfs(pre, 0, pre.length - 1, 
                   post, 0, post.length - 1, 
                   map);
    }
    
    private TreeNode dfs(int[] pre,  int preStart, int preEnd, 
                         int[] post, int postStart, int postEnd, 
                         Map<Integer, Integer> map)
    {
        
        if (preStart > preEnd || postStart > postEnd) return null;
         
        TreeNode root = new TreeNode(pre[preStart]);
        
        if (preStart == preEnd ) return root;
     
        /*  pre = [1,           2,4,5,3,6,7] 
            post = [4,5,2,6,7,3,           1]
        */
         
        int deltaIndex = map.get( pre[ preStart+1 ] ) - postStart;

        root.left = dfs(pre, preStart + 1, preStart + 1 + deltaIndex, 
                        post, postStart, postStart + deltaIndex, 
                        map);

        root.right = dfs(pre,  preStart + 1 + deltaIndex + 1, preEnd, 
                         post, postStart + deltaIndex + 1, postEnd - 1, 
                         map);
         
        return root;
    }
}