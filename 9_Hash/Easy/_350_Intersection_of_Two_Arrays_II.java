class Solution {
        
        public int[] intersect(int[] nums1, int[] nums2) {
            
            if(nums1.length == 0 || nums2.length == 0 || 
               nums1 == null || nums2 == null) return new int[]{}; 
            
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
            List<Integer> list = new ArrayList<Integer>(); 
            
            for(int k : nums1) map.put(k, map.getOrDefault(k,0) + 1); 
            
            for(int k : nums2) {
       
                    if(map.containsKey(k) && map.get(k) > 0 ) {
                        
                        map.put(k, map.get(k) - 1); 
                        
                        list.add(k); 
                        
                    } 
            }
            
            int[] res = new int[list.size()]; 
            
            for(int k=0; k < list.size(); k++)  res[k] = list.get(k);

            return res; 
        }
}