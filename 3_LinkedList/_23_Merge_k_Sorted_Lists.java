class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {

            if (lists==null||lists.length ==0 ) return null;

            PriorityQueue<ListNode> queue;

            queue = new PriorityQueue<ListNode>(lists.length,
                                                new Comparator<ListNode>(){
                                                @Override
                                                public int compare(ListNode o1,ListNode o2){
                                                    if (o1.val<o2.val)
                                                        return -1;            /** 如果是 -1 就从小到大 **/
                                                    else if (o1.val==o2.val)
                                                        return 0;
                                                    else
                                                        return 1;
                                                }
                                            }
            );

            ListNode dummy = new ListNode(0);

            ListNode tail = dummy;

            /** 把三个链表的头，给queue **/
            for (ListNode node:lists)
                if (node!=null)
                    queue.add(node);

            while (!queue.isEmpty()){

                /****/
                tail.next=queue.poll();

                tail=tail.next;

                if (tail.next!=null)
                    queue.add(tail.next);
            }
            return dummy.next;
        }
}