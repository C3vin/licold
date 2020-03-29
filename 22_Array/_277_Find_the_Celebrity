public class Solution extends Relation {
    
    public int findCelebrity(int n) {   
        
        int candidate = 0;
        
        for(int i = 1; i < n; i++){ // 这题要自己画图，然后跟小黄鸭讲。当candidate跳过某一个数字的时候，这个数字，不被candidate认识，那么这个数字本身也不是candidate
            
            if(knows(candidate, i))
                candidate = i;
        }
        
        // 检查这个candidate是否合格
        for(int i = 0; i < n; i++){
                //不需要自己检查自己        //准明星认识i  或者   i不认识准明星  
            if( i != candidate && (  knows(candidate, i) || !knows(i, candidate) )  ) return -1;
            
        }
 
        return candidate;
 
    }
  
}