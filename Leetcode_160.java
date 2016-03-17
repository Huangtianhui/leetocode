package leetcode2;

public class Leetcode_160 {

// first method
       public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA == null || headB == null) {
           return null;
       }
       
       // get the tail of list A.
       ListNode node = headA;
       while (node.next != null) {
           node = node.next;
       }
       node.next = headB;
       ListNode result = listCycleII(headA);
       node.next = null;
       return result;
   }
   
   private ListNode listCycleII(ListNode head) {
       ListNode slow = head, fast = head.next;
       
       while (slow != fast) {
           if (fast == null || fast.next == null) {
               return null;
           }
           
           slow = slow.next;
           fast = fast.next.next;
       }
       
       slow = head;
       fast = fast.next;
       while (slow != fast) {
           slow = slow.next;
           fast = fast.next;
       }
       
       return slow;
   }
   
//second method (could be similar with the first method)
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null) return null;
    ListNode endA = headA;
    while (endA.next != null) {
       endA = endA.next;
   }

   // join c3 to b1 making a c1...c3-b1...b3-c1 loop (if b3 indeed points to c1)

   endA.next = headB;
   ListNode start = null; // if there's no cycle this will stay null

   // Floyd's cycle finder

   ListNode slow = headA, fast = headA;

   while (fast != null && fast.next != null) {

       slow = slow.next;

       fast = fast.next.next;

       if (slow == fast) { // found a cycle

           // reset to beginning to find cycle start point (c1)

           start = headA;

           while (slow != start) {

               slow = slow.next;

               start = start.next;

           }

           break;

       }

   }

   // unjoin c3-b1

   endA.next = null;

   return start;

   
        }

// third method
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA == null || headB == null)
           return null;

       int lenA = 0, lenB = 0;
       ListNode p1 = headA, p2 = headB;

       // count length for each list
       while (p1 != null) {
           lenA++;
           p1 = p1.next;
       }

       while (p2 != null) {
           lenB++;
           p2 = p2.next;
       }

       // skip longer list by diff nodes
       int diff = Math.abs(lenA - lenB);
       p1 = lenA > lenB ? headA : headB;

       while (diff-- > 0)
           p1 = p1.next;

       p2 = lenA > lenB ? headB : headA;

       // compare two lists with equal length
       while (p1 != null && p2 != null) {
           if (p1 == p2)
               return p1;

           p1 = p1.next;
           p2 = p2.next;
       }

       return null;
   }
   
// forth method
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;

	    ListNode a = headA;
	    ListNode b = headB;

	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }

	    return a;
	    }
		
	

}
