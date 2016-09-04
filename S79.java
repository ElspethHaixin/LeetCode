public class S79 {
	private boolean res;
	private int m, n, len;
	private boolean[][] vis;
	
	private void dfs(int s, int i, int j, char[][] board, String word) {
		if (res || board[i][j] != word.charAt(s))
			return;
		else if (s == len - 1) {
			res = true;
			return;
		}
		
		if (i > 0 && !vis[i - 1][j]) {
			vis[i - 1][j] = true;
			dfs(s + 1, i - 1, j, board, word);
			vis[i - 1][j] = false;
		}
		
		if (i < m - 1 && !vis[i + 1][j]) {
			vis[i + 1][j] = true;
			dfs(s + 1, i + 1, j, board, word);
			vis[i + 1][j] = false;
		}
		
		if (j > 0 && !vis[i][j - 1]) {
			vis[i][j - 1] = true;
			dfs(s + 1, i, j - 1, board, word);
			vis[i][j - 1] = false;
		}
		
		if (j < n - 1 && !vis[i][j + 1]) {
			vis[i][j + 1] = true;
			dfs(s + 1, i, j + 1, board, word);
			vis[i][j + 1] = false;
		}
	}
	
	public boolean exist(char[][] board, String word) {
		len = word.length();
		if (len == 0)
			return true;
		m = board.length;
		if (m == 0)
			return false;
		n = board[0].length;
		if (n == 0)
			return false;
		vis = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = true;
				dfs(0, i, j, board, word);
				vis[i][j] = false;
				if (res)
					break;
			}
		}
		return res;
	}
}
