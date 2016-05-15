public class S61 {
	public ListNode rotateRight(ListNode head, int k) {
		int len = 0;
		ListNode temp = head;
		ListNode tail = head;
		while (temp != null) {
			if (temp.next == null)
				tail = temp;
			len++;
			temp = temp.next;
		}
		if (len < 2)
			return head;
		k %= len;
		if (k == 0)
			return head;
		temp = head;
		k = len - k - 1;
		for (int i = 0; i < k; i++)
			temp = temp.next;
		tail.next = head;
		head = temp.next;
		temp.next = null;
		return head;
	}
}
