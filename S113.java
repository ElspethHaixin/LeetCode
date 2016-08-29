import java.util.LinkedList;
import java.util.List;

public class S113 {
	private List<List<Integer>> ret;
	private List<Integer> sol;
	private boolean add;
	
	private void dfs(TreeNode root, int sum, int val) {
		sum += root.val;
		sol.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == val)
				ret.add(new LinkedList<Integer>(sol));
			sol.remove(sol.size() - 1);
			return;
		}
		if (root.left != null)
			dfs(root.left, sum, val);
		if (root.right != null)
			dfs(root.right, sum, val);
		sol.remove(sol.size() - 1);
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ret = new LinkedList<List<Integer>>();
		if (root == null)
			return ret;
		sol = new LinkedList<Integer>();
		add = true;
		dfs(root, 0, sum);
		return ret;
	}
}
