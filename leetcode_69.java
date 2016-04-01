package leetcode2;

public class leetcode_69 {
//first method
public int mySqrt(int x) {       
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
//second method (similar with the first one but easier to understand)
public int mySqrt(int x) {
    if (x < 0)
        return -1;
    if (x <= 1)
        return x;
    int low = 1, high = x;
    while (low <=high) {
        int mid = low + (high - low) / 2;
        if (mid == x / mid)
            return mid;
        else if (mid < x / mid)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return high;
}
//third method (still similar idea)
public int mySqrt(int x) {
    if (x<0) return -1;
	if (x==0) return 0;
	int l=1, r=x/2+1;
	while(l<=r){
		int m=(l+r)/2;
		if (m<=x/m  && x/(m+1)<(m+1))   return m;
		if (x/m<m)   r=m-1;
		else l=m+1;
		
	}
    return 0;
    
}
}
