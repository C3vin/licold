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


////////////////////////////////////////////////////////////////////////////////2020_1023_16:30//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    
    public List<Integer> partitionLabels(String S) {
    
        ////////////////////////////////////////// Corner Case
        List<Integer> res = new LinkedList<>(); 
         
        if(S.length() == 1){
            
            res.add(1); 
            
            return res; 
            
        }
        
        ////////////////////////////////////////// Set up data structures, and prepare the utilities... 
        int[] freq = new int[26]; 
         
        for(char k : S.toCharArray()){
            
            freq[k-'a']++; 
            
        }
        
        HashSet<Character> set = new HashSet<Character>(); 
        
        ////////////////////////////////////////// use Two pointers to traverse the characters in the String 
        
        int left = 0; 
        int right = 0;
         
        while(right < S.length()){
            
            char curr = S.charAt(right); 
            
            if(!set.contains(curr)){                
                                        set.add(curr);   
            } 
            
            freq[curr - 'a']--; 
            
            if(freq[curr - 'a'] == 0){
                
                set.remove(curr); 
                
            }
            
            if(set.isEmpty()){
                
                res.add(right - left + 1); 
                
                left = right + 1; 
            }
         
            
            right++; 
        }
         
        return res; 
    }
     
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
