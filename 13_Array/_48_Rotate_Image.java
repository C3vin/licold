class Solution {
    
      public void rotate(int[][] matrix) {

                /** 1. 拿到長度 **/
                int n = matrix.length;

                /** 2. 遍歷行 --> 到大半, 就是多的那一半   **/
                for (int i = 0; i < n / 2 + n % 2; i++) {


                    /** 3. 遍歷列，到小半，就是少的那一半  **/
                    for (int j = 0; j < n / 2; j++) {

                            /** 3.1 製造四個角的容器  **/
                            int[] tmp = new int[4];

                            /** 3.2 拿到四個角的值，存在tmp 裡面  **/
                            for (int k = 0; k < 4; k++) {

                                tmp[k] = matrix[i][j];

                                int x = i;
                                
                                i = j;
                                j = n - 1 - x; // 找出对角 

                            }

                            /** 3.3 用tmp填充四個角 **/
                            for (int k = 0; k < 4; k++) {

                                matrix[i][j] = tmp[(k + 3) % 4];

                                int x = i;
                                
                                i = j;
                                j = n - 1 - x;

                            } 
                    }
                    
                }
      }
}
