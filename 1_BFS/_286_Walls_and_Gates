public class Solution {
    
    public void wallsAndGates(int[][] rooms) {
        
        LinkedList<int[]> list = new LinkedList<int[]>();
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                
                if(rooms[i][j] == 0) 
                    list.add(new int[]{i,j});
                
            }
        }
        
        int[][] diff = new int[][]{{-1,0,1,0},{0,1,0,-1}};
        
        while(!list.isEmpty()) {
            
            int[] pop = list.remove();
            
            for(int i = 0; i < diff[0].length; i++) {
                
                int newR = pop[0] + diff[0][i];
                int newC = pop[1] + diff[1][i];
                
                if(newR < 0 || 
                   newR >= rooms.length || 
                   newC < 0 || 
                   newC >= rooms[0].length || 
                   rooms[newR][newC] != Integer.MAX_VALUE) continue;
                
                rooms[newR][newC] = rooms[pop[0]][pop[1]] + 1;
                
                list.add(new int[]{newR, newC});
            }
        }
    }
}