import java.util.Stack;

public class S71 {
	public String simplifyPath(String path) {
		path += '/';
		
		Stack<String> s = new Stack<String>();
		String dir = "";
		int len = path.length();

		for (int i = 1; i < len; i++) {
			if (path.charAt(i) == '/') {
				if (dir.equals("..")) {
					if (!s.isEmpty()) {
						s.pop();
					}
				}
				else if (dir.length() != 0 && !dir.equals(".")) {
					s.push(dir);
				}
				dir = "";
			}

			else {
				dir += path.charAt(i);
			}
		}

		if (s.size() == 0)
			return "/";

		String ans = "";
		
		for (String str : s) {
			ans += '/';
			ans += str;
		}

		return ans;
	}
}
