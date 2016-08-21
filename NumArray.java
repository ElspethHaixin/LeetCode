public class NumArray {
	int len;
	int[] dp;
	
    public NumArray(int[] nums) {
        len = nums.length;
        dp = new int[len];
        
        if (len == 0)
        	return;
        
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
        	dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
        	return dp[j];
        else
        	return dp[j] - dp[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
