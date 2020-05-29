//////////////////////////////////////////////////////////////////////////////////////////////////////// Beat 97% 
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        
        int left = 1; 
        int right = 1_000_000_000; 
        
        while( left + 1 < right) {
            
            int mid = left+(right-left)/2; 
            
            if( !possible(piles, H, mid) ) left = mid; 
            else right = mid; 
        }
        
        if( possible(piles, H, left) ) return left;
        else return right; 
    }
    
    public boolean possible(int[] piles, int H, int K) {
        
        int time = 0;
        
        for(int p : piles){
  
            time += (p-1)/K + 1;   /** make sure the hour is correct, for examlpe, 13/4 should be 3 + 1 and 12/4 should be 3  **/
        }
        return time <= H; 
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////// 0526 Submission: 
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
	
    public int minEatingSpeed(int[] piles, int H) {
        
        if(piles.length > H) return -1; 
        
        int all = 0; 
        int topBar = 0; 
        
        for(int p : piles) {
			  all += p;
			  if(p>topBar) topBar = p;   
        }
        
        // speed  
        int lo = all/H + 1;   // if you want to eat all banana, eating speed at least "all / H"
        
        int hi = topBar;  
        
        System.out.println("lo = " + lo);
        System.out.println("hi = " + hi);        
        
        int mid = 0; 
         
        while(lo + 1 < hi) {
          
            mid = lo + (hi - lo)/2; 
            
            if( hoursNeeded(piles, mid) > H ) lo = mid; 
            else hi = mid;
      
        }
        
        System.out.println("final lo = " + lo);
        System.out.println("final hi = " + hi);   
        
        if(  hoursNeeded(piles, lo)  <= H) return lo; 
        else return hi; 
         
    }
     
    public int hoursNeeded(int[] piles, int speed){
      
        int hoursNeeded = 0; 
        
        for(int p : piles){
             
            if(p == 0) continue; 
            
            hoursNeeded += p/speed;  // check very pile need how many hours
            
            if(p%speed != 0) hoursNeeded++;  // do not forget to plus 1 if   p % speed != 0 
 
        }
        
        System.out.println("Speed is " + speed + "   hours need: " +hoursNeeded); 
        
        return hoursNeeded; 
    }
}