import java.util.HashSet;

public class S52 {

	int size;
	boolean[] vis;
	HashSet<Integer> pri;
	HashSet<Integer> sec;
	int cnt;

	private void dfs(int i) {
		if (i == size) {
			cnt++;
			return;
		}
		for (int j = 0; j < size; j++) {
			if (!vis[j] && !pri.contains(i - j) && !sec.contains(i + j)) {
				vis[j] = true;
				pri.add(i - j);
				sec.add(i + j);
				dfs(i + 1);
				vis[j] = false;
				pri.remove(i - j);
				sec.remove(i + j);
			}
		}
	}

	public int totalNQueens(int n) {
		cnt = 0;
		size = n;
		vis = new boolean[n];
		pri = new HashSet<Integer>();
		sec = new HashSet<Integer>();
		dfs(0);
		return cnt;
	}

}
