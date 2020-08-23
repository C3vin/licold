class Solution {
    
    public int countComponents(int n, int[][] edges) {
        
        /** 第 1 步：製造roots數組，一共n個，總共的node數量 **/
        int[] roots = new int[n];

        /** 第 2 步：填充roots數組 **/
        for (int i = 0; i < n; i++)    roots[i] = i;

        /** 第 3 步： 按照矩陣的長度，來循環**/
        for (int i = 0; i < edges.length; i++) {

            int r1 = find(roots, edges[i][0]);  /** 找到edges「0」位置 對應的可能變異 **/

            int r2 = find(roots, edges[i][1]);  /** 找到edges「1」位置 對應的可能變異 **/

            if (r1 != r2) {     /** 如果變異不一樣，那麼把「1」位置的變異，給「0」位置 **/
                roots[r1] = r2;
                n--;            /** 模塊，減一 **/
            }
        }
        return n;
        
    }
    
    private static int find(int[] roots, int id) {

        while (roots[id] != id)  id = roots[id];

        return id;
    }
    
}