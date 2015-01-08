package Fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.注意添加转义符 "."是特殊字符。
 * 
 * 2.同样的，对于字符"|","*","+"都得加上转义字符，前面加上"\\"。
 * 
 * 3.而如果是"\"，那么就得写成"\\\\"。
 * 
 * 4.如果一个字符串中有多个分隔符，可以用"|"作为连字符。
 **/
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		List<String> version1Revision = null;
		if (version1.contains(".")) {
			version1Revision = new ArrayList<String>(Arrays.asList(version1
					.split("\\.")));
		} else {
			version1Revision = new ArrayList<String>();
			version1Revision.add(version1);
		}
		List<String> version2Revision = null;
		if (version2.contains(".")) {
			version2Revision = new ArrayList<String>(Arrays.asList(version2
					.split("\\.")));
		} else {
			version2Revision = new ArrayList<String>();
			version2Revision.add(version2);
		}

		for (int i = 0, j = 0; i <= version1Revision.size() - 1
				|| j <= version2Revision.size() - 1; i++, j++) {

			if (i > version1Revision.size() - 1) {
				version1Revision.add("0");
			}
			if (j > version2Revision.size() - 1) {
				version2Revision.add("0");
			}

			if (Integer.valueOf(version1Revision.get(i)) < Integer
					.valueOf(version2Revision.get(j))) {
				return -1;
			} else if (Integer.valueOf(version1Revision.get(i)) > Integer
					.valueOf(version2Revision.get(j))) {
				return 1;
			} else {
				continue;
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		int res = test.compareVersion("1.0.0", "1.0.1");
		System.out.println(res);
	}

}
