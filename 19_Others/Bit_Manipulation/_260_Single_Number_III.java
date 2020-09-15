class Solution {
    
      /* 有几个规则：
         
         1. x & (-x) ---> 拿到x最右边的1
         2. x^x  --> 0 
         
      */     
     
      public int[] singleNumber(int[] nums) {
 
            int bitmask = 0;  // 第一个bitmask
            for (int num : nums) bitmask ^= num; // 这样出现两次的抵消了，剩余的结果是，M, N 的XOR --> 存放在bitmask里面

            // 记住，这时候的bitmask是 M^N 的合体 --> 这里是拿到合体最右边的 1,也就是说，这个位置，M和N是不一样的，暂且当M在这里是1，那么N就是0。
            int diff = bitmask & (-bitmask);

            // 第二个bitmask
            int x = 0;  
            
            // 跟diff，也就是跟“最右一位”相等 --> 那么这里就是1。那也就是说，把“最右一位”是1的，M或N，找出来了。
            for (int num : nums) if ((num & diff) != 0) x ^= num;

          
            // 如果找出一个，另一个y, 自然就是 bitmask ^ x
            return new int[]{x, bitmask^x};
      }
    
}