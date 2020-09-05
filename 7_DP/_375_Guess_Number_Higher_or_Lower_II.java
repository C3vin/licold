public class Solution {
    
	// 题目意思:  https://youtu.be/1yUFG6ud3vI?t=55
	
    int[][] table;
    
    public int getMoneyAmount(int n) {
        
        table = new int[n+1][n+1];
        
        return DP(1, n);
        
    }
    
    int DP(int s, int e){ //  这题思路看视频
        
            if(s >= e) return 0; // 边界条件

            if(table[s][e] != 0) return table[s][e];  //  如果已经存在
         
            int res = Integer.MAX_VALUE;  //  预设最大值
        
                for(int x = s; x <= e; x++){

                        int tmp = x + Math.max( DP(s, x-1), DP(x+1, e)); // 拿x的值，和两头最大的值

                        res = Math.min(res, tmp);   //  ????  --> 看了4个小时，终于明白了。是找min max。 比如 1 2 3 4 5 6 7，每个数字我都找一遍，每个数字都算出max要的钱。然后假如，选5，钱是最少的，那么我就选5，不仅钱最少，还能确保赢。

                }
        
            table[s][e] = res;

            return res;
    }
}