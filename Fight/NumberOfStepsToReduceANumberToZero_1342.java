package Fight;

public class NumberOfStepsToReduceANumberToZero_1342 {
    public int numberOfSteps (int num) {
        int ans = 0;
        if(num == 0) return ans;

        while(num != 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans++;
        }
        return ans;
    }
}
