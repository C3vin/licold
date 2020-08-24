class Solution {
 
    class GraphNode {
                        String den;     double val;

                        GraphNode(String den, double val) {
                            this.den = den;    this.val = val;
                        }
    }

    HashMap<String, List<GraphNode>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

                List<String> equation = equations.get(i);

                map.putIfAbsent(equation.get(0), new ArrayList<>()); 
                map.putIfAbsent(equation.get(1), new ArrayList<>()); 

                map.get(equation.get(0)).add( new GraphNode(equation.get(1), values[i]) );
                map.get(equation.get(1)).add(new GraphNode(equation.get(0), 1/values[i]));
        }

        double[] res = new double[queries.size()];

        for (int i=0; i < res.length; i++) res[i] = find( queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>() );
                                                          /** start **/          /** end **/               /** visited **/                 
        return res;
    }

    private double find( String start,     String end,       double value,       HashSet<String> visited )    {

        if ( visited.contains(start) ) return -1; /* 以免死循環 **/
        if ( !map.containsKey(start) ) return -1; /** 如果不存在 start, 就返回 -1 **/
        if ( !map.containsKey(end)   ) return -1; /** 如果不存在 end, 就返回 -1  --> 这一行没有也行，但是，会消耗不必要的 run time **/
        if ( start.equals(end) ) return value;

        visited.add(start);

        for (GraphNode next : map.get(start)) {

            double sub = find(next.den, end, value*next.val, visited);  /** 乘上next.val **/   

            if (sub != -1) return sub;
        }

        visited.remove(start);
        return -1;
    }
}

