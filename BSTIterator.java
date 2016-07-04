import java.util.Stack;

public class BSTIterator {

	private TreeNode root;
	private Stack<TreeNode> s;

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.s = new Stack<TreeNode>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null || !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (root != null) {
			s.push(root);
			root = root.left;
		}
		root = s.pop();
		int val = root.val;
		root = root.right;
		return val;
	}

}
