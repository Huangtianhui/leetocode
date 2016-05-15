package leetcode2;

public class leetcode_110 {
//first method
	public boolean isBalanced(TreeNode root) {
        if (root==null)  return true;
        return helper(root)!=-1;
    }
    public int helper(TreeNode root){
        if (root==null)  return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        if (left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
//second method
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int height=depth(root.left)-depth(root.right);
        if(height>1||height<-1) return false;
        else return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int depth(TreeNode root){
        if(root==null) return 0;
        int l=depth(root.left);
        int h=depth(root.right);
        return (l>h?l:h)+1;
    }
}
