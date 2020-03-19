class Solution {
    
    // https://www.youtube.com/watch?v=l-og2X5GibY  
    
    public String simplifyPath(String path) {
        
            /** 1. 製造 stack **/
            Deque<String> stack = new LinkedList<>();

            /** 2. 製造 skipSet  **/
            Set<String> skipSet = new HashSet<>(Arrays.asList("..", ".", ""));

            /** 3. 遍歷  **/
            for (String dir : path.split("/")) {

                /** 3.1 如果  **/
                if (dir.equals("..") && !stack.isEmpty()) {

                    stack.pop();

                } else if (!skipSet.contains(dir)) {
                    stack.push(dir);
                }
            }

            String result = "";

            for (String dir : stack) {
                result = "/" + dir + result;
            }

            return result.isEmpty() ? "/" : result;
    }
}