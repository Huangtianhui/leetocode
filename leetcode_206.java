package leetcode2;

public class leetcode_2062 {
//first method
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode pre=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
	
//second method for recursion	
	public ListNode reverseList(ListNode head) {
        ListNode new_head;
        if (head == null)
            return head;
        else {
            new_head = reverseList(head.next);
            if (head.next != null)
                head.next.next = head;
            else
                new_head = head;
            head.next = null;
            return new_head;
        }
    }
	
//method three (use extra memory)
	public ListNode reverseList(ListNode head) {
        if(null==head) return null;
     List<Integer> list=new ArrayList<Integer>();
      ListNode p=head,q=head;
       while(head!=null)
      {
        list.add(head.val);
    head=head.next;
       }

      for(int i=list.size()-1;i>=0;i--)
      {
       p.val=list.get(i);
       p=p.next;

    }

      return q;
  }
	
}
