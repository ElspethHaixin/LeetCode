public class S213 {
	public int rob(int[] nums) {
		int max = 0;
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		int[] tmp = new int[len];
		tmp[0] = nums[0];
		tmp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len - 1; i++) {
			tmp[i] = Math.max(tmp[i - 1], tmp[i - 2] + nums[i]);
		}
		max = tmp[len - 2];
		tmp[len - 1] = nums[len - 1];
		tmp[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
		for (int i = len - 3; i > 0; i--) {
			tmp[i] = Math.max(tmp[i + 1], tmp[i + 2] + nums[i]);
		}
		return Math.max(max, tmp[1]);
	}
}
