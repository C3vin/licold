class Solution {
     
            public int[] assignBikes(int[][] workers, int[][] bikes) {

                /** 找到 workers 和 bikes的数量 */
                int n = workers.length;
                int m = bikes.length;

                /** 制造结果集 */
                int[] res = new int[n];

                /** a--> 工人是否配车了； b--> 自行车是否被占有了  */
                boolean[] a = new boolean[n];
                boolean[] b = new boolean[m];

                /** 最高距离是2000， 这里用2001是为了保险
                 *  这里存放的是每个距离集合，所代表的 worker-bike 距离
                 * */
                List<int[] /** 存放的是，距离集合 */>[] list = new List[2001];

                /** 遍历所有的人，和车，然后算出distance */
                for (int i = 0; i < n; i++) {  // 工人

                    for (int j = 0; j < m; j++) {  // 车 

                        int dist = dist(workers[i], bikes[j]);

                        /** 如果这个距离的点，是空的，就初始化一个空 ArrayList */
                        if (list[dist] == null) {
                            list[dist] = new ArrayList<>();
                        }

                        /** 然后加入这个点 --> i,j  */
                        list[dist].add(new int[]{i, j});
                    }
                }

                /** 检查距离仓库 */
                for (int i = 0; i < 2001; i++) {

                    if (list[i] == null) continue;

                    /** 拿到距离 */
                    int size = list[i].size();

                    /** 遍历这个距离，存在的pair */
                    for (int k = 0; k < size; k++) {

                        int worker_H = list[i].get(k)[0];
                        int biker_H = list[i].get(k)[1];

                        if(!a[worker_H] /** 没被assign */  && !b[biker_H] /** 没有分配 */) {

                            /** 进行分配 */
                            res[worker_H] = biker_H;

                            a[worker_H] = true;
                            b[biker_H] = true;

                            /** 这里，a代表工人分配情况数组，b代表自行车分配情况数组 */

                        }
                    }
                }

                return res;
            }

            private int dist ( int[] w, int[] b){
                return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
            }
 
}