class Solution {
    
    public String alienOrder(String[] words) {

            Map<Character, Set<Character>> graph = constructGraph(words);

            for(int i = 1; i< words.length; i++){
                
                String a = words[i-1]; 
                String b = words[i];
                
                if(a.length()>b.length() && a.startsWith(b) ){
                    
                    return "";
                }
                
            }
        
        
            return topologicalSorting(graph);
        }

        /** 制造 graph **/
        private Map<Character, Set<Character>> constructGraph(String[] words) {

            Map<Character, Set<Character>> graph = new HashMap<>();

            /** 遍歷 **/
            for (int i = 0; i < words.length; i++) {

                for (int j = 0; j < words[i].length(); j++) {

                    char c = words[i].charAt(j);

                    /** 制造結點 **/
                    if (!graph.containsKey(c)) {

                        graph.put(c, new HashSet<Character>());
                    }
                }
            }

            /** 制造Edge  **/
            for (int i = 0; i < words.length - 1; i++) {

                int k = 0;

                while (k < words[i].length() && k < words[i + 1].length()) { /** 比較 i 和 i+1 的字  **/

                    if (words[i].charAt(k) != words[i + 1].charAt(k)) {

                        graph.get(words[i].charAt(k)).add( words[i + 1].charAt(k) );

                        break;
                    }

                    k++;
                }
            }

            return graph;
        }

        private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {

            Map<Character, Integer> indegree = new HashMap<>();

            for (Character u : graph.keySet()) {

                indegree.put(u, 0);
            }

            /** 遍歷所有的key  **/
            for (Character u : graph.keySet()) {

                /** 有的Key，拿出指向  **/
                for (Character v : graph.get(u)) {

                    indegree.put(v, indegree.get(v) + 1);
                }
            }

            return indegree;
        }

        private String topologicalSorting(Map<Character, Set<Character>> graph) {

            Map<Character, Integer> indegree = getIndegree(graph);

            /** as we should return the topo order with lexicographical order we should use PriorityQueue instead of a FIFO Queue */
            Queue<Character> queue = new PriorityQueue<>();

            for (Character u : indegree.keySet())  if (indegree.get(u) == 0) queue.offer(u);  /** 把 indegree 的  **/

            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {

                Character head = queue.poll();

                sb.append(head);

                for (Character neighbor : graph.get(head)) {  /** 把head的階下囚，拿出來  **/

                    indegree.put(neighbor, indegree.get(neighbor) - 1); /** 入度減一 **/

                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            if (sb.length() != indegree.size()) {
                return "";
            }

            return sb.toString();
        }
}
