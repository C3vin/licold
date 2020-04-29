/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

        List<Location> locations;

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            locations = new ArrayList(); /** Each location is a node's x position, y position, and value */

            dfs(root, 0, 0); /* Add all nodes to locations*/

            Collections.sort(locations);

            List<List<Integer>> ans = new ArrayList(); /* final answer container */
            
            ans.add(new ArrayList<Integer>());

            int prev = locations.get(0).x;   /* x is x-axis */

            for (Location loc: locations) {
                // If the x value changed, it's part of a new report.
                if (loc.x != prev) {
                    prev = loc.x;
                    ans.add(new ArrayList<Integer>());
                }

                // We always add the node's value to the latest report.
                ans.get(ans.size() - 1).add(loc.val);
            }

            return ans;
        }

        /** DFS **/
        public void dfs(TreeNode node, int x, int y) {

            if (node != null) {

                /** 加入locations **/
                locations.add(new Location(x, y, node.val));


                dfs(node.left, x-1, y+1);

                dfs(node.right, x+1, y+1);
            }
        }
    

   class Location implements Comparable<Location>{

        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {

            if (this.x != that.x)
                return Integer.compare(this.x, that.x);    /* 从左往右排 */
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);    /* 从上往下排*/
            else
                return Integer.compare(this.val, that.val); /* 同个位置，按照value的值来排 */
        }
    
   
   }
}
