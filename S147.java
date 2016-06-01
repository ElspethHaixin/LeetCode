public class S147 {
	public ListNode insertionSortList(ListNode head) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		ListNode last;
		ListNode next;
		ListNode hair = new ListNode(0);
		hair.next = head;
		for (int i = len - 2; i > -1; i--) {
			temp = hair;
			int j = i;
			while (j > 0) {
				temp = temp.next;
				j--;
			}
			last = temp;
			temp = temp.next;
			next = temp.next;
			while (next != null && temp.val > next.val) {
				last.next = next;
				temp.next = next.next;
				next.next = temp;
				last = next;
				next = temp.next;
			}
		}
		return hair.next;
	}
}
