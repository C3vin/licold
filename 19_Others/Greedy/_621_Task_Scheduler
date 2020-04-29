class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        
            int[] map = new int[26];

            /** 记录每个任务的个数 **/
            for (char c: tasks) map[c - 'A']++;

            /** 排序，这时候A B C 什么的，已经不重要了 **/
            Arrays.sort(map);

            int count = 0;
 
            /** 从后往前找，任务，最后面的任务，最多  -->  只要map[25]不是空，就没排完**/
        
            while (map[25] > 0) {  /** 每一轮，排一个 n 的 session **/

                int i = 0;

                /** i和n来比较  n是cooling time **/
                while (i <= n) {

                    if (map[25] == 0) break; /** 这种情况下，没有任何任务 **/

                    if ( i < 26 && map[25 - i] > 0 )    map[25 - i]--; /**  **/

                    count++; /** 总之每一个 timeslot 就会 +1 **/

                    i++;
                }
                
                Arrays.sort(map);  /** 重新排序 **/
            }

            return count;
        }
 
}