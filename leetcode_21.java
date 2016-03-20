package leetcode2;

public class leetcode_21 {
//first method
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        while(l1!=null && l2!=null){
            if (l1.val<l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if (l1!=null) dummy.next=l1;
        if (l2!=null)  dummy.next=l2;
        return head.next;
    }
	
	
//second method
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
//third method
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null) return l2;
	    if (l2 == null) return l1;
	    ListNode head = l1.val < l2.val ? l1 : l2;
	    ListNode nonHead = l1.val < l2.val ? l2 : l1;

	    head.next = mergeTwoLists(head.next, nonHead);

	    return head;
	}
}
