import java.util.LinkedList;
import java.util.List;

public class S131 {
	private List<List<String>> res;
	private List<String> sol;
	private int len;
	
	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	private void dfs(int i, String s) {
		if (i == len) {
			res.add(new LinkedList<String>(sol));
			return;
		}
		
		for (int j = i + 1; j <= len; j++) {
			if (isPalindrome(s.substring(i, j))) {
				sol.add(s.substring(i, j));
				dfs(j, s);
				sol.remove(sol.size() - 1);
			}
		}
	}
	
	public List<List<String>> partition(String s) {
		res = new LinkedList<List<String>>();
		if (s == null || s.length() == 0)
			return res;
		sol = new LinkedList<String>();
		len = s.length();
		dfs(0, s);
		return res;
	}
}
