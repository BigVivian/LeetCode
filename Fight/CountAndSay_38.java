package Fight;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        String current = "1";
        StringBuffer next = new StringBuffer();
        char lastChar = ' ';
        char curChar;
        int charCount = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= current.length() - 1; j++) {
                curChar = current.charAt(j);

                if (j == 0) {
                    lastChar = curChar;
                    charCount = 1;
                }else{
                    if (lastChar == curChar) {
                        charCount++;
                    }else{
                        // append the count and char
                        next.append(charCount);
                        next.append(lastChar);

                        lastChar = curChar;
                        charCount = 1;
                    }
                }
            }
            // append the last count and char
            next.append(charCount);
            next.append(lastChar);

            current = next.toString();
            next = new StringBuffer();
        }


        return current;
    }

    public static void main(String[] args) {
        CountAndSay_38 test = new CountAndSay_38();
        String res = test.countAndSay(5);
        System.out.print(res);
    }
}
