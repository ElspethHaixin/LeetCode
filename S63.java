public class S63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		if (n == 0)
			return 0;
		
		int[][] paths = new int[m][n];
		int ans = 1;
		for (int i = 0; i < m; i++) {
			if (ans == 1 && obstacleGrid[i][0] == 1)
				ans = 0;
			paths[i][0] = ans;
		}
		ans = 1;
		for (int i = 0; i < n; i++) {
			if (ans == 1 && obstacleGrid[0][i] == 1)
				ans = 0;
			paths[0][i] = ans;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					paths[i][j] = 0;
				else
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		
		return paths[m - 1][n - 1];
	}
}
