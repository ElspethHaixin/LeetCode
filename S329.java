public class S329 {

	private int[][] res;
	private int[][] matrix;
	private int m;
	private int n;

	private int dfs(int i, int j) {
		if (res[i][j] != 0)
			return res[i][j];

		int sol = 0;

		if (i > 0 && matrix[i][j] < matrix[i - 1][j])
			sol = Math.max(sol, dfs(i - 1, j));
		if (i < m - 1 && matrix[i][j] < matrix[i + 1][j])
			sol = Math.max(sol, dfs(i + 1, j));
		if (j > 0 && matrix[i][j] < matrix[i][j - 1])
			sol = Math.max(sol, dfs(i, j - 1));
		if (j < n - 1 && matrix[i][j] < matrix[i][j + 1])
			sol = Math.max(sol, dfs(i, j + 1));

		res[i][j] = sol + 1;
		return sol + 1;
	}

	public int longestIncreasingPath(int[][] matrix) {
		m = matrix.length;
		if (m == 0)
			return 0;
		n = matrix[0].length;
		res = new int[m][n];
		this.matrix = matrix;

		int longest = 0;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				longest = Math.max(longest, dfs(i, j));

		return longest;
	}

}
