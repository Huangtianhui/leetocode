package leetcode2;

public ListNode insertionSortList(ListNode head) {
//first method 
    ListNode root = new ListNode(0); 
    root.next = head;
    ListNode p = head;
    ListNode q;
    ListNode r;

    while (p != null && p.next != null) {
        if (p.val <= p.next.val) {
            p = p.next;
        }else {
            q = p.next;
            p.next = q.next;

            r = root;
            while (r.next.val <= q.val) {
                r = r.next;
            }

            q.next = r.next;
            r.next = q;
        }
    }

    return root.next;
    
    
//second method
    ListNode dummy = new ListNode(0);
    
    
    while(head != null){
        ListNode node = dummy;
        while(node.next != null &&node.next.val < head.val){
           
            node=node.next;
        }
        ListNode temp=head.next;
        head.next=node.next;
        node.next=head;
        head=temp;
    }
    return dummy.next;

//third method (for recursion)
    if (head == null || head.next == null) return head;
    ListNode sorted = new ListNode(Integer.MIN_VALUE);
    sorted.next = head;
    ListNode unsort = head.next;
    head.next = null;
    // the sorted and unsort both are not null at this point
    while (unsort != null) {
        ListNode pos = sorted;
        ListNode cur = unsort;
        unsort = unsort.next;
        while (pos.next != null && pos.val < cur.val 
            && pos.next.val < cur.val) pos = pos.next;
        // now insert (cur) to (pos.next)
        cur.next = pos.next;
        pos.next = cur;
    }
    return sorted.next;
}