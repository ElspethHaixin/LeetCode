import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			ans.add(root.val);
			root = root.right;
		}
        return ans;
        
		/*
		List<Integer> ans = new LinkedList<Integer>();
		if (root == null)
			return ans;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode temp = root.left;
		while (!s.isEmpty()) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			while (!s.isEmpty()) {
				temp = s.pop();
				ans.add(temp.val);
				temp = temp.right;
				if (temp != null) {
					s.push(temp);
					temp = temp.left;
					break;
				}
			}
		}
		return ans;
		*/
	}
}
