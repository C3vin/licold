class Solution {

    List<Integer> a = new ArrayList<>();
    
    int sum = 0;
    
    Random rand = new Random();

    public Solution(int[] w) {
        
        for (int x : w) {
            
            sum += x;
            
            a.add(sum);
            
        }
    }

    public int pickIndex() {
        
        
        /** Generating number from 0 - (sum-1)**/
        int targ = rand.nextInt(sum);

        int lo = 0;
        int hi = a.size() - 1;
        
        while (lo < hi) {
            
            int mid = lo+ (hi - lo) / 2;
            
            if (a.get(mid) <= targ) lo = mid + 1;
            
            else hi = mid;
            
        }
        
        return lo;
        
    }
    
}




