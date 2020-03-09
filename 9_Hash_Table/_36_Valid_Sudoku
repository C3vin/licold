class Solution {

    
    
        public boolean isValidSudoku(char[][] board) {

            /** Get three HashMap **/
            HashMap<Integer, Integer>[] rows = new HashMap[9];
            HashMap<Integer, Integer> [] columns = new HashMap[9];
            HashMap<Integer, Integer> [] boxes = new HashMap[9];

            /** 1. 一共9個行，9個列，9個box **/
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashMap<Integer, Integer>();
                columns[i] = new HashMap<Integer, Integer>();
                boxes[i] = new HashMap<Integer, Integer>();
            }

            /** 2. 驗證  **/
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    /** ~取的當前值 **/
                    char num = board[i][j];

                    /** ~如果不是空 **/
                    if (num != '.') {

                            /** ~1 拿到當前值 **/
                            int n = (int)num;

                            /** ~2 拿到box的index  **/
                            int box_index = (i / 3 ) * 3 /** 每一列有三個，所以乘3 **/ + j / 3 /** 看列在哪 **/;

                            /** 行，列，box，進行檢查  **/
                            rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);

                            columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);

                            boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                            /** 如果有重複 **/
                            if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                                return false;

                            /**
                             *
                                         char[][] a = {
                                         {'5','3','.','.','7','.','.','.','.'},
                                         {'6','.','.','1','9','5','.','.','.'},
                                         {'.','9','8','.','.','.','.','6','.'},
                                         {'8','.','.','.','6','.','.','.','3'},
                                         {'4','.','.','8','.','3','.','.','1'},
                                         {'7','.','.','.','2','.','.','.','6'},
                                         {'.','6','.','.','.','.','2','8','.'},
                                         {'.','.','.','4','1','9','.','.','5'},
                                         {'.','.','.','.','8','.','.','7','9'}

                                         };
                             * **/
                    }
                }
            }
            return true;
        }
    
    
    
}
