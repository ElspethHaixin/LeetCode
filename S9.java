public class S9 {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int tmp = x;
		int mod = 1;
		while (true) {
			tmp /= 10;
			if (tmp == 0)
				break;
			mod *= 10;
		}
		while (x > 0) {
			if (x % 10 != x / mod)
				return false;
			x -= (x / mod) * mod;
			x /= 10;
			mod /= 100;
		}
		return true;
	}
}
