package leetcode2;

public class leetcode_278 {
//first method
	public int firstBadVersion(int n) {
	    int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end-start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;            
	    }        
	    return start;
	    }
//second method
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid;
        while (l <= r) {
            mid = l + (r-l) / 2;
            if (isBadVersion(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
