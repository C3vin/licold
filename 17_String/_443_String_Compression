class Solution {
    
    public int compress(char[] chars) {
        
            int anchor = 0, write = 0;

            for (int read = 0; read < chars.length; read++) {

                    /** 直接跳到有变化的地方 **/

                    //  是否是最后一个元素        或者     并不是重复的 
                    if (read == chars.length - 1 || chars[read] != chars[read+1]) {

                            chars[write++] = chars[anchor];

                            if (read > anchor) {
                                                    /** 把数字变成字符 **/
                                for ( char c : ( "" + (read - anchor + 1) ).toCharArray()  ) {

                                    chars[write++] = c;

                                }
                            }

                            anchor = read + 1;
                        
                    }
                
            }
        
            return write;
    } 
}