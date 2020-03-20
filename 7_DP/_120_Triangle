class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
       
            // 制造动态规划array
            int[] A = new int[triangle.size() + 1 ];

            // 从层数开始找,从下往上
            for (int i = triangle.size() - 1; i >= 0; i--) {
    
                // 在层数里面找
                for (int j = 0; j < triangle.get(i).size(); j++) {

                      // 该元素的值
                      int pre = triangle.get(i).get(j); 
                     
                      // 拿DP的值 
                      A[j] = Math.min(A[j], A[j + 1]) + pre;
                }

            }

            /**
             *          [2],
             *         [3,4],
             *        [6,5,7],
             *       [4,1,8,3]
             *
             *
             *       [0 0 0 0 0]
             * **/


            return A[0];
        
    }
    
}