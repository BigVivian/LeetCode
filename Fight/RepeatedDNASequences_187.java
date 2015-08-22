package Fight;

import java.util.*;

/**
 * LeetCode - 187 / Repeated DNA Sequences
 * <p/>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p/>
 * 使用2bit的数表示字符
 */
public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> existing = new HashSet<Integer>();
        Set<Integer> added = new HashSet<Integer>();

        int hash = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i));
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));

                // make hash length = 20
                hash = hash & (0xFFFFF);
                if (existing.contains(hash) && !added.contains(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                } else {
                    existing.add(hash);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        RepeatedDNASequences_187 test = new RepeatedDNASequences_187();
        test.findRepeatedDnaSequences("CAAAAAAAAAC");

    }

}
