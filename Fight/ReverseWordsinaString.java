package Fight;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		for (int i = 0; i <= s.length() - 1; i++) {
			if (s.charAt(i) == ' ') {
				if (tmp.length() == 0) {
					continue;
				} else {
					if (sb.length() != 0) {
						sb.insert(0, " ");
					}
					sb.insert(0, tmp);
					tmp = new StringBuilder();
				}
			} else {
				tmp.append(s.charAt(i));
			}
		}
		if (tmp.length() != 0) {
			if (sb.length() != 0) {
				sb.insert(0, " ");
			}
			sb.insert(0, tmp);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseWordsinaString test = new ReverseWordsinaString();

		String res = test.reverseWords("the sky is blue");
		System.out.println(res);
	}

}
