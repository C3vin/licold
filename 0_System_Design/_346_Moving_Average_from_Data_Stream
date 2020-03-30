class MovingAverage {
 
        /** 1. 定義參數 **/
        private double previousSum = 0.0;
        private int maxSize;
        private Queue<Integer> currentWindow;

        /** 2. 定義Queue尺寸 **/
        public MovingAverage(int size) {
            currentWindow = new LinkedList<Integer>();
            maxSize = size;
        }

        /** 3. next函數  **/
        public double next(int val) {

            /** ~1 首先檢查queue是否等於3  **/
            if (currentWindow.size() == maxSize) previousSum -= currentWindow.remove();

            /** ~2 加上新的  **/
            previousSum += val;
            currentWindow.add(val);


            return previousSum / currentWindow.size();
        }
}