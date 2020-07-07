class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        //  价格          飞机站    剩余站数 
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();  //制造一个HashMap，存放到达每个站的当前价格
        
        //  [0,2,500]  代表的是，出发站，到达站，价格 
        
        for(int[] f:flights) {
            
            if( !prices.containsKey(f[0]) )    prices.put(f[0], new HashMap<>()); 
            
            prices.get(f[0]).put(f[1], f[2]); 
        }
 
        
        
        Queue<int[]> pq = new PriorityQueue<>( (a,b) -> (Integer.compare(a[0],b[0])) );
        
                          /** 这里是price      飞机站     剩余站点  **/
        pq.add( new int[]{        0       ,    src,     K+1} ); 
        
        // BFS 循环开始
        while(!pq.isEmpty()){
            
            int[] top = pq.remove(); 
            
            int price = top[0]; 
            int city = top[1]; 
            int stops = top[2]; 
            
            if(city == dst) return price; 
            
            if(stops > 0) {
     
                // 拿出所有，该飞机站出发点，集合 
                Map<Integer, Integer> adj = prices.getOrDefault( city, new HashMap<>() );  // prices 集合 -->  [0,2,500]  代表的是，出发站，到达站，价格 
                
                //  a 代表终点站
                for(int a:adj.keySet()){

                    pq.add(new int[] {  price + adj.get(a), a, stops -1   }); 
                }
            }   
        }
        return -1; 
    }
}
























