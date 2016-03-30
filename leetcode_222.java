package leetcode2;

public class leetcode_222 {
//first method by recursion
	public int countNodes(TreeNode root) {
        int leftHeight= 0, rightHeight = 0;
        TreeNode leftNode = root, rightNode = root;
        while (leftNode!= null) 
        { 
            leftHeight++;
            leftNode = leftNode.left;
        }
         while (rightNode!= null) 
        { 
            rightHeight++;
            rightNode = rightNode.right;
        }
        //移动几位相当于2的几次密
        return leftHeight == rightHeight ? (1<<rightHeight) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
    }
//second method
	public int countNodes(TreeNode root) {
        int h = height(root);
        int nodeCount = 0;

        while (root != null) {
            if (height(root.right) == h-1) {
                // Left is full. Add left plus root.
                nodeCount += (1 << h);  // 2**(h-1+1) - 1 + 1
                root = root.right;
            } else {
                // Right is full. Add right plus root.
                nodeCount += (1 << h-1);
                root = root.left;
            }
            h--;
        }
        return nodeCount;
    }

    public int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }
//third method
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int nodes = 0;

        while (root != null) {
            int rightHeight = height(root.right);

            if (leftHeight == rightHeight) {
                nodes += (1 << leftHeight);
                root = root.right;
            } else {
                nodes += (1 << rightHeight);
                root = root.left;
            }

            leftHeight = rightHeight - 1;
        }

        return nodes;
    }

    private int height(TreeNode root) {
        int count = 0;

        while (root != null) {
            count++;
            root = root.left;
        }

        return count;
    }
}
