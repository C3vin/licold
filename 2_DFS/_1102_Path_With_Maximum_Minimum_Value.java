class Solution {
 
            /** 找出4个方向 */
            int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

            /** 主函数 */
            public int maximumMinimumPath(int[][] A) {

                        /** 1. 找出input的size */
                        int m = A.length;
                        int n = A[0].length;

                        /** 2. 制定PriorityQueue，总是拿出最大的 */
                        PriorityQueue<int []> maxHeap = new PriorityQueue<int []>((a, b) -> b[2] - a[2]);

                        /** 3. 制造max heap */
                        maxHeap.add(new int[]{0, 0, A[0][0]});

                        /** 4. 制造访问历史 */
                        boolean [][] visited = new boolean[m][n];

                        /** 5. 第一步总是被访问 */
                        visited[0][0] = true;

                        /** 6. 初始化 result */
                        int res = A[0][0];

                        /** 7. BFS */
                        while(!maxHeap.isEmpty()){

                                    /** 7.1 拿出最大元素 */
                                    int [] cur = maxHeap.poll();

                                    /** 7.2 更新最小的元素 */
                                    res = Math.min(res, cur[2]);

                                    /** 7.3 假如到达终点 */
                                    if( cur[0]==m-1 && cur[1]==n-1 ) return res;

                                    /** 7.4 四个方向循环 */
                                    for(int [] dir : dirs){

                                            int x = cur[0] + dir[0];
                                            int y = cur[1] + dir[1];

                                            if(x<0 || x>=m ||y<0 || y>=n || visited[x][y]) continue;

                                            visited[x][y] = true;

                                            maxHeap.add(new int[]{x, y, A[x][y]});

                                    }

                    }

                    return res;

            }
}