package leetcode2;

public class leetcode_61 {
//first method	(recommanded)
public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null)
        return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }
        // 自己成一个环
        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
        head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
        }
//second method
public ListNode rotateRight(ListNode head, int n) {
    if (head == null) {
        return null;
    }
    ListNode p = head;
    for (int i = 0; i < n; i++) {
        if (p.next != null) {
            p = p.next;
        } else {
            p = head;
        }
    }
    ListNode q = head;
    while (p.next != null) {
        p = p.next;
        q = q.next;
    }
    if (q.next == null) {
        return head;
    }
    ListNode newHead = q.next;
    q.next = null;
    p.next = head;
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
