import java.util.PriorityQueue;

public class _1102_Path_With_Maximum_Minimum_Value {

    public static void main(String[] args) {

        Solution_1 solution_1 = new Solution_1();

        int[][] a = new int[][]{   {3,4,6,3,4},
                                   {0,2,1,1,7},
                                   {8,8,3,2,7},
                                   {3,2,4,9,8},
                                   {4,1,2,0,0},
                                   {4,6,5,4,3}
                               };

        System.out.println(solution_1.maximumMinimumPath(a));

    }

    /** BFS  这题要看讲解才行： https://youtu.be/mMm0KfZpsg8?t=74 */
    public static class Solution_1 {

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




}
