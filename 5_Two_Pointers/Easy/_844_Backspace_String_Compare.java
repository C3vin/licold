class Solution {
    
    /** Two Pointer | O(M+N) O(1)
     *
     * 教程： https://www.youtube.com/watch?v=vgog1EuEJYQ
     *
     * **/
    public boolean backspaceCompare(String S, String T) {

            int S_pointer = S.length() - 1;  /** 字符串的尾部 **/
            int T_pointer = T.length() - 1;

            int S_skips = 0;
            int T_skips = 0;

            /**
             *
             *    a##c     S_skips   S_pointer
             *                 0       3         -  OK
             *                 0       2
             *                 1       1
             *                 2       0
             *                 1       -1        -  OK
             *
             *    a#v#n#s##a#c
             *                 0       3         -  OK
             *                 0       2
             *                 1       1
             *                 0       0
             *                 1       -1        -  OK
             *
             **/


            /** 從后往前推，應該是緊緊一致 **/

            while (S_pointer >= 0 || T_pointer >= 0) { /** 只要還有字符 **/

                    while (S_pointer >= 0) {

                        if (S.charAt(S_pointer) == '#') {
                                                              S_skips++; S_pointer--;
                        } else if (S_skips > 0) {
                                                              S_skips--; S_pointer--;
                        }
                          else break;
                    }

                    while (T_pointer >= 0) {
                        if (T.charAt(T_pointer) == '#') {T_skips++; T_pointer--;}
                        else if (T_skips > 0) {T_skips--; T_pointer--;}
                        else break;
                    }

                    /**
                     * ab#cab#c
                     * ab#cab#c
                     * **/

                    if (    S_pointer >= 0 && T_pointer >= 0   &&    S.charAt(S_pointer) != T.charAt(T_pointer)   ) return false;

                    if (    ( S_pointer >= 0)    !=     (T_pointer >= 0)    ) return false;


                    S_pointer--; T_pointer--;
            }
            return true;
        } 
}