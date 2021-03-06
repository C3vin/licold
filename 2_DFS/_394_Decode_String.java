class Solution {
 
        private int i = 0;  /// 全局变量

        public String decodeString(String s) {   // 自己拿笔划一下!!

            /** 初始化 */
            StringBuilder sb = new StringBuilder();
            
            // 这里的num是重复的次数
            int num = 0;

            /** 循环每个字母 */
            for (; i < s.length(); i++) {

                            /** 拿到当前字母 */
                            char c = s.charAt(i);

                            /** 如果是左括号 */
                            if (c == '[') {

                                        /** i 往后移一位 */
                                        i++;

                                        String str = decodeString(s); // 注意这里的 i 是全局变量!!!  DFS的时候，i已经更新了

                                        for (int k = 0; k < num; k++) sb.append(str);

                                        num = 0;   // num是存重复的次数 --> 使用完一次后归零

                            /** 如果是右括号 */
                            } else if (c == ']') {
                                
                                return sb.toString();

                            /** 如果是数字 */
                            } else if (c >= '0' && c <= '9') {
                                
                                num = num * 10 + c - '0';   //  比如如果数字是 45，  那么先有4，  再来一个5

                            /** 如果是字母 */
                            } else {
                                
                                sb.append(c);

                            }
            }

            return sb.toString();
        }
}