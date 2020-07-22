class Solution {
            public int minAreaRect(int[][] points) {

            Map<Integer, List<Integer>> rows = new TreeMap();

            /** 把x坐標的直線點劃出來 **/
            for (int[] point: points) {
                int x = point[0], y = point[1];
                rows.computeIfAbsent( x, k-> new ArrayList() ).add(y);
            }

            /**  **/
            int ans = Integer.MAX_VALUE;
            Map<Integer, Integer> lastx = new HashMap();

            /** 拿出所有x坐標點 **/
            for (int x: rows.keySet()) {

                /** 拿出所有對應的y坐標點 **/
                List<Integer> row = rows.get(x);

                Collections.sort(row);

                /** y坐標檢查 **/
                for (int i = 0; i < row.size(); ++i)
                    for (int j = i+1; j < row.size(); ++j) {

                        int y1 = row.get(i), y2 = row.get(j);

                        /** 為了讓 code 唯一 **/
                        int code = 40001 * y1 + y2;

                        /** 如果看到相同的 code，拿出來，算出面積 **/
                        if (lastx.containsKey(code))   ans = Math.min(ans, (x - lastx.get(code)) * (y2-y1));

                        lastx.put(code, x);
                    }
            }
            return ans < Integer.MAX_VALUE ? ans : 0;
        }
}