class Solution {
 
    HashMap<Node, Node> map = new HashMap<>();
     
    public Node copyRandomList(Node head) {
        
        if(head == null) return null; 
        
        Node Dummy = new Node(-1);
        
        Dummy.next = head; 
        
        Node curr = null;
        
        while(head!=null){
            
            curr = new Node(head.val); 
            
            map.put(head, curr); 
            
            head = head.next; 
        }
         
        head = Dummy.next; 
        
        while(head!=null){
            
             curr = map.get(head); 
             
             curr.next = map.get(head.next); 
             curr.random = map.get(head.random); 
            
             head = head.next; 
             
        }
        
        return map.get(Dummy.next);     
    }
}