class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
            
        //   \\W 代表以非单词字符分割, 只要是正则表达式元字符都行. 
        //   用括号括起来, 再跟一个 + 表示一个或多个非单词分隔符.
        String[] words = paragraph.toLowerCase().split("[\\W]+"); 
        
        // add banned words to set
        Set<String> set = new HashSet<>();
        for(String word : banned){
            set.add(word);
        }
        
        // add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
            
        // get the most frequent word
        int max = 0; // max frequency
        String res = "";
        
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }
        
        return res;
    }
}