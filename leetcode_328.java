package leetcode2;

public class leetcode_328 {

			
//method one
	    public ListNode oddEvenList(ListNode head) {
	        if (head==null ||head.next==null)  return head;
	        ListNode odd=head, even=head.next,oddHead=odd,evenHead=even;
	        while (odd.next!=null && even.next!=null){
	            //odd.next=even.next;
	            odd.next=odd.next.next;
	            even.next=even.next.next;
	            odd=odd.next;
	            even=even.next;
	        }
	        odd.next=evenHead;
	        return oddHead;
	    }
//method two
	    public ListNode oddEvenList(ListNode head) {
	        if (head == null || head.next == null || head.next.next == null) return head;
	        int count = 1;
	        ListNode p = head;
	        while (p.next != null && p.next.next != null) {
	            p = p.next;
	            count++;
	        }
	        ListNode tail = null;
	        if (count % 2 == 0) {
	            p = p.next;
	        } else {
	            tail = p.next;
	        }
	        ListNode q = head;
	        ListNode oddtail = p;
	        ListNode curr = null;
	        while (q.next != null && q != oddtail) {
	            curr = q.next;
	            q.next = curr.next;
	            p.next = curr;
	            p = curr;
	            q = q.next;
	        }
	        curr.next = tail;
	        return head;
	    }
//method three (idea is similar to the first one but not as good as first one)
	    public ListNode oddEvenList(ListNode head) {
	        if (head == null) return null;
	        ListNode odd = head;
	        ListNode oddTail = head;
	        ListNode even = head.next;
	        ListNode evenHead = even;

	        while(odd != null){
	            if (odd.next != null)
	                odd.next = odd.next.next;
	            if (even != null && even.next != null)
	                even.next = even.next.next;

	            oddTail = odd;

	            if (odd != null)
	                odd = odd.next;
	            if (even != null)
	                even = even.next;
	        }

	        oddTail.next = evenHead;
	        return head;
	         }
		
	

}
