package Fight;

public class CheckIfTwoStringArraysAreEquivalent_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx1 = 0, idx2 = 0;
        while (i < word1.length && j < word2.length) {
            String w1 = word1[i];
            String w2 = word2[j];

            if (w1.charAt(idx1) != w2.charAt(idx2)) {
                return false;
            }

            if (idx1 + 1 < w1.length()) idx1++;
            else {
                i++;
                idx1 = 0;
            }

            if (idx2 + 1 < w2.length()) idx2++;
            else {
                j++;
                idx2 = 0;
            }
        }

        return i == word1.length && j == word2.length;
    }

    public boolean arrayStringsAreEqual_2(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String w : word1) {
            sb1.append(w);
        }
        for (String w : word2) {
            sb2.append(w);
        }

        return sb1.toString().equals(sb2.toString());
    }

    public boolean arrayStringsAreEqual_3(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
