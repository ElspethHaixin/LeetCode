public class S7 {
	public int reverse(int x) {
		int ans = 0;
		int dig;
		if (x < 0) {
			while (x != 0) {
				dig = x % 10;
				if (ans < -214748364)
					return 0;
				ans *= 10;
				if (ans < Integer.MIN_VALUE - dig)
					return 0;
				ans += dig;
				x /= 10;
			}
			return ans;
		}
		while (x != 0) {
			dig = x % 10;
			if (ans > 214748364)
				return 0;
			ans *= 10;
			if (ans > Integer.MAX_VALUE - dig)
				return 0;
			ans += dig;
			x /= 10;
		}
		return ans;
	}
}
