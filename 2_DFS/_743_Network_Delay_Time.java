/** Dijkstra's Algorithm **/
class Solution {
 
        Map<Integer, Integer> dist;

        public int networkDelayTime(int[][] times, int N, int K) {

            /** 制造 graph -->  數字 **/
            Map<Integer, List<int[]>> graph = new HashMap();

            for (int[] edge: times) {

                /** 如果graph不存在結點，就在graph插入hashmap信息  **/
                if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<int[]>());

                /** 權重*/
                graph.get(edge[0]).add(new int[]{edge[2], edge[1]}); /** 算出那條路徑最短  **/
            }

            /** 遍歷 graph 的 node  **/
            for (int node: graph.keySet()) {
                Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
            }

            dist = new HashMap();

            /** 初始化 dist  **/
            for (int node = 1; node <= N; ++node)  dist.put(node, Integer.MAX_VALUE);

            /** 遍歷每個節點 **/
            dfs(graph, K, 0);

            int ans = 0;

            /** 找到 dist 的最大值 **/
            for (int cand: dist.values()) {

                if (cand == Integer.MAX_VALUE) return -1;

                ans = Math.max(ans, cand);
            }
            return ans;
        }

        /** 消耗時間 **/
        public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {

            /** 如果大於原先的時間 **/
            if (elapsed >= dist.get(node)) return;

            dist.put(node, elapsed);
            /** Node **/              /** 消耗時間 **/
            if (graph.containsKey(node))   for (int[] info: graph.get(node))   dfs(graph, info[1], elapsed + info[0]);
        }
    
 
}