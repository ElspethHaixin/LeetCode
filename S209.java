public class S209 {
	public int minSubArrayLen(int s, int[] nums) {
		/*
		 * My O(N) solution
		 *
		int sum = 0;
		int left = 0, right = -1;
		int len = nums.length;
		int min = len + 1;
		while (left < len) {
			while (sum < s) {
				right++;
				if (right == len)
					return min > len ? 0 : min;
				sum += nums[right];
			}
			if (right - left + 1 < min)
				min = right - left + 1;
			sum -= nums[left];
			left++;
		}
		return min > len ? 0 : min;
		*/
		
		/* A more elegant one */
		int left = 0, right = 0;
		int sum = 0;
		int len = nums.length;
		int res = len + 1;
		while (right < len) {
			while (sum < s && right < len) {
				sum += nums[right];
				right++;
			}
			while (sum >= s) {
				res = Math.min(res, right - left);
				sum -= nums[left];
				left++;
			}
		}
		return res > len ? 0 : res;
	}
}
