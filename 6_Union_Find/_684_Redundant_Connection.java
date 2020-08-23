class Solution {
    
        int MAX_EDGE_VAL = 1000;  /** at most 1000 edges - refer to question description **/

        public int[] findRedundantConnection(int[][] edges) {

            DSU dsu = new DSU(MAX_EDGE_VAL + 1);

            for (int[] edge: edges) {

                if ( !dsu.union( edge[0], edge[1] ) ) return edge;
            }

            throw new AssertionError();
        }

        class DSU {   /**  Disjoint Set Union = Union Find **/

            int[] parent;
            int[] rank;

            public DSU(int size) {

                /** Initiate "parent" array  **/
                parent = new int[size];
                for (int i = 0; i < size; i++) parent[i] = i;

                /** Initiate "rank" array  **/
                rank = new int[size];
            }

            public int find(int x) {

                if (parent[x] != x) parent[x] = find(parent[x]);

                return parent[x];
            }

            public boolean union(int x, int y) {

                int xr = find(x), yr = find(y);

                if (xr == yr) return false;

                else if (rank[xr] < rank[yr]) {
                    parent[xr] = yr;
                }

                else if (rank[xr] > rank[yr]) {
                    parent[yr] = xr;
                }

                else if (rank[xr] == rank[yr]){
                    parent[yr] = xr;
                    rank[xr]++;
                }
                return true;
            }
        }
 
}
