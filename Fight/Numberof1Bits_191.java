package Fight;

/**
 * 数字n转化为二进制后，1出现的次数
 * <p/>
 * 方法1: 利用 n & n-1的特性，对n而言，n最右边的1将被消去
 * 方法2: 利用0x1左移，从右向左求得该位是否为1
 *
 * @author Vivian
 */

public class Numberof1Bits_191 {

    // 方法1
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // 方法2
    public int hammingWeight2(int n) {
        int count = 0;

        int num = 0x1;

        for (int i = 1; i <= 32; i++) {
            if ((n & num) != 0) {
                count++;
            }
            num = num << 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits_191 test = new Numberof1Bits_191();

//        for (int i = 1; i <= 100; i++) {
//            int res = test.hammingWeight(i);
//            int res2 = test.hammingWeight2(i);
//            System.out.println(res + " " + res2);
//        }

        int res2 = test.hammingWeight2(1073741824);
        System.out.println("**** " + res2);

    }

}
