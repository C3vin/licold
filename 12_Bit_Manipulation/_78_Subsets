class Solution {
    
    public List<List<Integer>> subsets(int[] S) {
        
        // 1. 排序
        Arrays.sort(S);

        // 2. 用原本的长度，来确定总结果的长度
        int totalNumber = 1 << S.length;

        // 3. 制造总结果的容器
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);

        // 4. 按照总结果的size来loop
        for (int i=0; i<totalNumber; i++) {

            // 4.1 制造子答案
            List<Integer> set = new LinkedList<Integer>();

            // 4.2 和原始输入的个数.一个一个算
            for (int j=0; j < S.length; j++) {

                int a = i & (1<<j); 
 
                if ( a != 0 ) set.add(S[j]);

            }

            collection.add(set);
        }

        return collection;
        
    }
}