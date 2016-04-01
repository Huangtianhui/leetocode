package leetcode2;

public class leetcode_162 {
//first method
	public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else // nums[mid] > nums[mid - 1]
            {
                right = mid;
            }
        }
        return left;
    }
//second method
	public int findPeakElement(int[] nums) {
	    if(nums.length==1)return 0;
	    if(nums[0]>nums[1])return 0;  //when the first element is peak number *** important condition
	    for(int i=1;i<nums.length-1;i++){
	        if(nums[i]>nums[i-1] &&nums[i]>nums[i+1])return i;
	    }
	    return nums.length-1;
	}
//third method
	public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid-1]) {
                end = mid;
            } else if(nums[mid] < nums[mid+1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] >= nums[end] ? start : end;
    }
}
