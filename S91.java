public class S91 {
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		int[] ans = new int[len];
		if (s.charAt(0) == '0')
			return 0;
		else
			ans[0] = 1;
		if (len == 1)
			return 1;
		if (s.charAt(1) == '0') {
			if (s.charAt(0) == '1' || s.charAt(0) == '2')
				ans[1] = 1;
			else
				return 0;
		}
		else {
			if (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) < '7')
				ans[1] = 2;
			else
				ans[1] = 1;
		}
		char c;
		char cprev;
		for (int i = 2; i < len; i++) {
			c = s.charAt(i);
			cprev = s.charAt(i - 1);
			if (c == '0') {
				if (cprev == '1' || cprev == '2')
					ans[i] = ans[i - 2];
				else
					return 0;
			}
			else {
				if (cprev == '1' || cprev == '2' && c < '7')
					ans[i] = ans[i - 1] + ans[i - 2];
				else
					ans[i] = ans[i - 1];
			}
		}
		return ans[len - 1];
	}
}
