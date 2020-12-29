package Fight;

public class NumberOfStepsToReduceANumberToZero_1342 {
    public int numberOfSteps(int num) {
        int ans = 0;
        if (num == 0) return ans;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans++;
        }
        return ans;
    }

    public int numberOfStep_2(int num) {
        int res = 0;
        if (num == 0) return res;

        while (num != 0) {
            // In order to count steps when right shifting one digit
            // For odd: we will subtract and divide by 2, which takes 2 steps
            // For even: we just divide by 2, which takes 1 step
            res += ((num & 1) == 0) ? 1 : 2;
            num >>= 1;
        }
        return res - 1;
    }
}
