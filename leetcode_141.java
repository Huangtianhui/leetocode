package leetcode2;

public class leetcode_141 {
//first method
	public boolean hasCycle(ListNode head) {
	    if(head == null) return false;
	    ListNode a=head,b=head.next;
	    while(a!=b)
	    {
	        if(b==null || b.next==null) return false;
	        a=a.next;
	        b=b.next.next;
	    }
	    return true;
	    }
}
