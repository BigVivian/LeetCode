package Fight;

public class CountofMatchesInTournament_1688 {
    int count = 0;
    public int numberOfMatches(int n) {
        if(n == 1) return count;
        while(n != 1) {
            count += n/2;
            n = n / 2 + n % 2;
        }
        return count;
    }
}