package Fight;

public class DuplicateZeros_1089 {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num == 0) count++;
        }

        int last = arr.length + count - 1;
        for (int i = arr.length - 1, j = last; i >= 0 && j >= 0; i--, j--) {
            if (j < arr.length) {
                arr[j] = arr[i];
                if (arr[i] == 0 && j >= 1) {
                    arr[--j] = 0;
                }
            } else {
                if (arr[i] == 0) {
                    j--;
                    if(j < arr.length) {
                        arr[j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros_1089 test = new DuplicateZeros_1089();
        test.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }
}
