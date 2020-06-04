class Solution {
    
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        
        ListNode DummyHead = new ListNode(0); 
        
        ListNode m = L1; 
        ListNode n = L2; 
        
        ListNode cur = DummyHead; 
        
        int carry = 0; 
        int i,j,sum,val; 
        
         
        while(m!=null || n!=null){
            
            i = m == null? 0:m.val;
            j = n == null? 0:n.val;
             
            System.out.println("old carry = " + carry);
            
            sum = i + j + carry;
 
            val = sum%10; 
            
            if(sum > 9) carry = 1;
            else carry = 0;
 
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            System.out.println("sum = " + sum);
            System.out.println("new carry = " + carry);
            System.out.println("******* val = " + val);
             
            ListNode tmp = new ListNode( val );
            
            cur.next = tmp; 
            
            cur = cur.next; 
            
            if(m!=null) m = m.next;
            if(n!=null) n = n.next;
             
        }
        
        if(carry == 1) {
            ListNode tmp = new ListNode(1); 
            cur.next = tmp; 
        }
        
        return DummyHead.next; 
    }
}


 