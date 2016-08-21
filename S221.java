public class S221 {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (n == 0)
			return 0;
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			dp[i][0] = matrix[i][0] - '0';
			if (dp[i][0] == 1)
				max = 1;
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = matrix[0][j] - '0';
			if (dp[0][j] == 1)
				max = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					if (dp[i][j] > max)
						max = dp[i][j];
				}
				else
					dp[i][j] = 0;
			}
		}
		return max * max;
	}
}
