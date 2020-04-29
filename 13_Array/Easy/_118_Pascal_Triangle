class Solution {
    
    public List<List<Integer>> generate(int numRows) {
     
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            /** Corner Case */
            // First base case; if user requests zero rows, they get zero rows.
            if (numRows == 0) {
                return triangle;
            }

            /** First row alway [1]  */
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            /** Start War */
            for (int rowNum = 1; rowNum < numRows; rowNum++) {

                /** make a new List */
                List<Integer> row = new ArrayList<>();

                /** get the last row */
                List<Integer> prevRow = triangle.get(rowNum - 1);

                /** build the row */

                row.add(1);

                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                // The last row element is always 1.
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        
    }
    
}