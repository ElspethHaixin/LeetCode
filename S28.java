public class S28 {
	public int strStr(String haystack, String needle) {
		/*
		 * KMP
		 *
		int R = 256;
		int M = needle.length();
		if (M == 0)
			return 0;
		int[][] dfa = new int[R][M];
		dfa[needle.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];
			dfa[needle.charAt(j)][j] = j + 1;
			X = dfa[needle.charAt(j)][X];
		}
		
		int i = 0, j = 0, N = haystack.length();
		for (; i < N && j < M; i++)
			j = dfa[haystack.charAt(i)][j];
		if (j == M)
			return i - M;
		else
			return -1;
		*/
		
		int i = 0, j = 0;
		int N = haystack.length(), M = needle.length();
		for (; i < N && j < M; i++) {
			if (haystack.charAt(i) == needle.charAt(j))
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if (j == M)
			return i - M;
		else
			return -1;
	}
}
