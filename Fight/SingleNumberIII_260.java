package Fight;

/**
 * LeetCode - 260 / Single Number III / 只有两个元素出现一次，其他元素均出现两次
 * <p/>
 * 两个相等的数异或结果为0。因此，首次扫描数组，得到两个单独的数A、B的异或结果AxorB。
 * 因为A和B不相等，因此AxorB一定不为0，且二进制位为1的位A和B一定不同。
 * 任取AxorB中的一个二进制位，可以将原数组元素分成两组异或即得结果。
 */
public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {

        int tmp = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            tmp = tmp ^ nums[i];
        }

        int count = 0;
        while ((tmp & (1 << count)) == 0) {
            count++;
        }

        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            if ((nums[i] & (1 << count)) != 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0};
        SingleNumberIII_260 test = new SingleNumberIII_260();
        int[] res = test.singleNumber(nums);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
