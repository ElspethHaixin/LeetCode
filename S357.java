public class S357 {
	// backtracking
	/* private int res;
	private boolean first;
	
	private void dfs(int l, int n, boolean[] vis) {
		if (l == n)
			return;
		
		for (int i = 0; i < 10; i++) {
			if (first) {
				first = false;
				continue;
			}
			
			if (!vis[i]) {
				res++;
				vis[i] = true;
				dfs(l + 1, n, vis);
				vis[i] = false;
			}
		}
	}
	
	public int countNumbersWithUniqueDigits(int n) {
		first = true;
		boolean[] vis = new boolean[10];
		dfs(0, n, vis);
		return res + 1;
	}
	*/
	
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n > 10)
			n = 10;
		int res = 10;
		int cnt = 9;
		int num = 9;
		for (int i = 1; i < n; i++) {
			cnt *= num;
			res += cnt;
			num--;
		}
		return res;
	}
}
