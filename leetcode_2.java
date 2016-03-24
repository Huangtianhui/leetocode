package leetcode2;

public class leetcode_2 {
//first method
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
	    int carry = 0;
	    ListNode temp = new ListNode(0);
	    ListNode head = temp;
	    while(l1 != null || l2 != null || carry != 0){
	        int value = (l1 == null ? 0: l1.val) + (l2 == null ? 0: l2.val) + carry;
	        carry = 0;
	        carry = value/10;
	        value = value%10;
	        temp.next = new ListNode(value);
	        temp = temp.next;
	        l1 = l1 != null?l1.next:l1;
	        l2 = l2 != null?l2.next:l2;
	    }
	    head = head.next;
	    return head;
	        
	    }
//second method
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}
