package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode - 264
 * Find the nth ugly number.
 * <p/>
 * keep the index for the 2,3,5
 * next smallest number will be in Min(x*2, y*3, z*5)
 */
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int indexFor2 = 0, indexFor3 = 0, indexFor5 = 0;
        int num2 = 1, num3 = 1, num5 = 1;
        int small;

        for (int i = 1; i <= n - 1; i++) {

            small = Math.min(Math.min(num2 * 2, num3 * 3), num5 * 5);
            list.add(small);

            while (num2 * 2 <= small) {
                indexFor2++;
                num2 = list.get(indexFor2);
            }
            while (num3 * 3 <= small) {
                indexFor3++;
                num3 = list.get(indexFor3);

            }
            while (num5 * 5 <= small) {
                indexFor5++;
                num5 = list.get(indexFor5);
            }
        }

        return list.get(n - 1);
    }

    public static void main(String[] args) {
        UglyNumberII_264 test = new UglyNumberII_264();
        int res = test.nthUglyNumber(10);

        System.out.println(res);
    }
}
