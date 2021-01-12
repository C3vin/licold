class Solution {
    
    public int myAtoi(String str) {
        
        if ( str.isEmpty() ) return 0;

        int sign = 1, base = 0, i = 0, n = str.length();

        while (i < n && str.charAt(i) == ' ') ++i;

        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

             if (base > Integer.MAX_VALUE / 10 || ( base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7) ) {  /** 這句話什麼意思呢？ **/

                // -2147483648 to 2147483647.   最后一位是8或者8 
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            }

            base = 10 * base + (str.charAt(i++) - '0');
        }

        return base * sign;
    }
    
}