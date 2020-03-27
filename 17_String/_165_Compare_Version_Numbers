class Solution {
    
    public int compareVersion(String version1, String version2) {
   
        // 1. split the inputs
        String[] L_1 = version1.split("\\."); 
        String[] L_2 = version2.split("\\.");  
        
        int length = Math.max(L_1.length, L_2.length); 
        
        for(int i=0; i<length; i++){
            
            Integer v1 = i < L_1.length ? Integer.parseInt(L_1[i]) : 0;
            Integer v2 = i < L_2.length ? Integer.parseInt(L_2[i]) : 0; 
            
            int compare = v1.compareTo(v2); 
            
            if(compare !=0){
                return compare; 
            }
            
        }
        
        return 0;
    }
    
}
