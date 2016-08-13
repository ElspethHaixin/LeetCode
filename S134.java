public class S134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int cnt = 0;
		for (int i = 0; i < len; i++)
			cnt += gas[i] - cost[i];
		if (cnt < 0)
			return -1;
		int index = 0;
		cnt = 0;
		for (int i = 0; i < len; i++) {
			cnt += gas[i] - cost[i];
			if (cnt < 0) {
				cnt = 0;
				index = i + 1;
			}
		}
		return index;
	}
}
