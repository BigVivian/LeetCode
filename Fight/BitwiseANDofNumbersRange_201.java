package Fight;

/**
 * LeetCode - 201 / Bitwise AND of Numbers Range
 * <p/>
 * return the bitwise AND of all numbers in this range, inclusive.
 */

public class BitwiseANDofNumbersRange_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            offset++;
        }

        return m << offset;
    }
}
