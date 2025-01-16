package Fight;

import java.util.Arrays;

public class Sort_Integers_By_The_Number_Of_1_Bits_1356 {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 100000 * Integer.bitCount(arr[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }

        return arr;
    }
}
