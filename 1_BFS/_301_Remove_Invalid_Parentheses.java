class Solution {

        private Set<String> res = new HashSet<String>();  /** 製造一個 validExpression 存放答案集 **/

        private int min;     /** 定義一個 最小刪除 個數 **/

        private void reset() {          /** 重置 **/
            this.res.clear();
            this.min = Integer.MAX_VALUE;
        }

        public List<String> removeInvalidParentheses(String s) {

            this.reset();

            this.recurse(s, 0, 0, 0, new StringBuilder(), 0);

            return new ArrayList(this.res);
        }


        /**
         *    ( ) ( ) ) ( )
         *    1 2 3 4 5 6 7
         * **/

        /** 製造 recurse 函數 **/
        private void recurse( String s, int i /** index **/, int l, int r, StringBuilder e, int remove_Count) {

            if (i == s.length()) {  /** 如果 i 到頂 **/

                            if (l == r) {                               /** 如果是有效 **/

                                if (remove_Count <= this.min) {         /** 如果目前移除的括號 <= 當前最小量 **/

                                    String subAnaswer = e.toString();   /** 把 子答案 變成 String **/

                                    if (remove_Count < this.min) {      /** 如果移除量，小於最小量 **/
                                        this.res.clear();               /** 清除res **/
                                        this.min = remove_Count;        /** 更新 最小量 **/
                                    }
                                    this.res.add(subAnaswer);
                                }
                            }
            }

            else                            /** 如果 i 沒到頂 **/

                {

                char cur = s.charAt(i);     /** 獲取 當前 金幣 **/

                int length = e.length();    /** 獲取 當前 總長度 **/

                if (cur != '(' && cur != ')') {                  /** 如果不是 括號 **/

                    e.append(cur);                               /** 直接收編 **/

                    this.recurse(s, i + 1, l, r, e, remove_Count);

                    e.deleteCharAt(length);                      /** 把剛剛收編的拿出來，給其他Recursion使用 **/

                }
                         else
                                    {
                                        this.recurse(s, i + 1, l, r, e, remove_Count + 1);   /** 刪除第一個，繼續 **/

                                        e.append(cur);                                                       /** 添加該元素 **/

                                        if (cur == '(') {                                                    /** 如果是正括號 **/
                                            this.recurse(s, i + 1, l + 1, r, e, remove_Count);
                                        } else if (l > r) {                                                  /** 如果正括號 > 反括號 **/
                                            this.recurse(s, i + 1, l, r + 1, e, remove_Count);
                                        }

                                        e.deleteCharAt(length);    /** 把剛剛收編的拿出來，給其他Recursion使用 **/
                                    }
            }

        }
}
