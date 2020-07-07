class Solution {

        public List<String> fullJustify(String[] words, int maxWidth) {

            int left = 0; 
            List<String> result = new ArrayList<>();

            while (left < words.length) {

                int right = findRight(left, words, maxWidth);

                result.add(  justify(left, right, words, maxWidth)  );

                left = right + 1;
            }

            return result;
        }

        /** 找到 本行的 最右 單詞index  **/
        private int findRight(int left, String[] words, int maxWidth) {

            int right = left;

            int sum = words[right++].length();
            
            while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth){
                
                sum += 1 + words[right].length();
                
                right++;
                
            }

            return --right;
        }

        /**  **/
        private String justify(int left, int right, String[] words, int maxWidth) {

            /** 如果本行只有一個單詞  **/
            if (right - left == 0) return padResult(words[left], maxWidth);

            /** 是否最後一行 **/
            boolean isLastLine = right == words.length - 1;

            /** 一共多少單詞 **/
            int numSpaces = right - left;

            /** 計算總共空格長度 **/
            int totalSpace = maxWidth - wordsLength(left, right, words);

            /** 实际间隔的Space */
            String space = isLastLine ? " " : blank( totalSpace / numSpaces );

            /** 实际多余出来的Space*/
            int remainder = isLastLine ? 0 : totalSpace % numSpaces;

            StringBuilder result = new StringBuilder();
            
            for (int i = left; i <= right; i++){
                 
                result.append(words[i])   // 添加这个单词
                      .append(space)      // 尾随一个空格
                      .append(remainder-- > 0 ? " " : "");   // 假如额外的空格
             
            }

            return padResult(result.toString().trim(), maxWidth);
        }

        // 计算总长度
        private int wordsLength(int left, int right, String[] words) {

            int wordsLength = 0;

            for (int i = left; i <= right; i++) wordsLength += words[i].length();

            return wordsLength;
        }

        // 准备最后一行的结果
        private String padResult(String result, int maxWidth) {

            return result + blank(maxWidth - result.length());
        }

        // 制造空格String
        private String blank(int length) {
            
            return new String(new char[length]).replace('\0', ' ');
        
            //  '\0'   ：代表字符串的结束，数值(ASCII)是0
        }
}