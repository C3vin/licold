class Solution {
    
   public static boolean validTree(int n, int[][] edges) {

        /** 1. 構造 HashMap  **/
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        /** 2. 填充 HashMap  **/
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        /** 3. 製造 boolean array，默認全部為 false **/
        boolean[] visited = new boolean[n];

        /** 4. 從頭開始，從 0 位置開始，去檢測  --> 为什么是0？ 其实点也可以，如果他们存在。但边界条件是，假如只有一个0是input **/
        if( !helper(0, -1, map, visited) ) return false;

        /** 5. 測試所有的 visited 元素 **/
        for( boolean b: visited ){
            if(!b)                       /** 如果 b 沒被訪問，返回錯誤。獨立的根元素，不行 **/
                return false;
        }

        return true;
    }

    /** 工具：| 注意，這裡的 map 不會變： **/
    public static boolean helper(int curr, int parent, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited){

        if(visited[curr]) return false;  /** 如果訪問過，返回false **/

        visited[curr] = true;

        for(int i: map.get(curr)){  /** 拿出該根元素，對應的ArrayList **/

            if(i!=parent && !helper(i, curr, map, visited))  return false;

               /** 注意！！！ 為何這裡     i!=parent      **/
               /** 這裡 !helper(i, curr, map, visited) 表示：看是否之前是否訪問過，如果是，返回錯誤 **/

        }
        return true;
    }

    
    
    
}