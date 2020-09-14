public class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
      
        
             // [1] 從小到大 
             // [0] 從大到小
        
        
            /**{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
             *
             *  {7,0}
             *  {7,1}
             *  {6,1}
             *  {5,0}
             *  {5,2}
             *  {4,4}
             *
             * */
         
        List<int[]> list = new LinkedList<>();
        
        for (int[] p : people) {
            
            list.add(p[1], p);
            
            System.out.println(p[0]); 
        }
        
        return list.toArray( new int[list.size()][] );
    }
}