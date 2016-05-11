public class S114 {
	private TreeNode last;
	private TreeNode first;
	
	public void flatten(TreeNode root) {
		last = new TreeNode(0);
		first = last;
		dfs(root);
		while (first != null) {
			first.right = first.left;
			first.left = null;
			first = first.right;
		}
	}
	
	private void dfs(TreeNode t) {
		if (t == null)
			return;
		last.left = t;
		last = t;
		dfs(t.left);
		dfs(t.right);
	}
}
