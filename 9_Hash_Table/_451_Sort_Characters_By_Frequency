class Solution{
    
    public String frequencySort(String s) {
 
            /** 制造map */
            Map<Character, Integer> map = new HashMap();

            /** 更新map */
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            /** 建造list，用尤Map.Entry，当容量大时 */
            List< Map.Entry<Character, Integer> > list = new ArrayList<> ( map.entrySet() );

            /** Comparator */
            Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));

            /** 开始建造答案 */
            StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<Character, Integer> entry : list) {

                for (int i = 0; i < entry.getValue(); i++) {

                    stringBuilder.append(entry.getKey());
                }
            }

            return stringBuilder.toString();
   } 

}