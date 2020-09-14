class Solution {
    
        public int divide(int dividend, int divisor) {

            /** 1. 商是0，則返回最大值  **/
            if (divisor == 0) return Integer.MAX_VALUE;

            /** 2. 除數是INT最小值，邊界情況  **/
            if (dividend == Integer.MIN_VALUE) {
                if( divisor == -1) return Integer.MAX_VALUE;
                else if (divisor == 1) return Integer.MIN_VALUE;
            }

            /** 3. 防止overflow？？？why？？？  **/
            long divd = (long) dividend;
            long divs = (long) divisor;

            /** 4. 給正負號標誌  **/
            int sign = 1;

            /** 5. 確保正負號  **/
            if(divd < 0) {
                divd = -divd;
                sign = -sign;
            }

            if (divs < 0) {
                divs = -divs;
                sign = - sign;
            }

            /** 6. 初始化為 0  **/
            int res = 0;

            /** 7. 循環  **/
            while (divd >= divs) {

                        /** 7.1 製造 shift  **/
                        int shift = 0;

                        /** 7.2 如果（divs << shift）比 divd 小，繼續移位  **/
                        while ( divd >= (divs << shift) ) { shift++; }

                        /** 7.3 拿到移位后的，res值  **/
                        res += ( 1 << (shift-1) );

                        /** 7.4 更新divd  **/
                        divd -= (divs << (shift-1));
            }

            /** 8. 得出結果  **/
            return sign * res;
        }
}
