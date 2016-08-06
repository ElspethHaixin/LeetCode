public class S152 {
	public int maxProduct(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int ans = nums[0];
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < len; i++) {
			int mx = max;
			int mn = min;
			max = Math.max(Math.max(nums[i] * mx, nums[i] * mn), nums[i]);
			min = Math.min(Math.min(nums[i] * mx, nums[i] * mn), nums[i]);
			ans = Math.max(ans, max);
		}
		return ans;
	}
}
