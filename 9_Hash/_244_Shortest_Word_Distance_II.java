class WordDistance {

        /** 製造HashMap，存單詞的位置 **/
        HashMap<String, ArrayList<Integer>> locations;
    
        public WordDistance(String[] words) {
            
            locations = new HashMap<String, ArrayList<Integer>>();
            
            for (int i = 0; i < words.length; i++) {
                
                ArrayList<Integer> loc = locations.getOrDefault(words[i], new ArrayList<Integer>());
                
                loc.add(i);
                
                locations.put(words[i], loc);
            }
            
        }
    
           /**  主函數  **/
        public int shortest(String word1, String word2) {

            /** 1. 定義兩個位置  **/
            ArrayList<Integer> loc1, loc2;

            /** 2. Location lists for both the words the indices will be in SORTED order by default 拿到目前的位置集合 */
            loc1 = this.locations.get(word1);
            loc2 = this.locations.get(word2);

            /** 3. 定義參數 **/
            int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;

            /** 4. 循環找出最小值  **/
            while (l1 < loc1.size() && l2 < loc2.size()) {
                
                minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
                
                if (loc1.get(l1) < loc2.get(l2)) {
                    l1++;
                } else {
                    l2++;
                }
            }
            return minDiff;
        }
} 
