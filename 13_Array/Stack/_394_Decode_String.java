public class Solution {
    
    public String decodeString(String s) {
        
        String res = "";
        
        Deque<Integer> countStack = new LinkedList<>();
        
        Deque<String> resStack    = new LinkedList<>();
        
        int idx = 0;
        
        while (idx < s.length()) {
            
            if (Character.isDigit(s.charAt(idx))) {
                
                int count = 0;
                
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                
                countStack.addFirst(count);
                
            } else if (s.charAt(idx) == '[') {
                
                resStack.addFirst(res);
                res = "";
                idx++;
                
            } else if (s.charAt(idx) == ']') {
                
                StringBuilder temp = new StringBuilder(resStack.removeFirst());
                
                int repeatTimes = countStack.removeFirst();
                
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                
                res = temp.toString();
                
                idx++;
                
            } else {
                res += s.charAt(idx++);
            }
        }
        
        return res;
    }
}