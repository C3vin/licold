/** BFS+DFS --> 63%  --> discussion top solution  **/
public class Solution {

        public List<List<String>> findLadders(String start, String end, List<String> wordList) {

            /** 1.1 定義池子  **/
            HashSet<String> dict = new HashSet<String>(wordList);
            
            /** 1.2 定義 結果集  **/
            List<List<String>> res = new ArrayList<List<String>>();
            
            /** 1.3 定義HashMap --> 找鄰居  **/
            HashMap<String, ArrayList<String>> nodeNeighbors 
            = new HashMap<String, ArrayList<String>>();// Neighbors for every node
            
            /** 1.4 定義HashMap --> 找node到起點的距離  **/
            HashMap<String, Integer> distance 
            = new HashMap<String, Integer>();// Distance of every node from the start node
            
            /** 1.5 定義 單個的結果  **/
            ArrayList<String> solution = new ArrayList<String>();
            
            /** 2.0 把start加入池子  **/
            dict.add(start);
            
            /**  3.0 用 BFS 找出 每個node的（和start的距離），一層一層的查 */
            bfs(start, end, dict, nodeNeighbors, distance);
            
            /**  4.0 用 DFS 找出所有 最短的 paths **/
            dfs(start, end, dict, nodeNeighbors, distance, solution, res);
            
            return res;
        }

        /** BFS  **/
        private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {

            /** 3.1 每個node，建立一個鄰居庫  **/
            for (String str : dict) nodeNeighbors.put(str, new ArrayList<String>());

            /** 3.2 示範動作：建立queue  **/
            Queue<String> queue = new LinkedList<String>();

            /** 3.3 在Queue裡面加入start  **/
            queue.offer(start);

            /** 3.4 把start的距離，設置為0，自己跟自己，有 0距離  **/
            distance.put(start, 0);

            /** 3.5 對queue循環  **/
            while (!queue.isEmpty()) {

                /** 3.5.1 拿出Queue的Size **/
                int count = queue.size();

                /** 3.5.2 定義 foundEnd，如果找到了，返回true **/
                boolean foundEnd = false;

                /** 3.5.3 對Queue的內容，進行遍歷  **/
                for (int i = 0; i < count; i++) {

                            /** ~1 poll()出當前單詞, 給cur **/
                            String cur = queue.poll();

                            /** ~2 拿出 cur 的當前距離  **/
                            int curDistance = distance.get(cur);

                            /** ~3 找出 cur 的鄰居  **/
                            ArrayList<String> neighbors = getNeighbors(cur, dict);

                            /** ~4 遍歷 cur 的鄰居  **/
                            for (String n : neighbors) {

                                        /** ~~1 收集 cur 的鄰居  **/
                                        nodeNeighbors.get(cur).add(n);

                                        /** ~~2 檢查 這個 鄰居，是否沒被查過  **/
                                        if (!distance.containsKey(n)) {// Check if visited

                                            /** ~~~1 如果沒查過，設定距離  **/
                                            distance.put(n, curDistance + 1);

                                            /** ~~~2 如果鄰居 = 終點，設置 foundEnd 為 true **/
                                            if (end.equals(n))// Found the shortest path
                                                foundEnd = true;
                                            else
                                            /** ~~~3 如否則，往queue裡加 這個 neighbor **/
                                                queue.offer(n);
                                        }
                            }
                }

                /** 3.5.3 *** 找到最短路徑，就break ****，下一層不用找了  **/
                if (foundEnd) break;
            }
        }

        /** 3.5.3 ~3 子函數：遍歷 --> 找鄰居  **/
        private ArrayList<String> getNeighbors(String node, Set<String> dict) {

            /** ~1 定義 結果集  **/
            ArrayList<String> res = new ArrayList<String>();

            /** ~2 轉換node，變成 char[]  **/
            char chs[] = node.toCharArray();

            /** ~3 從a-z遍歷 -->  每個單詞的字母，都遍歷一次  **/
            for (char ch = 'a'; ch <= 'z'; ch++) {

                for (int i = 0; i < chs.length; i++) {

                    if (chs[i] == ch) continue;

                    char old_ch = chs[i];

                    chs[i] = ch;

                    /** ~~1 如果找到變種詞，加入res結果集  **/
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }

                    /** ~~2 還原 當前 單詞  **/
                    chs[i] = old_ch;
                }

            }
            return res;
        }

        /** 4.0 用 DFS 找出所有 最短的 paths **/
        private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {

            /** 4.1 加入 cur 去 準結果  **/
            solution.add(cur);

            /** 4.2 如果cur等於終點，把solution準結果，加入res結果集  **/
            if (end.equals(cur)) {
                
                res.add(new ArrayList<String>(solution));
                
            } else {

            /** 4.2 否則  **/

                /** ~1 遍歷 cur 的鄰居  **/
                for (String n : nodeNeighbors.get(cur)) {
                    
                    /** ~~1 注意！這裡表示: 測試 n 是否 被 檢查過 --> 若 n 屬於最小路徑之一，必須BFS的時候，被檢查過 --> 參考本代碼94行**/
                    if ( distance.get(cur) + 1 == distance.get(n) ) {

                        /** ~~~1 如果是的：繼續 DFS  **/
                        dfs(n, end, dict, nodeNeighbors, distance, solution, res);
                    }
                }

            }

            /** 4.3 為何要除去？ 因為 163 行 遍歷，需要backtrack一下（用同一個"solution"）**/
            solution.remove(solution.size() - 1);

        }
}

