class Solution {
     
	 // https://youtu.be/Pi7sMZWIIXE?t=24 
	  
     public int getSum(int a, int b) {

            /** 邊界條件 */
            if (a == 0) return b;
            if (b == 0) return a;

            /** 只要 b 不是 0 */
            while (b != 0) {

                /** 滿位 */
                int carry = a & b;

                /** 求非滿位的值 */
                a = a ^ b;

                /** 滿位後往前移一位 */
                b = carry << 1;

            }

            return a;
    }
}