public class S67 {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int add = 0;
		for (; i != -1 && j != -1; i--, j--) {
			int temp = (a.charAt(i) - '0') + (b.charAt(j) - '0') + add;
			if (temp > 1) {
				sb.append((char) ('0' + temp - 2));
				add = 1;
			}
			else {
				sb.append((char) ('0' + temp));
				add = 0;
			}
		}
		if (i > -1) {
			for (; i != -1; i--) {
				int temp = (a.charAt(i) - '0') + add;
				if (temp == 2) {
					sb.append('0');
					add = 1;
				}
				else {
					sb.append((char) ('0' + temp));
					add = 0;
				}
			}
		}
		if (j > -1) {
			for (; j != -1; j--) {
				int temp = (b.charAt(j) - '0') + add;
				if (temp == 2) {
					sb.append('0');
					add = 1;
				}
				else {
					sb.append((char) ('0' + temp));
					add = 0;
				}
			}
		}
		if (add == 1)
			sb.append('1');
		return sb.reverse().toString();
	}
}
