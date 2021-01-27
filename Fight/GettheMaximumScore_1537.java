package Fight;

public class GettheMaximumScore_1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long c1 = 0, c2 = 0, res = 0;
        int l1 = nums1.length, l2 = nums2.length;

        while (i < l1 && j < l2) {
            if (nums1[i] > nums2[j]) {
                c2 += nums2[j];
                j++;
            } else if (nums1[i] < nums2[j]) {
                c1 += nums1[i];
                i++;
            } else {
                res = res + Math.max(c1, c2) + nums1[i];
                c1 = 0;
                c2 = 0;
                i++;
                j++;
            }

        }

        while (i < l1) {
            c1 += nums1[i++];
        }

        while (j < l2) {
            c2 += nums2[j++];
        }

        res += Math.max(c1, c2);

        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        GettheMaximumScore_1537 test = new GettheMaximumScore_1537();
        int[] nums1 = {1, 4, 5, 8, 9, 11, 19};
        int[] nums2 = {2, 3, 4, 11, 12};
        int result = test.maxSum(nums1, nums2);
        System.out.println(result);
    }
}
