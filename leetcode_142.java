package leetcode2;

public class leetcode_142 {
//first method
	public ListNode detectCycle(ListNode head) {
	       if(head==null) return head;
	       ListNode fast=head;
	       ListNode slow=head;
	       while(fast!=null&&fast.next!=null){
	           fast=fast.next.next;
	           slow=slow.next;
	           if (fast==slow){
	               while(head!=slow){
	                   slow=slow.next;
	                   head=head.next;
	               }
	               return slow;
	           }
	       }
	       return null;
	    }
	
}
