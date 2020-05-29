class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        int lo = 0 ;
        int hi  = A.length - 1; 
        
        int mid; 
        
        while(lo + 1 < hi){
            
            mid = lo + (hi-lo)/2; 
            
            if( A[mid] < A[mid+1]) lo = mid; 

            if( A[mid] > A[mid+1]) hi = mid;             
             
        } 
         
        if(lo<hi) return hi;
        else return lo; 
    }
}