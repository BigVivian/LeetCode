package Fight;

/**
 * LeetCode-190 / Reverse Bits / 求逆序后的值
 */
public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num = 0x1;
        int sum = 0;
        for (int i = 1; i <= 32; i++) {
            if ((n & num) != 0) {
                sum = sum * 2 + 1;
            } else {
                sum = sum * 2;
            }
            num = num << 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        ReverseBits_190 test = new ReverseBits_190();
        int res = test.reverseBits(43261596);

        System.out.println("****" + res);
    }
}
