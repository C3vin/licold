class SnakeGame {

        /** 1. 設定一個 set，檢查是否會吃到自己 **/
        private Set<Integer> set; 

        /** 2. 設定一個 Deque，方便更新尾巴 **/
        private Deque<Integer> body; 

        /** 3. 製造參數： 食物，得分，食物坐標 **/
        int[][] food;
        int score;
        int foodIndex;

        /** 4. 高和寬  **/
        int width;
        int height;

        /** 5. 構建函數  **/
        public SnakeGame(int width, int height, int[][] food) {

            this.set = new HashSet();

            /** ~1 把第一個位置的點，加入除   **/
            set.add(0);//initially at [0][0]

            /**      * |S| | |          |1|2|3|
                     * | | |F|          |4|5|6|              * **/

            /** ~2 初始化 body **/
            this.body = new LinkedList<Integer>();

            /** ~3 塞入 第一個 0 **/
            body.offerLast(0);

            /** ~4   **/
            this.food = food;
            this.width = width;
            this.height = height;
        }

        /**
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         *
         * Game over when snake crosses the screen boundary or bites its body.
         */

        /** 6. 製造move **/
        public int move(String direction) {

            /** ~1 邊界條件  **/
            if (score == -1) return -1;

            /** ~2 制造 | compute head  **/
            int rowHead = body.peekFirst() / width;  /** 拿到 row  **/
            int colHead = body.peekFirst() % width;  /** 拿到 col  **/

            switch (direction) {
                case "U":
                    rowHead--;
                    break;
                case "D":
                    rowHead++;
                    break;
                case "L":
                    colHead--;
                    break;
                default:
                    colHead++;
            }

            /** ~3 更新newHead **/
            int newHead = rowHead * width + colHead;

            /** ~4 從set移除  **/
            set.remove(body.peekLast());//we'll remove the tail from set for now to see if it hits its tail
            //if it hits the boundary

            /** ~5 邊界條件  **/
            if (set.contains(newHead) || rowHead < 0 || colHead < 0 || rowHead >= height || colHead >= width) {
                return score = -1;
            }

            /** ~6 更新 set 和 body   //add head for the following two normal cases: **/
            set.add(newHead);
            body.offerFirst(newHead);

            /** ~7 Normal eat case: keep tail, add head  **/
            if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {

                set.add(body.peekLast());//old tail does not change, so add it back to set since we removed it earlier

                foodIndex++;
                return ++score;
            }

            /** ~8 Normal eat case: keep tail, add head  |  normal move case without eating: move head and remove tail **/
            body.pollLast();

            return score;
        }
}