public class S5 {
	public String longestPalindrome(String s) {
		String ans = "";
		int len = s.length();
		/* a|b|a */
		for (int i = 0; i < len; i++) {
			for (int j = 0; ; j++) {
				if (i - j < 0 || i + j >= len || s.charAt(i - j) != s.charAt(i + j)) {
					if (j * 2 - 1 > ans.length())
						ans = s.substring(i - j + 1, i + j);
					break;
				}
			}
		}
		/* ab|ba */
		for (int i = 1; i < len; i++) {
			for (int j = 0; ; j++) {
				if (i - 1 - j < 0 || i + j >= len || s.charAt(i - 1 - j) != s.charAt(i + j)) {
					if (j * 2 > ans.length())
						ans = s.substring(i - j, i + j);
					break;
				}
			}
		}
		return ans;
	}
}
