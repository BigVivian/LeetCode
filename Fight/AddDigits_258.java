package Fight;

/**
 * LeetCode - 258
 * <p/>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p/>
 * https://en.wikipedia.org/wiki/Digital_root
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        int tmp = num - ((num - 1) / 9) * 9;
        return tmp;
    }
}
