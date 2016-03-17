package leetcode2;

public class leetcode_237 {
//first method
	public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

//second method
    public void deleteNode(ListNode node) {
        ListNode n1 = null;
        n1 = node.next;
        if (n1 != null) {
            node.val = n1.val;
            node.next = n1.next;
        }
    
//third method (for recursion)
        public void deleteNode(ListNode node) {
            if(node.next==null){
                return;
            }
            node.val = node.next.val;
            if(node.next.next==null){
                node.next=null;
                  return;
            }
            deleteNode(node.next);
            return;
        }
   
	
}
