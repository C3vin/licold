class Solution {
    
    public List<String> subdomainVisits(String[] cpdomains) {
        
        
        Map<String, Integer> map = new HashMap();  // 1. we need a map
        
        for(String cd : cpdomains) {  // 2. We cope with every elements --> how to use substring to cut the string
            
            int i = cd.indexOf(' '); 
            int n = Integer.valueOf(cd.substring(0, i)); 
            
            String s = cd.substring(i + 1); 
            
            map.put(s, map.getOrDefault(s,0) + n); 
            
            for(i = 0; i<s.length(); ++i){      // 3. split every element 
                
                    if(s.charAt(i)=='.'){

                        String d = s.substring(i+1); 

                        map.put(d, map.getOrDefault(d,0) + n);  // 4. getOrDefault(key, defaultValue) 
                    }
                
            }
        }
    
        /* 制造答案集合 */
        List<String> res = new ArrayList(); 
        
        for ( String d:map.keySet() ) res.add( map.get(d) + " " + d ) ; 
        
        return res;
    }
}
