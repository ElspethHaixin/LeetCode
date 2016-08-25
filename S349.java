import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hs = new HashSet<Integer>();
		List<Integer> l = new LinkedList<Integer>();
		int len1 = nums1.length;
		int len2 = nums2.length;
		for (int i = 0; i < len1; i++)
			hs.add(nums1[i]);
		for (int i = 0; i < len2; i++) {
			if (hs.contains(nums2[i])) {
				hs.remove(nums2[i]);
				l.add(nums2[i]);
			}
		}
		int len = l.size();
		int[] res = new int[len];
		for (int i = 0; i < len; i++)
			res[i] = l.get(i);
		return res;
	}
}
