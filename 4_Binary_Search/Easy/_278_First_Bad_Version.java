/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        
        int a = 1; 
        int b = n;
        
        while(a<b){
            
            /** 每次是拿到，前半部分的尾 **/
            int mi = a + (b-a)/2;
          
            if( isBadVersion(mi) ) b = mi; 
            else a = mi + 1; 
            
        }
        
        return a; 
    }
}
 
