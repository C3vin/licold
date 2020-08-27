class Solution {

        // same as LeetCode 785. Is Graph Bipartite?
    
        ArrayList<Integer>[] graph;

        Map<Integer, Integer> color;

        public boolean possibleBipartition(int N, int[][] dislikes) {

            graph = new ArrayList[N+1];

            for (int i = 1; i <= N; ++i) graph[i] = new ArrayList();  /** 把 graph 填滿成 ArrayList()**/

            for (int[] edge: dislikes) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            color = new HashMap(); // 染色法

            // 遍历每一个node
            for (int node = 1; node <= N; ++node){
                
                 if (!color.containsKey(node) && !dfs(node, 777 /*任意值，代表颜色*/))  return false;
            }
            
            return true;
        }

        public boolean dfs(int node, int c) {

            if (color.containsKey(node)) return color.get(node) == c;

            color.put(node, c);

            for (int nei: graph[node])
                if (!dfs(nei, c ^ 1))
                    return false;
            
            return true;
        }
}

/**
* Algorithm:  https://youtu.be/VlZiMD7Iby4?t=131
*
* **/