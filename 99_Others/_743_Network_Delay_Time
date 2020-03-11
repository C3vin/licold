/** Dijkstra's Algorithm **/
class Solution {
  
        Map<Integer, Integer> dist;

        public int networkDelayTime(int[][] times, int N, int K) {

            Map<Integer, List<int[]>> graph = new HashMap();

            for (int[] edge: times) {

                if (!graph.containsKey(edge[0]))   graph.put(edge[0], new ArrayList<int[]>());

                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }

            /** 初始化 dist  **/
            dist = new HashMap();

            for (int node = 1; node <= N; ++node)  dist.put(node, Integer.MAX_VALUE);  /** 從1開始  **/

            /** 從K開始  **/
            dist.put(K, 0);

            boolean[] visited = new boolean[N+1];  /** 從1開始  **/

            /** Dijkstra **/
            while (true) {

                    int kNode = -1;   /** kNode的重置  **/

                    int cDist = Integer.MAX_VALUE;

                    for (int i = 1; i <= N; ++i) {

                        /** 一開始，只有K元素可以進入  **/
                        if (!visited[i] && dist.get(i) < cDist) {

                            /** 拿到最小dist的路  **/
                            cDist = dist.get(i);

                            kNode = i;
                        }
                    }

                    if (kNode < 0) break;

                    visited[kNode] = true;

                    if (graph.containsKey(kNode)){

                        for (int[] info: graph.get(kNode)) {

                            dist.put(   info[0], Math.min(   dist.get(info[0]), (dist.get(kNode) + info[1])  )    );
                        }
                    }
            }

            int ans = 0;

            for (int cand: dist.values()) {

                if (cand == Integer.MAX_VALUE) return -1;

                ans = Math.max(ans, cand);
            }

            return ans;
        }  
}
