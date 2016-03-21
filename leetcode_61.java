package leetcode2;

public class leetcode_61 {
//first method
public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null)
        return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }
        // get a cycle
        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
        head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
        }
//second method
public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null) return head;

    // Get length
    int len = 1;
    ListNode tail = head;
    while(tail.next != null) {
        tail = tail.next;
        len++;
    }

    // Go to position k distance to tail
    k = k % len;
    if(k == 0) return head;
    ListNode newTail = head;
    for(int i = 0; i < len - k - 1; i++) {
        newTail = newTail.next;
    }

    // Join two parts
    ListNode newHead = newTail.next;
    newTail.next = null;
    tail.next = head;

    return newHead;
}
//third method
private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
        length ++;
        head = head.next;
    }
    return length;
}

public ListNode rotateRight(ListNode head, int n) {
    if (head == null) {
        return null;
    }
    
    int length = getLength(head);
    n = n % length;
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    
    ListNode tail = dummy;
    for (int i = 0; i < n; i++) {
        head = head.next;
    }
    
    while (head.next != null) {
        tail = tail.next;
        head = head.next;
    }
    
    head.next = dummy.next;
    dummy.next = tail.next;
    tail.next = null;
    return dummy.next;
	}
}
