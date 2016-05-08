public class S234 {
	public boolean isPalindrome(ListNode head) {
		int len = 0;
		ListNode i = head;
		while (i != null)
		{
			len++;
			i = i.next;
		}
		len /= 2;
		ListNode j = head;
		for (int l = 0; l < len; l++)
			j = j.next;
		j = reverse(j);
		i = head;
		for (int l = 0; l < len; l++, i = i.next, j = j.next)
			if (i.val != j.val)
				return false;
		return true;
	}
	
	private ListNode reverse(ListNode head)
	{
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		ListNode ne = head.next;
		ListNode re = reverse(ne);
		
		ne.next = head;
		head.next = null;
		
		return re;
	}
}
