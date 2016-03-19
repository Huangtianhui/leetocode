package leetcode2;

public class leetcode_234 {
//first method
	public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //如果是回旋，那么最后的值应该是空
        return p2 == null;
    }
    
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
//stack version
    public boolean isPalindrome(ListNode head) {
        if (head==null)
            return true;
        ListNode curr=head;
        int length = 0;
        Stack<ListNode> stack = new Stack<ListNode>();

        while(curr != null){
            stack.push(curr);
            curr=curr.next;
        }

        curr=head;
        ListNode stackNode = null;
        while(!stack.isEmpty()){
            stackNode=stack.pop();
            if (stackNode.val != curr.val)
                return false;
            curr=curr.next;
        }

        return true;
    }
    
//third method (recurtion method but not recommend)
    ListNode cur;

    public boolean isPalindrome(ListNode head) {
        cur = head;
        return helper(head);
    }

    public boolean helper(ListNode head) {
        if (head == null) {
            return true;
        }

        boolean flag = helper(head.next);

        if (flag && head.val == cur.val) {
            cur = cur.next;
            return true;
        }

        return false;
    }
}
