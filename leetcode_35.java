package leetcode2;

public class leetcode_35 {
//first method
	public int searchInsert(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	    if (nums[i] >= target)
	            return i;
	    }
	    return nums.length;
	    }
//second method
	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
           
            
          if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
//third method (similar with the second method but clearer to understand)
	public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) l = mid + 1;
            if (nums[mid] > target) r = mid - 1;
        }

        return l;
    }
}
