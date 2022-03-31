class Solution {
    public int waysToSplit(int[] nums) {
        
	    int mod = (int)(1e9 + 7);

	    int n = nums.length;

	    // prefix array
	    int[] sum = new int[n];
	    sum[0] = nums[0];
	    for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + nums[i];

	    int res = 0;
	    for (int i = 1; i < n - 1; i++) {
	
		    if (sum[i - 1] > (sum[n - 1] - sum[i - 1]) / 2) break;  // early termination

		    int left = searchLeft(sum, sum[i - 1], i);
		    int right = searchRight(sum, sum[i - 1], i);

		    if (left == -1 || right == -1) continue;  // none is satisfied

		    res = (res + (right - left + 1) % mod) % mod;
	    }

	    return res;
    }

    private int searchLeft(int[] sum, int leftSum, int idx) {

	    int n = sum.length;
	    int l = idx, r = n - 2;

	    while (l < r) {

		    int mid = (r - l) / 2 + l;
		    int midSum = sum[mid] - sum[idx - 1];
		    int rightSum = sum[n - 1] - sum[mid];

		    if (leftSum <= midSum && midSum <= rightSum) {
			    r = mid;
		    } else if (leftSum > midSum) {  // shrink left
			    l = mid + 1;
		    } else {  // shrink right
			    r = mid;
		    }

	    }

	    return l;
    }
    
        private int searchRight(int[] sum, int leftSum, int idx) {

	    int n = sum.length;
	    int l = idx, r = n - 2;

	    while (l < r) {

		    int mid = (r - l + 1) / 2 + l;
		    int midSum = sum[mid] - sum[idx - 1];
		    int rightSum = sum[n - 1] - sum[mid];

		    if (leftSum <= midSum && midSum <= rightSum) {
			    l = mid;
		    } else if (leftSum > midSum) {  // shrink left
			    l = mid;
		    } else {  // shrink right
			    r = mid - 1;
		    }

	    }

	    return l;
    }
}
