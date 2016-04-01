package leetcode2;

public class leetcode_153 {
//first method
	public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0, high = nums.length -1;
        while(low+1 < high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= nums[high]) high = mid; 
            else low = mid; 
        }
     return Math.min(nums[low],nums[high]);
  }
//second method
	int min;
    public int findMin(int[] nums) {
        min = nums[0];
        search(nums,0,nums.length);
        return min;
    }
    
    void search(int[] nums,int left,int right){
        if (left >= right) return;
        int mid = (left + right) /2;
        if (min > nums[mid]) {
            min = nums[mid];
            search(nums,left,mid);
        }
        
    else search(nums,mid+1,right);
}

//third method
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        // find the first element <= target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
