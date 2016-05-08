import java.util.LinkedList;
import java.util.List;

public class S257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new LinkedList<String>();
		if (root == null)
			return ans;
		dfs(root, "", ans);
		return ans;
	}
	
	private void dfs(TreeNode t, String s, List<String> l)
	{
		s += "->" + t.val;
		if (t.left == null && t.right == null)
		{
			l.add(s.substring(2, s.length()));
			return;
		}
		if (t.left != null)
			dfs(t.left, s, l);
		if (t.right != null)
			dfs(t.right, s, l);
	}
}
