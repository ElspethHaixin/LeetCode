public class S137 {
	public int singleNumber(int[] nums) {
		int ans = 0;
		int len = nums.length;
		int mask, cnt;
		for (int i = 0; i < 32; i++) {
			mask = 1 << i;
			cnt = 0;
			for (int j = 0; j < len; j++)
				if ((nums[j] & mask) != 0)
					cnt++;
			ans += mask * (cnt % 3);
		}
		return ans;
	}
}
