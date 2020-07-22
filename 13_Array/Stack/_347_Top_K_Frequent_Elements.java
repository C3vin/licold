class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == 0) return new int[]{};
        
        // freq map
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        // bucket sort on freq
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList();
        for (int key : freq.keySet()) {
            bucket[freq.get(key)].add(key);
        }
        
        // gather result
        List<Integer> res = new ArrayList();
        for (int i = bucket.length - 1; i >= 0; i--) {
  
            res.addAll(bucket[i]);
 
            if (res.size() >= k) break;
        }
        
        while(res.size() > k) res.remove(res.size() - 1); 
 
        int[] resInt = new int[res.size()];
        int i = 0; 
        
        while( i < res.size() ) {
  
            resInt[i] = res.get(i); 
             
            i++;
        }
        
        return resInt;
    }
}