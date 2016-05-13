import java.util.Stack;

public class S331 {
	public boolean isValidSerialization(String preorder) {
		String[] pre = preorder.split(",");
		Stack<String> s = new Stack<String>();
		s.push(pre[0]);
		int len = pre.length;
		for (int i = 1; i < len; i++) {
			if (s.isEmpty())
				return false;
			if (pre[i].equals("#")) {
				if (s.peek().equals("#")) {
					while (true) {
						s.pop();
						if(s.isEmpty())
							return false;
						s.pop();
						if (s.isEmpty())
							break;
						if (s.peek().equals("#"))
							continue;
						s.push("#");
						break;
					}
				}
				else
					s.push("#");
			}
			else
				s.push(pre[i]);
		}
		if (!s.isEmpty() && (s.size() != 1 || !s.peek().equals("#")))
			return false;
		return true;
	}
}
