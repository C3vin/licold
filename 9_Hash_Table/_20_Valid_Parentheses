class Solution {
 
  public boolean isValid(String s) {
      
    HashMap<Character, Character> mappings;

    mappings = new HashMap<Character, Character>();

    mappings.put(')', '(');  // 注意这里是反括号
    mappings.put('}', '{');
    mappings.put(']', '[');
 
    Stack<Character> stack = new Stack<Character>();

    /* 循环 */ 
    for (int i = 0; i < s.length(); i++) {
        
          /* 拿出当前字母 */
          char c = s.charAt(i);

          /* 如果Hash存在字母 */
          if (mappings.containsKey(c)) {
            
                /* 拿出最顶元素 */
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != mappings.get(c)) {
                  return false;
                }

          } else {

                stack.push(c);
          }

    }
 
    return stack.isEmpty();
  }
}
