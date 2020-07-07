class Solution {
     
    public boolean isBipartite(int[][] graph) {
        
        /** 制造 颜色 Array **/
        int n = graph.length;
        int[] color = new int[n];
        
        Arrays.fill(color, -1);

        /** 每个点跑一下 **/
        for (int start = 0; start < n; ++start) {
            
            /** 如果没有被访问，就DFS **/
            if (color[start] == -1) {

                    Stack<Integer> stack = new Stack();
                
                    stack.push(start);
                
                    color[start] = 0;

                    while (!stack.empty()) {
                        
                                Integer node = stack.pop();

                                for (int nei: graph[node]) {

                                    if (color[nei] == -1) {

                                        stack.push(nei);

                                        /** 连续与2次，就等于本身 **/
                                        color[nei] = color[node] ^ 1;

                                    } else if (color[nei] == color[node]) {

                                        return false;
                                    }
                                }
                    }
            }
            
        }

        return true;
    }
}

/**
 *    Algorithm：   https://youtu.be/670Gn4e89B8?t=100
 *
 * O(N+E), where NN is the number of nodes in the graph, and EE is the number of edges
 * O(N)
 *
 * **/

/** BFS */