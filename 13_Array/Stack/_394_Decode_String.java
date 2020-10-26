public class Solution {
    
    public String decodeString(String s) {
        
        // Use Deque as Stack
        Deque<Integer> intStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        
        StringBuilder cur = new StringBuilder();
        
        int k = 0;
        
        for (char ch : s.toCharArray()) {
             
            if( Character.isLetter(ch) ) cur.append(ch);
            if( Character.isDigit(ch)  ) k = k * 10 + ch - '0';
             
            if ( ch == '[') {
                
                intStack.addFirst(k);       strStack.addFirst(cur);
                
                k = 0; cur = new StringBuilder();
            }
            
            if (ch == ']') {
                
                StringBuilder tmp = cur;
                
                cur = strStack.removeFirst();
                
                for (k = intStack.removeFirst(); k > 0; --k) cur.append(tmp);
                
            } 
        }
        return cur.toString();         
    }
}

















