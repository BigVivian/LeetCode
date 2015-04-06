package Fight;

import java.util.Arrays;

/**
 * 给定target，求一个数组中最接近target的三个数的和
 *
 * @author Vivian
 * @solution Two Pointers
 */
public class Sum3Closest_16 {

    int res = Integer.MAX_VALUE;

    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        if (num.length >= 3) {
            res = num[0] + num[1] + num[2];
        }

        for (int i = 0; i <= num.length - 3; i++) {
            calc(num, i + 1, num.length - 1, num[i], target);
        }

        return res;
    }

    private void calc(int[] num, int begin, int end, int curNum, int target) {
        while (begin < end) {
            int sum = num[begin] + num[end] + curNum;

            if (sum == target) {
                res = target;
                return;
            } else if (sum < target) {
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                begin++;
            } else {
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {-3, -2, -5, 3, -4};
        int target = -1;

        Sum3Closest_16 test = new Sum3Closest_16();
        int res = test.threeSumClosest(num, target);
        System.out.println(res);
    }
}
