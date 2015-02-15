package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * from end to start
 */
public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();

        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0) {
                    arr[j] = 1;
                } else {
                    arr[j] = arr[j] + arr[j - 1];
                }
            }
        }

        for (int tmp : arr) {
            ret.add(tmp);
        }

        return ret;
    }

    public static void main(String[] args) {
        PascalTriangleII_119 test = new PascalTriangleII_119();
        List<Integer> ret = test.getRow(5);
        for (Integer tmp : ret)
            System.out.print(tmp + " ");
    }
}
