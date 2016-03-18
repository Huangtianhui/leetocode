package leetcode2;

public class leetcode_203 {
//first method
	public ListNode removeElements(ListNode head, int val) {
	    ListNode h = new ListNode(0), t=h;  // in case of the first node
	    h.next = head;
	    while (t.next!=null)
	        if (t.next.val==val) t.next = t.next.next;
	        else t = t.next;
	    return h.next;
	    }
//second method (idea could be similar with the first one but use two pointers)
	public ListNode removeElements(ListNode head, int val) {

	    while(head != null && head.val == val){
	        head = head.next;
	    }    
	    if(head == null)
	        return null;
	    ListNode pre = head, cur = head.next;
	    while(cur != null){
	        if(cur.val == val){
	            pre.next = cur.next;
	        }else {
	            pre = pre.next;
	        }
	        cur = cur.next;
	    }
	    return head;
	}
//third method for recursion
	public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
      head.next = removeElements(head.next, val);
      return head = (head.val == val) ? head.next : head;
    }

}
