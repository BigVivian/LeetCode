package Fight;

import java.util.HashMap;
import java.util.Map;

// 1.小心边界的问题
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {

		int flag = 1;
		if ((numerator > 0 && denominator < 0)
				|| (numerator < 0 && denominator > 0)) {
			flag = 0;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(flag == 0 ? "-" : "");

		long num = Math.abs(numerator);
		long de = Math.abs(denominator);
		Map<Long, Long> map = new HashMap<Long, Long>();

		sb.append(Math.abs(num / de));

		long count = 0;
		long tmpRemainder = Math.abs(num % de);
		map.put(tmpRemainder, count++);

		if (tmpRemainder == 0) {
			return sb.toString();
		} else {
			sb.append(".");
		}

		num = tmpRemainder * 10;
		while (true) {
			sb.append(Math.abs(num / de));
			tmpRemainder = Math.abs(num % de);

			if (map.containsKey(tmpRemainder) || tmpRemainder == 0) {
				break;
			} else {
				map.put(tmpRemainder, count++);
			}

			num = tmpRemainder * 10;
		}

		if (map.containsKey(tmpRemainder)) {
			long index = map.get(tmpRemainder);

			sb.insert((int) (sb.indexOf(".") + index + 1), "(");
			sb.append(")");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		FractiontoRecurringDecimal test = new FractiontoRecurringDecimal();
		// 3,22 10,2 1,2 1,6 -50,8 8,-12
		String res = test.fractionToDecimal(1, 5);
		res = test.fractionToDecimal(-2147483648, -1999);
		System.out.println(res);
	}
}
