package leetcode2;

public class leetcode_24 {
//first method
	public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode cur = dummy;

       while (cur != null && cur.next != null && cur.next.next != null) {
           cur.next = swap(cur.next, cur.next.next);
           cur = cur.next.next;
       }

       return dummy.next;
    }
    
     private ListNode swap(ListNode next1, ListNode next2) {
       next1.next = next2.next;
       next2.next = next1;
       return next2; // return latter node 
   }
//second method
     public ListNode swapPairs(ListNode head) {
         
    	    if (head == null || head.next == null)
    	        return head;
    	    ListNode dummy = new ListNode(0);
    	    ListNode temp = dummy;
    	    while (head != null && head.next != null) {
    	        temp.next = head.next;
    	        head.next = head.next.next;
    	        temp.next.next = head;
    	        temp = head;
    	        head = head.next;
    	    }
    	    return dummy.next;
    	        
    	    } 
 //third method
     public ListNode swapPairs(ListNode head) {
    	    ListNode newhead = null;
    	        if(head!= null && head.next!=null)
    	        {
    	            ListNode result = swapPairs(head.next.next);
    	            newhead = head.next;
    	            newhead.next = head;
    	            head.next = result;
    	            return newhead;
    	        }
    	        return head;
    	    }
}
