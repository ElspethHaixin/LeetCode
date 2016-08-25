import java.util.LinkedList;
import java.util.List;

public class S229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new LinkedList<Integer>();
		int num1 = 0, num2 = 0;
		int cnt1 = 0, cnt2 = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == num1)
				cnt1++;
			else if (nums[i] == num2)
				cnt2++;
			else if (cnt1 == 0) {
				num1 = nums[i];
				cnt1 = 1;
			}
			else if (cnt2 == 0) {
				num2 = nums[i];
				cnt2 = 1;
			}
			else {
				cnt1--;
				cnt2--;
			}
		}
		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == num1)
				cnt1++;
			else if (nums[i] == num2)
				cnt2++;
		}
		if (cnt1 > len / 3)
			res.add(num1);
		if (cnt2 > len / 3)
			res.add(num2);
		return res;
	}
}
