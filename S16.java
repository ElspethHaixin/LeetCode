import java.util.Arrays;

public class S16 {
	public int threeSumClosest(int[] nums, int target) {
		int ans = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		int lim = nums.length - 2;
		for (int k = 0; k < lim; k++) {
			int i = k + 1;
			int j = lim + 1;
			while (i < j) {
				int temp = nums[i] + nums[j] +nums[k];
				if (Math.abs(target - temp) < Math.abs(target - ans))
					ans = temp;
				if (temp < target)
					i++;
				else if (temp > target)
					j--;
				else
					return target;
			}
		}
		return ans;
    }
}
