 public class Solution {

     public List<String> findStrobogrammatic(int n) {
        return helper(n,n);    
     }
 
     private List<String> helper(int curLen, int n){
         
        /* 1. 边界条件 */ 
        if(curLen == 0) return new ArrayList(Arrays.asList(""));            /* 如果长度是是偶数 */ 
        if(curLen == 1) return new ArrayList(Arrays.asList("1","8","0"));   /* 如果长度是是奇数 */
         
        /* 2. 迭代缩进*/ 
        List<String> sub = helper(curLen-2, n);
        
        /* 3.  */ 
        List<String> cur = new ArrayList();
         
        /* 4. 每个都拿出来看看 */ 
        for(String s: sub){
            
            /* 4.1 如果 n== 0， 前后端不能是0 */
            if(curLen != n) cur.add("0" + s + "0");
            
            /* 4.2 添加答案 */
            cur.add("6" + s + "9");
            cur.add("9" + s + "6");
            cur.add("8" + s + "8");
            cur.add("1" + s + "1");	
        }
         
        return cur;
     }  
     
}