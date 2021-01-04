package Fight;

public class CountNumberswithUniqueDigits_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        int res = 0;
        while(n>=1){
            res = res + count(n);
            n--;
        }
        return res;
    }

    public int count(int digits) {
        if(digits == 1) return 10;
        int num = 1;
        for(int i = 1; i < digits; i++) {
            num *= (10 - i);
        }
        return num*9;
    }
}
