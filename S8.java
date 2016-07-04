public class S8 {
	public int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str.length() == 0)
			return 0;
		int ans = 0;
		boolean isNeg = false;
		int len = str.length();
		int i = 0;
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		else if (str.charAt(0) == '+')
			i = 1;
		for (; i < len; i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				if (isNeg) {
					if (ans < -214748364)
						return Integer.MIN_VALUE;
					else if (ans == -214748364 && c == '9')
						return Integer.MIN_VALUE;
					else
						ans = ans * 10 - (c - '0');
				}
				else {
					if (ans > 214748364)
						return Integer.MAX_VALUE;
					else if (ans == 214748364 && c > '7')
						return Integer.MAX_VALUE;
					else
						ans = ans * 10 + (c - '0');
				}
			}
			else
				break;
		}
		return ans;
	}
}
