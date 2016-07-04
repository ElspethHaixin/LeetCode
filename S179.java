import java.util.Arrays;
import java.util.Comparator;

public class S179 {
	private class Cmp implements Comparator<String> {
		public int compare(String a, String b) {
			String ab = a.concat(b);
			String ba = b.concat(a);
			int len = a.length() + b.length();
			for (int i = 0; i < len; i++) {
				if (ab.charAt(i) > ba.charAt(i))
					return -1;
				if (ab.charAt(i) < ba.charAt(i))
					return 1;
			}
			return 0;
		}
	}

	public String largestNumber(int[] nums) {
		StringBuilder ans = new StringBuilder();
		int len = nums.length;
		String[] strings = new String[len];
		for (int i = 0; i != len; i++)
			strings[i] = Integer.toString(nums[i]);
		Arrays.sort(strings, new Cmp());
		if (strings[0].equals("0"))
			return "0";
		for (int i = 0; i < len; i++)
			ans.append(strings[i]);
		return ans.toString();
	}
}
