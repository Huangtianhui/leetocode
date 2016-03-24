package leetcode2;

public class leetcode_109 {
//first method
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode fast = head;
	    ListNode slow = head;
	    ListNode prev =null; 
	    while(fast != null && fast.next != null)
	    { //找到中间值，作为头节点
	        fast = fast.next.next;
	        prev =slow;
	        slow=slow.next;
	    }
	    TreeNode root = new TreeNode(slow.val);
	    if(prev != null)
	        prev.next = null;
	    else
	        head  = null;
	    //都是从两面最小的头节点开始寻找，找到中间值，最为下一个节点
	    root.left = sortedListToBST(head);
	    root.right = sortedListToBST(slow.next);
	    return root;
	    }
    
//second method
	private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
	
}
