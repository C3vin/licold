class MyCalendar {

        TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap();
        }

        public boolean book(int start, int end) {

            Integer prev = calendar.floorKey(start),      /** return the largest key, which smaller than input  **/
            Integer next = calendar.ceilingKey(start);    /** return the smallest key, which larger than input  **/

            if (   (prev == null || calendar.get(prev) <= start) &&  (next == null || end <= next)    ) {

                calendar.put(start, end);
                return true;
            }
            
            return false;
        }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */