package Fight;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i <= s.length() - 1; i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				for (int j = start; j <= i - 1; j++) {
					if (s.charAt(j) != ch) {
						map.remove(s.charAt(j));
					} else {
						break;
					}
				}
				start = map.get(ch) + 1;
				map.put(ch, i);

			} else {
				map.put(ch, i);
				max = (i - start + 1 > max) ? i - start + 1 : max;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubstring test = new LongestSubstring();
		int res = test.lengthOfLongestSubstring("baca");
		System.out.print(res);
	}

}
