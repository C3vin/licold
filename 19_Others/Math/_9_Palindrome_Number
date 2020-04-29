class Solution {
    
    public boolean isPalindrome(int x) {
         
        // 如果是负数，或者10的整数倍，返回fals
        if (x < 0 || x != 0 && x % 10 == 0) return false;       

        int reverse = 0;

        while (x > reverse) {
            
            reverse = reverse * 10 + x % 10;
            
            x = x / 10;
            
        }

        return (reverse == x || reverse / 10 == x);
        
    }
    
}