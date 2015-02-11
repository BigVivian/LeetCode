package Fight;

/**
 * Medium
 * Math
 * the kth in n permutation = cal the num  = k / (n-1)!
 */
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {

        // n numbers
        StringBuffer select = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            select.append(i);
        }

        // cal 0! ~ (n-1)!
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i <= n - 1; i++) {
            factor[i] = factor[i - 1] * i;
        }

        // cal the current num
        StringBuffer ret = new StringBuffer();
        k = k - 1;
        int tmp;
        for (int i = n - 1; i >= 0; i--) {
            tmp = k / factor[i];
            ret.append(select.charAt(tmp));
            select.deleteCharAt(tmp);
            k = k % factor[i];
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        PermutationSequence_60 test = new PermutationSequence_60();
        String ret = test.getPermutation(4, 2);
        System.out.print(ret);
    }
}
