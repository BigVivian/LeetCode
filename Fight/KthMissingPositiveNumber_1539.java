package Fight;

public class KthMissingPositiveNumber_1539 {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int num = 1;
        for (int i = 0; i < arr.length; i++, num++) {
            while (arr[i] > num) {
                missing++;
                if (missing == k) {
                    return num;
                }
                num++;
            }
        }

        return num + k - missing - 1;
    }

    public int findKthPositive2(int[] arr, int k) {
        int l = 0, r = arr.length;

        while(l < r) {
            int m = (l + r)/2;
            if(arr[m] - m - 1 < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l + k;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber_1539 test = new KthMissingPositiveNumber_1539();
        int res = test.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        assert (res == 9);
        int res2 = test.findKthPositive(new int[]{1, 2, 3, 4}, 2);
        assert (res2 == 6);
    }
}
