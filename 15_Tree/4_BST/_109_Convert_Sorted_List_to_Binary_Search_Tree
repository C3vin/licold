/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    
    public Node insert(Node start, int x) {

            /** 1. 邊界條件   **/
            // if start is null, create a node pointing to itself and return
            if (start == null) {
                Node node = new Node(x, null);
                node.next = node;
                return node;
            }

            /** 2. 製造 cur **/
            Node cur = start;

            /** 3. 開始戰鬥  **/
            while (true) {

                /** 3.1 如果還在增加  **/  // case 1A: has a tipping point, still climbing
                if (cur.val < cur.next.val) {
                    if (cur.val <= x && x <= cur.next.val) { // x in between cur and next
                        insertAfter(cur, x);
                        break;
                    }

                /** 3.2 零界點  **/    // case 1B: has a tipping point, about to return back to min node
                } else if (cur.val > cur.next.val) {
                    if (cur.val <= x || x <= cur.next.val) { // cur is the tipping point, x is max or min val
                        insertAfter(cur, x);
                        break;
                    }
                /** 3.3 零全部是平的  **/    // case 2: NO tipping point, all flat
                } else {
                    if (cur.next == start) {  // insert x before we traverse all nodes back to start
                        insertAfter(cur, x);
                        break;
                    }
                }

                /** 3.4 和目前的Cur一樣，就下一個  **/// None of the above three cases met, go to next node
                cur = cur.next;
            }

            return start;
    }
    
         /** 插入 **/
        private void insertAfter(Node cur, int x) {


            cur.next = new Node(x, cur.next /** 先運行這個 **/ );
        }
    
    }
    
