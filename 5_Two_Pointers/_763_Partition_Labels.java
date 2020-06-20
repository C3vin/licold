class Solution {   //  https://youtu.be/nKf6wJ6SCa8?t=24
     
     public List<Integer> partitionLabels(String S) {  //  two pointers

            List<Integer> res = new ArrayList<>();

            int[] table = new int[26];
            char[] stc = S.toCharArray();

            for(char c : stc) /** 算每個字母的出現字數 */ table[c-'a']++;

            int i = 0, j = 0, l = S.length();
            int counter = 0; // to record the unique elements
 
            HashSet<Character> hs = new HashSet<>();  /** 制造HashSet  **/
 
            while(j < l){  // 循环
           
                char c = stc[j];  // 拿到当前j指向的字母
 
                if(!hs.contains(c)){  // 放入hashset，增加counter
                    hs.add(c);
                    counter++;
                }
 
                table[c-'a']--;  // table更新
 
                j++;  // j往后移动一位

                // 如果这个字母，已经消耗殆尽，就从hashset里面移除
                if(table[c-'a'] == 0){ // decrease the counter as we have exhausted the c char and remove char c from set
                    counter--;
                    hs.remove(c);
                }

                if(counter == 0){//if counter becomes 0, means current window is a partition
                    res.add(j - i);//add length of current window
                    i = j;// reset i for next window
                }
            }
            return res;
        }
}
