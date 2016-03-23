package leetcode2;

public class leetcode_92 {
//first method
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++)
            p = p.next;
        
        p.next = reverse(p.next, n - m + 1);
        return dummy.next; 
    }
    
    private ListNode reverse(ListNode head, int n){
        ListNode node = head, prev = null, next = null;
        for(int i = 0; i < n; i++){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = node;
        return prev;
    }
//second method (similar idea)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        int k = n - m;
        int j = m;
        while(j > 1){
            curr = curr.next;
            j--;
        }
  
        ListNode reve = curr.next;
        while(k > 0){
            ListNode temp = reve.next;
            reve.next = reve.next.next;
            temp.next = curr.next;
            curr.next = temp;
            k--;
        }
        if(m == 1){
            head = curr.next;
        }
        return head;
     }
//third method (still similar) 
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;

 }
}
