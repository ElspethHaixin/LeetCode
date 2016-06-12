import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if (nums == null)
			return ans;
		int len = nums.length;
		if (len < 3)
			return ans;
		Arrays.sort(nums);
		for (int k = 0; k < len - 2; k++) {
			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}
			int i = k + 1;
			int j = len - 1;
			int tar = -nums[k];
			while (i < j) {
				if (i > k + 1 && nums[i] == nums[i - 1]) {
					i++;
					continue;
				}
				int temp = nums[i] + nums[j];
				if (temp < tar) {
					i++;
				}
				else if (temp > tar) {
					j--;
				}
				else {
					List<Integer> sol = new LinkedList<Integer>();
					sol.add(nums[k]);
					sol.add(nums[i]);
					sol.add(nums[j]);
					ans.add(sol);
					i++;
					j--;
				}
			}
		}
		return ans;
	}
}
