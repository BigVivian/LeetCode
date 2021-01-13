package Fight;

import java.util.Arrays;

public class RichestCustomerWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
    }
}
