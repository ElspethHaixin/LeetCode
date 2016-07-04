public class S204 {
	public int countPrimes(int n) {
		int cnt = 0;
		boolean[] nums = new boolean[n];
		int sqrt = (int) Math.sqrt(n);
		int i = 2;
		for (; i <= sqrt; i++)
			if (!nums[i]) {
				cnt++;
				for (int j = i * i; j < n; j += i)
					nums[j] = true;
			}
		for (; i < n; i++)
			if (!nums[i])
				cnt++;
		return cnt;
	}
}
