public class Solution {
 
        private int[][] jumps;
        private boolean[] visited;

        public int numberOfPatterns(int m, int n) {
            
            jumps = new int[10][10];
            
            jumps[1][3] = jumps[3][1] = 2;

            jumps[7][9] = jumps[9][7] = 8;
            jumps[1][7] = jumps[7][1] = 4;
            
            jumps[2][8] = jumps[8][2] = jumps[1][9] = jumps[9][1] = jumps[4][6] = jumps[6][4] = jumps[3][7] = jumps[7][3] = 5;
            
            jumps[9][3] = jumps[3][9] = 6;
      
            visited = new boolean[10];
            
            int count = 0;
            
            count += dfs(1, 1, 0, m, n)
                * 4;//1,3,7,9 are symmetric, so we only need to use 1 to do it once and then multiply the result by 4
            count += dfs(2, 1, 0, m, n)
                * 4;//2,4,6,8 are symmetric, so we only need to use 1 to do it once and then multiply the result by 4
            count += dfs(5, 1, 0, m, n);
            
            return count;
        }

        /** Backtracking **/
        private int dfs(int num, int len, int count, int m, int n) {

                if (len >= m) {
                    count++;
                }

                len++;

                if (len > n) {
                    return count;
                }

                visited[num] = true;
 
                /** scan every posibilities */
                for (int next = 1; next <= 9; next++) {

                    int jump = jumps[num][next];  // num是当前的点，next是下一个点
                    
                    /* 这里敲重点!!  比如，从3跳到8 ，斜着跳，是可以的！！！！，从3到8，没有有穿过任何数！！！*/
  
                    if (!visited[next] && (jump == 0 || visited[jump])) {
                         
                        /* 1. 下一个点，没有被访问过
                           2. 没有中间穿过的点，就算有，这个中间点必须是被访问过的
                        */  

                        count = dfs(next, len, count, m, n);
                    }
                }
 
                visited[num] = false;//backtracking
                
                return count;
        }   
}
