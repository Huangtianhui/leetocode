package leetcode2;

public class leetcode_19 {
//first method (using two pointers) (m+n  n   m   m   n )
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
         dummy.next = head;
        for (int i = 0; i < n; i++){
            head = head.next;
        }
        ListNode temp = dummy;
        while (head != null){
            head = head.next;
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        return dummy.next;
    }

//second method (idea is similar)
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode h1=head, h2=head;
	    while(n-->0) h2=h2.next;
	    if(h2==null)return head.next;  // The head need to be removed, do it.
	    h2=h2.next;

	    while(h2!=null){
	        h1=h1.next;
	        h2=h2.next;
	    }
	    h1.next=h1.next.next;   // the one after the h1 need to be removed
	    return head;
	    
	}
//third method
	public int removeNthFromEndAux(ListNode node, int n) {
        if(node==null)
            return 0;
        int rIdx = removeNthFromEndAux(node.next, n);
        if (rIdx==n)  // assume n always >= 1, so node.next.next must exist
            node.next = node.next.next;
        return 1+rIdx;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0)
            return head;
        if(head==null)
            return head;
        if(n>=removeNthFromEndAux(head,n)) // will remove head!
            return head.next;
        else
            return head;
    }
}
