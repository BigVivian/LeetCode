package Fight;

import java.util.ArrayList;
import java.util.List;


public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if (numRows <= 0) {
            return triangle;
        }

        List<Integer> currentRowList = new ArrayList<Integer>();
        currentRowList.add(1);
        triangle.add(currentRowList);

        List<Integer> beforeRowList = new ArrayList<Integer>();
        beforeRowList = currentRowList;

        for (int i = 1; i <= numRows - 1; i++) {
            currentRowList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRowList.add(j, 1);
                } else {
                    int tmp = beforeRowList.get(j - 1) + beforeRowList.get(j);
                    currentRowList.add(j, tmp);
                }
            }
            triangle.add(currentRowList);
            beforeRowList = currentRowList;
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle_118 test = new PascalTriangle_118();
        List<List<Integer>> triangle = test.generate(5);
        for (int i = 0; i <= triangle.size() - 1; i++) {
            List<Integer> rowList = triangle.get(i);

            System.out.print("[");
            for (int tmp : rowList) {
                System.out.print(tmp + " ");
            }
            System.out.print("]\n");

        }
    }
}
