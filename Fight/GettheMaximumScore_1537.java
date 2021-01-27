package Fight;

public class GettheMaximumScore_1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        long res = 0;
        int i = 0, j = 0;
        long c1 = 0, c2 = 0;

        while(i < nums1.length && j < nums2.length) {
            while(i < nums1.length && j < nums2.length && nums1[i] != nums2[j]) {
                if(nums1[i] > nums2[j]) {
                    c2 += nums2[j];
                    j++;
                }

                if(j < nums2.length && nums1[i] < nums2[j]) {
                    c1 += nums1[i];
                    i++;
                }
            }

            if(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                res = res + Math.max(c1, c2) + nums1[i];
                c1 = 0;
                c2 = 0;
                i++;
                j++;
            }
        }

        while(i < nums1.length) {
            c1 += nums1[i++];
        }

        while(j < nums2.length) {
            c2 += nums2[j++];
        }

        res += Math.max(c1, c2) ;

        return (int)(res % 1000000007);
    }

    public static void main(String[] args) {
        GettheMaximumScore_1537 test = new GettheMaximumScore_1537();
        int[] nums1 = {1,4,5,8,9,11,19};
        int[] nums2 = {2,3,4,11,12};
        int result = test.maxSum(nums1, nums2);
        System.out.println(result);
    }
}
