public class S108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(0, nums.length - 1, nums);
	}
	
	private TreeNode dfs(int lo, int hi, int[] nums) {
		if (lo > hi)
			return null;
		int mid = lo + (hi - lo) / 2;
		TreeNode t = new TreeNode(nums[mid]);
		t.left = dfs(lo, mid - 1, nums);
		t.right = dfs(mid + 1, hi, nums);
		return t;
	}
}
