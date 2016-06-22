import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S51 {

	List<List<String>> ans;
	int size;
	int[][] board;
	boolean[] vis;
	HashSet<Integer> pri;
	HashSet<Integer> sec;

	private void dfs(int i) {
		if (i == size) {
			List<String> sol = new LinkedList<String>();
			StringBuffer sb;
			for (int x = 0; x < size; x++) {
				sb = new StringBuffer();
				for (int y = 0; y < size; y++) {
					if (board[x][y] == 1)
						sb.append('Q');
					else
						sb.append('.');
				}
				sol.add(sb.toString());
			}
			ans.add(sol);
			return;
		}
		for (int j = 0; j < size; j++) {
			if (!vis[j] && !pri.contains(i - j) && !sec.contains(i + j)) {
				vis[j] = true;
				pri.add(i - j);
				sec.add(i + j);
				board[i][j] = 1;
				dfs(i + 1);
				vis[j] = false;
				pri.remove(i - j);
				sec.remove(i + j);
				board[i][j] = 0;
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		ans = new LinkedList<List<String>>();
		size = n;
		board = new int[n][n];
		vis = new boolean[n];
		pri = new HashSet<Integer>();
		sec = new HashSet<Integer>();
		dfs(0);
		return ans;
	}

}
