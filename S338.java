public class S338 {
	public int[] countBits(int num) {
		if (num < 0)
			return null;
		int[] dp = new int[num + 1];
		dp[0] = 0;
		if (num == 0)
			return dp;
		dp[1] = 1;
		int base = 2;
		int next = 3;
		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - base] + 1;
			if (i == next) {
				base *= 2;
				next = base * 2 - 1;
			}
		}
		return dp;
	}
}
