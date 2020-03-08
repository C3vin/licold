class Solution {

        public String fractionToDecimal(int numerator, int denominator) {

            if (numerator == 0) return "0";
             
            StringBuilder fraction = new StringBuilder();

            if (numerator < 0 ^ denominator < 0) fraction.append("-");  //假如都是负数
 
            // Convert to Long or else abs(-2147483648) overflows
            long dividend = Math.abs(Long.valueOf(numerator));
            long divisor = Math.abs(Long.valueOf(denominator));

            /* 整数 */
            fraction.append(String.valueOf(dividend / divisor));

            /** 余数 */
            long remainder = dividend % divisor;

            /* 如果是整数，就返回 */
            if (remainder == 0) return fraction.toString();
             
            fraction.append(".");

            /* 开始操作小数点后面的 */
            Map<Long, Integer> map = new HashMap<>();

            /** 只要余数 不等于 0，开始制造小数位  */
            while (remainder != 0) {

                if (map.containsKey(remainder)) {
                    
                    fraction.insert(map.get(remainder), "(");
                    fraction.append(")");
                    break;
                    
                }
                                   /* 存入位置 */ 
                map.put(remainder, fraction.length());
                
                remainder *= 10;
                
                fraction.append(String.valueOf(remainder / divisor));
                
                remainder %= divisor;  /*余数循环*/

            }
            
            return fraction.toString();
        }
    
}
