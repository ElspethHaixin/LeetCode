import java.util.Arrays;
import java.util.Comparator;

public class S1 {
	private class Node {
		int val;
		int pos;
		Node (int val, int pos) {
			this.val = val;
			this.pos = pos;
		}
	}
	
	private class Cmp implements Comparator<Node> {
		public int compare(Node a, Node b) {
			if (a.val > b.val)
				return 1;
			if (a.val < b.val)
				return -1;
			return 0;
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		int len = nums.length;
		Node[] nodes = new Node[len];
		for (int k = 0; k < len; k++)
			nodes[k] = new Node(nums[k], k);
		Arrays.sort(nodes, new Cmp());
		int i = 0;
		int j = len - 1;
		while (i < j) {
			int temp = nodes[i].val + nodes[j].val;
			if (temp < target)
				i++;
			else if (temp > target)
				j--;
			else {
				ans[0] = nodes[i].pos;
				ans[1] = nodes[j].pos;
				break;
			}
		}
		return ans;
	}
}
