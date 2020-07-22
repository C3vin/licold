public class Solution {
    
   /**Moore Voting algorithm 
   
     Question's meaning: https://www.youtube.com/watch?v=fTrgKqyiazA&t=201s  
   
     如果两个都超过1/3, 说明，最多只有2个major存在。自己想想为什么
     
     然后，有三种个情况，
     
     1. 一个答案都找不到，都没有超过1/3，那么最后一步检核，两个num_1和num_2都无法出线
     2. 找到两个答案，也就是说，input是由， AAAAAAAA BBBBBBBBB CCC 组成，也就是说，CCC无法湮灭A或者B，自然A和B出线 
     3. 找到一个答案，也就是说，input是由， AAAAAAAA BCDEFGHIJKLMNOPQ, 也就是说，A会出线，但另一个字母会暂时出线，但最终会被最后的检核（是否大于1/3）歼灭
  
           (1, 2)      升级版本  n/4  -->  最多3个出线
        
           1,1,1,3,3,  2,7,2,2, 9,   4,3,2,4,1,   -->15 --> 15/4 --> 3 -->  at least 4 
                                             |         
   m1 1
   m2 4
   m3 2      
            
   c1 1
   c2 1
   c3 1      
    
    */     
            
    public List<Integer> majorityElement(int[] nums) {
        
        Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
        
        for (Integer num : nums) {
            
            if ( num.equals(major1) ) {
                                                    cnt1++;
            } else if ( num.equals(major2) ) {
                                                    cnt2++;
            } else if ( cnt1 == 0 ) {
                                                    major1 = num;
                                                    cnt1 = 1;
            } else if ( cnt2 == 0 ) {
                                                    major2 = num;
                                                    cnt2 = 1;
            } else {
                                                    cnt1--;
                                                    cnt2--;
            }
        }
        
        cnt1 = cnt2 = 0;
        
        for (Integer num : nums) {
                                                    if ( num.equals(major1) ) cnt1++;
                                                    else if ( num.equals(major2) ) cnt2++;
        }
        
        List<Integer> result = new ArrayList<>();
        
        if (cnt1 > nums.length / 3) result.add(major1);
        if (cnt2 > nums.length / 3) result.add(major2);
        
        return result;
    }
}





