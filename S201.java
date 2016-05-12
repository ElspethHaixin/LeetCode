public class S201 {
	public int rangeBitwiseAnd(int m, int n) {
		int cnt = 0;
		while (true) {
			if (m == n)
				return m << cnt;
			else {
				m >>= 1;
				n >>= 1;
				cnt++;
			}
		}
	}
}
