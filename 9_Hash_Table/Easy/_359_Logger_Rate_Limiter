class Logger {

        /** 1. 製造HashMap **/
        private Map<String, Integer> ok = new HashMap<>();

        /** 2. 製造方法  **/
        public boolean shouldPrintMessage(int timestamp, String message) {

            /** ~1 如果現在的timestamp小於已經存在的值（被advanced的值），返回錯誤  **/
            if (timestamp < ok.getOrDefault(message, 0)) return false;

            /** ~2 更新timestamp+10  **/
            ok.put(message, timestamp + 10);

            return true;
        }
}
 
