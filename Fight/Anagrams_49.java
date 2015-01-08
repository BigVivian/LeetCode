package Fight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.sort the string<br>
 * 2.create the HashMap<br>
 * 
 * @author Vivian
 * 
 */
public class Anagrams_49 {
	public List<String> anagrams(String[] strs) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();

		for (int i = 0; i <= strs.length - 1; i++) {
			String sortedStr = this.sort(strs[i]);
			if (map.containsKey(sortedStr)) {
				if (!list.contains(strs[map.get(sortedStr)])) {
					list.add(strs[map.get(sortedStr)]);
				}
				list.add(strs[i]);
			} else {
				map.put(sortedStr, i);
			}
		}

		return list;
	}

	// sort the string according to ASCII
	private String sort(String str) {

		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i <= sb.length() - 2; i++) {
			for (int j = i; j <= sb.length() - 1; j++) {
				if (sb.charAt(i) > sb.charAt(j)) {
					char tmp = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(j));
					sb.setCharAt(j, tmp);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Anagrams_49 test = new Anagrams_49();
		String[] strs = { "ate", "eat", "tea", "bloc", "clob", "sky", "yks" };
		List<String> res = test.anagrams(strs);

		for (String tmp : res) {
			System.out.print(tmp + " ");
		}
	}
}
