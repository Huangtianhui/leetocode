package leetcode2;

public class leetcode_83 {
//first method
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null)  return head;
        ListNode dummy=head;
        while(head.next!=null){
            if (head.val==head.next.val)  {
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return dummy;
    }
//second method （similar idea but not good as first one）
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode first = head;

	    while(first != null) {

	            while(first.next != null && first.next.val == first.val) {

	                first.next = first.next.next;

	            }

	            first = first.next;

	        }

	        return head;

	    }
	
    
}



