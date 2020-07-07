public class Solution {
     
    public String reverseWords(String input) {

            final StringBuilder result = new StringBuilder();

            final StringBuilder word = new StringBuilder();
 
            String[] a = input.split("\\s+"); 
         
            for(String sub:a){
                
                word.append(sub);
                
                        result.append(word.reverse());

                        result.append(" ");
                
                word.setLength(0);
                
            }
                
         
            result.deleteCharAt( result.length() - 1 );
        
            return result.toString();
    }
    
     
    
}