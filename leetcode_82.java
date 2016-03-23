package leetcode2;

public class leetcode_82 {
//first method
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }            
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
//second method
public ListNode deleteDuplicates(ListNode head) {
        
        //use two pointers, slow - track the node before the dup nodes, 
    // fast - to find the last node of dups.
    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
    slow.next = fast;
    while(fast != null) {
        while (fast.next != null && fast.val == fast.next.val) {
            fast = fast.next;    //while loop to find the last node of the dups.
        }
        if (slow.next != fast) { //duplicates detected.
            slow.next = fast.next; //remove the dups.
            fast = slow.next;     //reposition the fast pointer.
        } else { //no dup, move down both pointer.
            slow = slow.next;
            fast = fast.next;
        }

    }
    return dummy.next;
        
    }
	
}
