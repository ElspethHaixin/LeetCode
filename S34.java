public class S34 {
	public int[] searchRange(int[] nums, int target) {
		boolean found = false;
		int pos = 0;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (target > nums[mid])
				lo = mid + 1;
			else if (target < nums[mid])
				hi = mid - 1;
			else
			{
				found = true;
				pos = mid;
				break;
			}
		}
		if (!found)
		{
			int[] ans = {-1, -1};
			return ans;
		}
		int[] ans = new int[2];
		lo = 0;
		hi = pos;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (target > nums[mid])
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		if (hi > -1 && nums[hi] == target)
			ans[0] = hi;
		else
			ans[0] = lo;
		lo = pos;
		hi = nums.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (target < nums[mid])
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		if (lo < nums.length && nums[lo] == target)
			ans[1] = lo;
		else
			ans[1] = hi;
		return ans;
	}
	public static void main(String[] args) {
		S34 s = new S34();
		int[] a = {5,5,5,8};
		int[] b = s.searchRange(a, 5);
		System.out.println(b[0]);
		System.out.println(b[1]);
	}
}
