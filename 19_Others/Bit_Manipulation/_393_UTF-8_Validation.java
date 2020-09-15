class Solution {
      
    public boolean validUtf8(int[] data) {
        
    int idx = 0;
        
    int n = data.length; 
        
    while (idx < n) {
        
        int followers = count ( data [idx] ) - 1; // 如果是光杆司令，就是 -1；否则，就是返回有几个
        
        idx ++;
        
        if (followers == 0 || followers >= 4) return false;
        
        while (followers -- > 0) if (idx == n || count (data [idx ++]) != 1) return false;
        
    }
        
    return true;
        
    }
    
    private int count (int num) {

        int bits = 0;
        
        for (int idx = 7; idx >= 0; idx --) if ((num >> idx & 1) == 0) break; else bits ++;
        
        return bits;

    } 
}