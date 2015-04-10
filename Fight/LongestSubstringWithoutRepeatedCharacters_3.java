package Fight;

import java.util.HashMap;
import java.util.Map;

/**
 * 求字符串中的一个子串，该子串中无重复的字符<br>
 * 
 * @author Vivian
 * 
 */
public class LongestSubstringWithoutRepeatedCharacters_3 {

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i <= s.length() - 1; i++) {
			char ch = s.charAt(i);

			if (map.containsKey(ch)) {
				// 将字符ch前的所有字符移除
				for (int j = start; j <= i - 1; j++) {
					if (s.charAt(j) != ch) {
						map.remove(s.charAt(j));
					} else {
						break;
					}
				}
				// 移动start指针
				start = map.get(ch) + 1;
				map.put(ch, i);

			} else {
				// 无改字符，放入map中
				map.put(ch, i);
				max = (i - start + 1 > max) ? i - start + 1 : max;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatedCharacters_3 test = new LongestSubstringWithoutRepeatedCharacters_3();
		int res = test.lengthOfLongestSubstring("bzdaca");
		System.out.print(res);

		System.out.println("\nwohahah \"\'<>");
	}

}
