package leetcode2;

public class leetcode_25 {
	//first method
    public  ListNode reverse(ListNode head, ListNode end){
           if(head==null || head.next==null || head==end || head.next==end) return head;
           ListNode sec = head.next;
           ListNode rem = reverse(sec,end);
           sec.next =head; head.next=null;
           return rem;
       }
        public  ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head; int count = 0;
            while (curr != null && count != k) {
                curr = curr.next;
                count++;
            }
            if (count == k) {
                ListNode temp = reverseKGroup(curr, k);
                ListNode t = reverse(head,curr);
                head.next = temp;
                return t;
            }
            return head;
        }
      //second method
        public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }	
}
