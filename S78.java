import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class S78 {
	private boolean[] vis;
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		int len = nums.length;
		if (len == 0) {
			List<Integer> l = new LinkedList<Integer>();
			ans.add(l);
			return ans;
		}
		vis = new boolean[len];
		Arrays.sort(nums);
		dfs(0, len - 1, nums, ans);
		return ans;
	}
	
	private void dfs(int i, int max, int[] nums, List<List<Integer>> ans) {
		vis[i] = false;
		if (i == max) {
			List<Integer> l = new LinkedList<Integer>();
			for (int j = 0; j <= max; j++)
				if (vis[j])
					l.add(nums[j]);
			ans.add(l);
		}
		else
			dfs(i + 1, max, nums, ans);
		vis[i] = true;
		if (i == max) {
			List<Integer> l = new LinkedList<Integer>();
			for (int j = 0; j <= max; j++)
				if (vis[j])
					l.add(nums[j]);
			ans.add(l);
		}
		else
			dfs(i + 1, max, nums, ans);
	}
}
