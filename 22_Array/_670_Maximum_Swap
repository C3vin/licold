/** Greedy   O(N) |  O(1)  **/
class Solution{

        public int maximumSwap(int num) {

            /** 1. 變成 char  **/
            char[] A = Integer.toString(num).toCharArray();

            /** 2. 製造 last，能容量 0~9 的數字 **/
            int[] last = new int[10];

            /** 3. 根據 num，來建造 last --> 最后出现的位置 **/
            for (int i = 0; i < A.length; i++) {

                last[ A[i] - '0' /** 對應的char值 */ ] = i;
            }
            /**
             *     input:   9 7 3 6 7 4
             *     index:   0 1 2 3 4 5  
             *
             *                  2 5   3 4   0
             *     last:  0 1 2 3 4 5 6 7 8 9
             *
             * **/
            /** 4. 遍歷 num **/
            for (int i = 0; i < A.length; i++) {

                /** 4.1 此時A[i]等於多少？  就比這個大就行  **/
                for (int d = 9; d > A[i] - '0'; d--) {

                        /** ~ 如何 d 出現的位數，大於 i --> 那麼，這個d，成為潛在玩家 **/
                        if (last[d] > i) {

                                /** ~1 獲得 當前數值 A[i]  **/
                                char tmp = A[i];

                                /** ~2 交換  **/
                                A[i] = A[last[d]];

                                /** ~2 交換  **/
                                A[last[d]] = tmp;

                                return Integer.valueOf(new String(A));
                        }
                }
            }
            return num;
        }
}