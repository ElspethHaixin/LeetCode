public class S285 {
	
	private TreeNode successor;
	
	private TreeNode dfs(TreeNode t, TreeNode p) {
		if (t == null)
			return null;
		else if (t == p)
			return t;
		
		if (dfs (t.left, p) != null) {
			successor = t;
			return null;
		}
		else if (dfs(t.right, p) != null) {
			return t;
		}
		else {
			return null;
		}
	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (p.right != null) {
			TreeNode t = p.right;
			while (true) {
				if (t.left == null)
					return t;
				t = t.left;
			}
		}
		else {
			successor = null;
			dfs(root, p);
			return successor;
		}
	}
	
}
