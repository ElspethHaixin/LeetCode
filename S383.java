import java.util.HashMap;

public class S383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		int len = magazine.length();
		char c;
		for (int i = 0; i < len; i++) {
			c = magazine.charAt(i);
			if (hs.containsKey(c))
				hs.put(c, hs.get(c) + 1);
			else
				hs.put(c, 1);
		}
		
		len = ransomNote.length();
		int val;
		for (int i = 0; i < len; i++) {
			c = ransomNote.charAt(i);
			if (!hs.containsKey(c))
				return false;
			val = hs.get(c);
			if (val == 0)
				return false;
			hs.put(c, val - 1);
		}
		return true;
	}
}
