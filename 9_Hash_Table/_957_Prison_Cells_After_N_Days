class Solution {

        /** 解法一： https://www.youtube.com/watch?v=iu_45JvAGlw   **/ 
    
        public int[] prisonAfterNDays(int[] cells, int N) {

            /** 1. 用HashSet來檢查，循環點  **/
            HashSet<String> set = new HashSet<>();

            /** 2. 製造boolean  **/
            boolean hasCycle = false;

            /** 3. 找到count的數量  **/
            int count = 0;

            /** 4. 數N天  **/
            for (int i = 0; i < N; i++) {

                /** ~1 拿到下一天的狀態，然後變成String **/
                int[] next = nextDay(cells);
                String s = Arrays.toString(next);

                /** ~2 看是否存在過 | 如果存在，找到循環點！ **/
                if (!set.contains(s)) {
                    set.add(s);
                    count++;
                } else {
                    hasCycle = true;
                    break;
                }
                cells = next;
            }

            /** 5. 如果存在循環點，用 N 去除 count，取模**/
            if (hasCycle) {

                N = N % count;

                for (int i = 0; i < N; i++) cells = nextDay(cells);
            }
            return cells;
        }

        /** 找到下一日的狀態  **/
        public int[] nextDay (int[] cells) {

            int[] temp = new int[cells.length];

            for (int i = 1; i < cells.length - 1; i++) temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;

            return temp;
        }
    }
