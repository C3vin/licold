class Solution {
    
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList();
        
 //     List<String> ans = new LinkedList();  
        
        /* 开始作战 */
        backtrack(ans, "", 0, 0, n);
        
        return ans;
        
    }

    public void backtrack(List<String> ans, String cur, int left, int right, int n){
        
        /* 如果right括号满了， */
        if (right == n) {
            ans.add(cur);
            return;
        }

        if (left < n) backtrack(ans, cur+"(", left+1, right, n);
        
        if (right < left) backtrack(ans, cur+")", left, right+1, n);
        
    }
}
