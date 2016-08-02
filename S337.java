import java.util.HashMap;

public class S337 {
	private HashMap<TreeNode, Integer> rob;
	private HashMap<TreeNode, Integer> nrob;

	private void dfs(TreeNode root) {
		if (root == null)
			return;
		dfs(root.left);
		dfs(root.right);
		
		// rob the node
		rob.put(root, root.val + nrob.get(root.left) + nrob.get(root.right));
		// do not rob the node
		nrob.put(root, Math.max(Math.max(nrob.get(root.left) + nrob.get(root.right), rob.get(root.left) + rob.get(root.right)),
				                Math.max(nrob.get(root.left) + rob.get(root.right), rob.get(root.left) + nrob.get(root.right))));
	}

	public int rob(TreeNode root) {
		rob = new HashMap<TreeNode, Integer>();
		nrob = new HashMap<TreeNode, Integer>();
		rob.put(null, 0);
		nrob.put(null, 0);
		dfs(root);
		return Math.max(rob.get(root), nrob.get(root));
	}
}
