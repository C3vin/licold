class Solution {
    
    public boolean areSentencesSimilarTwo(String[] a, String[] b, List<List<String>> pairs) {

        if (a.length != b.length) return false;
        
        Map<String, String> m = new HashMap<>();
        
        for (List<String> p : pairs) {
            
            String parent1 = find( m, p.get(0) );
            String parent2 = find( m, p.get(1) );
            
            if (!parent1.equals(parent2)) m.put(parent1, parent2); // 让2变成1的爸爸
        }

        for (int i = 0; i < a.length; i++) {
            
            if ( !a[i].equals(b[i]) && !find(m, a[i]).equals( find(m, b[i]) ) ) return false;            
        }
 
        return true;
    }
    
    private String find(Map<String, String> m, String s) {
        
        if ( !m.containsKey(s) ) m.put(s, s);
        
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    } 

