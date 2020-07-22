/**  O(n)  |  解法看懂圖示  https://leetcode.com/articles/exclusive-time-of-functions/  **/

class Solution {

        public int[] exclusiveTime(int n, List< String > logs) {

            /** 1. 制造stack **/
            Stack< Integer > stack = new Stack < > ();

            /** 2. 製造答案集合  **/
            int[] res = new int[n];

            /** 3. 切分 log 第一個元素  **/
            String[] s = logs.get(0).split(":");

            /** 4. push第一個元素，的第一個元素，去stack  **/
            stack.push(Integer.parseInt(s[0]));

            /** 5. 初始化 prev  **/
            int i = 1, prev = Integer.parseInt(s[2]);

            /** 6. 只要 i 小於logs的大小 **/
            while (i < logs.size()) {

                /** ~1 拆分 s  **/
                s = logs.get(i).split(":");

                /** ~2 如果是 "start" **/
                if (s[1].equals("start")) {

                    /** ~2.1 更新結果集合：res[stack.peek()] **/
                    if (!stack.isEmpty()) res[stack.peek()] += Integer.parseInt(s[2]) - prev;

                    /** ~2.2 push 當前 id  **/
                    stack.push(Integer.parseInt(s[0]));

                    /** ~2.3 更新 當前的 prev  **/
                    prev = Integer.parseInt(s[2]);

                /** ~3 否則 **/
                } else {

                    /** ~3.1 更新結果 **/
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;

                    /** ~3.2 彈出結束的id  **/
                    stack.pop();

                    /** ~3.3 更新 prev  **/
                    prev = Integer.parseInt(s[2]) + 1;
                }
                i++;
            }
            return res;
        }
}