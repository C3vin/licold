class Solution {
    
    public int romanToInt(String s) {

        if(s == null || s.length() ==0) return 0;

        int res = toNumber( s.charAt(s.length()-1) );

        /* 从倒数第二个开始 */
        for (int i = s.length() - 2; i >= 0 ; i--) {

            int m = toNumber(s.charAt(i)); 
            int n = toNumber(s.charAt(i+1)); 
            
            if (m >= n)  res += m;
            else res -= m;

            }

        return res;
    }
 
    public int toNumber(char c){

        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }

        return 0;
    }
}