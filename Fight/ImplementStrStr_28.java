package Fight;

/**
 * Easy
 * String
 */
public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int start = 0;

        int i, j;
        for (i = 0, j = 0; i <= haystack.length() - 1 && j <= needle.length() - 1; ) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                i = ++start;
                j = 0;
            } else {
                i++;
                j++;
            }
        }

        if (j == needle.length()) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ImplementStrStr_28 test = new ImplementStrStr_28();
        int res = test.strStr("123456", "2345");
        System.out.println(res);
    }


}
