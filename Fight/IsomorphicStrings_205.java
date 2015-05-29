package Fight;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode - 205/Isomorphic Strings
 * <p/>
 * 判断字符串s和t是否能经过字符串的替换后，两字符串相等。一个字符串不能被两个字符串所映射。
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i <= s.length() - 1; i++) {
            //不存在映射 & t[i]没有被映射
            if (!map.containsKey(s.charAt(i)) && !set.contains(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i)) {
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings_205 test = new IsomorphicStrings_205();
        boolean res = test.isIsomorphic("aa", "bb");
        System.out.print(res);
    }
}
