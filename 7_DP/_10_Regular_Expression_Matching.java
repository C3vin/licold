class Solution {
 
        int k = 0;

        public boolean isMatch(String a, String b) {

            char[] text = a.toCharArray();
            char[] pattern = b.toCharArray();

            /* 1. 制造DP矩阵 */
            boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

            /* 2. Set the original point as True */
            T[0][0] = true;

            /** 3. Deals with patterns like a*, a*b*, or a*b*c*, etc --> 
            //  这里第一行的TEXT是NULL!!, 处理0输入，又有pattern的情况 **/
            
            for (int i = 1; i < T[0].length; i++) if (pattern[i - 1] == '*') T[0][i] = T[0][i - 2];
 
            /** 4. 开始循环 */
            for (int i = 1; i < T.length; i++) {             /** 行的循環 - TEXT **/
                
                for (int j = 1; j < T[0].length; j++) {      /** 列的循環 - Pattern **/

                    /* Case 1 */
                    if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {  
                        /** 注意!!! ：這裡的 pattern 的位置，和 T[][] 的位置，有1個位置差別 **/
                        
                        T[i][j] = T[i - 1][j - 1];                                 
                        /** 斜對角相等 **/

                    /* Case 2 */
                    } else if (pattern[j - 1] == '*') {  /** 如果是*號，檢查兩個地方，任何一個地方正確都行 **/

                        /* Condition 1, 往前走两格 */  
                        T[i][j] = T[i][j - 2];

                        /* Condition 2，注意这里 pattern[j - 2] 是往前一格 | text[i-1] 是当前位置   */  
                        if ( pattern[j - 2] == '.' || text[i - 1] == pattern[j - 2] ) {  
                            /** 當前位置的，前一個正則字符如果跟，當前的text字符相等 --> 看垂直上一個位置的dp **/
 
                            T[i][j] = T[i][j] || T[i - 1][j];

                        }

                    /* Case 3 */                        
                    } else {
                        
                        T[i][j] = false;
                    }
                }
            }
            return T[text.length][pattern.length];
        }
}

