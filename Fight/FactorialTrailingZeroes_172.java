package Fight;

/**
 * Easy / Math
 * Count the num of 10 = count the num of 2 and 5 = count the num of 5 = count(5,25,125,...)
 */
public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }
}
