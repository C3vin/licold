// Summer Yang's solution 
class Solution {
    // at most 2 transaciotns 
    // 2 transactions only 
    // [3,3,5,0,0,3,1,4] - [5, 0]   [3, 1]

    // f(1, 0, i) + f(1, i+1, n-1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        
        // 1 tranction only
        int res = onetime(prices, 0, n-1);

        // 2 tranctions only
        for(int i = 1; i < n-1; i++) {
            // [0, i]...[i+1, n-1]
            int subres = onetime(prices, 0, i);
            //System.out.print(subres+" - ");
            int subres2 = onetime(prices, i+1, n-1);
            //System.out.println(subres2);
            res = Math.max(res, subres+subres2);
        }
        return res;
    }
    // [0, i]...[i+1, n-1]
    // [3,| 3,5,0,0,3,1,4]

    
    // one tranctions - [start, end]
    public int onetime(int[] prices, int start, int end) {
        if(prices == null || prices.length == 0) return 0;
        // min - mininum price so far
        // res - maximum profit so far
        int min = prices[start], res = 0;
        for(int i = start+1; i <= end; i++) {
            // res, min
            res = Math.max(res, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}

 