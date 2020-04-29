class Solution {
    
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        
        helper(result, new ArrayList<Integer>(), n, 2);
        
        return result;

    }

    /* 内核 */                          /* 总答案 */         /* 子答案 */ /*剩余值*/  /*起始位置*/
    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){

        /* 边界条件 */
        if (n <= 1) {
                        if (item.size() > 1) {
                                                 result.add(new ArrayList<Integer>(item));
                        }
            
                        return;
        }

        /* 真内核 - 从2开始都试一下，看能否整除 */
        for (int i = start; i <= n; ++i) {
            
            if (n % i == 0) {
                
                item.add(i);
                                      /* 用新的item集 */       /* 更新n */         /*更新i*/
                helper(result,             item,                n/i,              i     );
                
                
                item.remove(item.size()-1); /* backtracking */
                 
            }
        }
    }

}
