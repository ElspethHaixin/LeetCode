public class NumMatrix {
	int m, n;
	int[][] dp;
	
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0)
        	return;
        n = matrix[0].length;
        if (n == 0)
        	return;
        
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++)
        	dp[i][0] = dp[i - 1][0] + matrix[i][0];
        for (int j = 1; j < n; j++)
        	dp[0][j] = dp[0][j - 1] + matrix[0][j];
        for (int i = 1; i < m; i++)
        	for (int j = 1; j < n; j++)
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0)
        	return dp[row2][col2];
        else if (row1 == 0)
        	return dp[row2][col2] - dp[row2][col1 - 1];
        else if (col1 == 0)
        	return dp[row2][col2] - dp[row1 - 1][col2];
        else
        	return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
