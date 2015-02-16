package Fight;

/**
 * Search Insert Position - 35
 * Binary Search
 */

public class SearchInsertPosition_35 {
    public int searchInsert(int[] A, int target) {
        return search(A, 0, A.length - 1, target);
    }

    public int search(int[] A, int start, int end, int target) {

        int middle = (start + end) / 2;

        // 边界情况
        if (start >= A.length) {
            return A.length;
        }
        if (end < 0) {
            return 0;
        }

        if (target > A[middle]) {
            return search(A, middle + 1, end, target);
        } else if (target < A[middle]) {
            return search(A, start, middle - 1, target);
        } else {
            return middle;
        }

    }

    public int searchInsert2(int[] A, int target) {

        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int middle = (i + j) / 2;
            if (target == A[middle]) {
                return middle;
            } else if (target > A[middle]) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        int target = 0;
        SearchInsertPosition_35 test = new SearchInsertPosition_35();
        int ret = test.searchInsert(A, target);
        System.out.print(ret);
    }
}
