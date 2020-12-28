package Fight;

public class CountSortedVowelStrings_1641 {
    public int countVowelStrings(int n) {
        return (n+1) * (n+2) * (n+3) * (n+4)/24;
    }

    public int countVowelStrings_2(int n) {
        int[][] dp = new int[n+1][6];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                dp[i][j] = dp[i][j-1] + (i == 1? 1 : dp[i-1][j]);
            }
        }
        return dp[n][5];
    }
}
