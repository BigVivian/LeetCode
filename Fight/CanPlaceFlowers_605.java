package Fight;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] f, int n) {
        for(int i = 0; i < f.length && n > 0; i++) {
            if(f[i] == 0) {
                boolean pre = (i-1 < 0) || (i-1 >= 0 && f[i-1] == 0);
                boolean next = (i + 1 >= f.length) || (i+1 < f.length && f[i+1] == 0);
                if(pre && next) {
                    f[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }
}
