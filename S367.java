public class S367 {
	private int mySqrt(int x) {
		if (x < 1)
			return 0;
		if (x == 1)
			return 1;
		int i = 0;
		int j = x / 2 + 1;
		int mid;
		int tmp;
		while (i <= j) {
			mid = i + (j - i) / 2;
			tmp = x / mid;
			if (tmp < mid) {
				j = mid - 1;
			} else if (tmp > mid) {
				i = mid + 1;
			} else {
				return mid;
			}
		}
		return j;
	}

	public boolean isPerfectSquare(int num) {
		int sqrt = mySqrt(num);
		return sqrt * sqrt == num;
	}
}
