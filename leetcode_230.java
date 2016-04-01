package leetcode2;

public class leetcode_230 {
//first method
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
	     TreeNode p = root;
	     int count = 0;

	     while(!stack.isEmpty() || p != null) {
	         if(p != null) {
	             stack.push(p);  // Just like recursion
	             p = p.left;   

	         } else {
	            TreeNode node = stack.pop();
	            if(++count == k) return node.val; 
	            p = node.right;
	         }
	     }
        //为什么要返回Integer.MIN_VALUE，就是找不到最小的值
	     return Integer.MIN_VALUE;
	 }

//second method
    public int kthSmallest(TreeNode root, int k) {
        int leftN= findN(root.left);// find out the number of node on left subtree
        if (leftN == k-1) return root.val;
        if (leftN < k-1){
            return kthSmallest(root.right, k-leftN-1);
        }else{
            return kthSmallest(root.left, k);
        }
     }

     private int findN(TreeNode root){
        if (root==null) return 0;
        return 1 + findN(root.left) + findN(root.right);
     }
//third method (similar with the first one)
    	 public int kthSmallest(TreeNode root, int k) {
    	     Stack<TreeNode> stack = new Stack<TreeNode>();
    	     stack.push(root);
    	     root = root.left;
    	     while(root!=null || !stack.empty()){
    	         if(root!=null){
    	             stack.push(root);
    	             root = root.left;
    	         }
    	         else{
    	             TreeNode temp = stack.pop();
    	             if(k==1) return temp.val;
    	             else k--;
    	             root = temp.right;
    	         }
    	     }
    	     return 1;   
    	 }
//fourth method
    	 int ans = 0;
    	 public int kthSmallest(TreeNode root, int k) {
    	     TreeNode x = new TreeNode(k);
    	     helper(root, x);
    	     return ans;
    	 }

    	 public void helper(TreeNode root , TreeNode x){
    	     if(root == null || x.val<0) return;

    	     helper(root.left , x);
    	     x.val--;
    	     if(x.val==0){
    	         ans = root.val;
    	         return;
    	     }
    	     helper(root.right , x);
    	 }
}
