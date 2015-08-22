package Fight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * LeetCode - 242
 * <p/>
 * <pre>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * </pre>
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c;
        int count;
        for (int i = 0; i <= s.length() - 1; i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i <= t.length() - 1; i++) {
            c = t.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, count - 1);
            } else {
                return false;
            }
        }

        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != 0) {
                return false;
            }
        }

        return true;

    }
}
