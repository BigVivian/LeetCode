package Fight;

import java.util.HashSet;
import java.util.Set;

/**
 * 求数组中，连续的最长子数组<br>
 * 如：给定[100, 4, 200, 1, 3, 2],则最长的连续子数组为[1, 2, 3, 4] <br>
 * 
 * 使用HashSet保存数组中的所有数，依次遍历
 * 
 * @author Vivian
 * 
 */
public class LongestConsecutiveSequence_128 {
	public int longestConsecutive(int[] num) {
		int max = 0;

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i <= num.length - 1; i++) {
			set.add(num[i]);
		}

		for (int i = 0; i <= num.length - 1 && !set.isEmpty(); i++) {
			int count = 1;

			// 取出所有比num[i]大的数
			int tmpNum = num[i] + 1;
			while (set.contains(tmpNum)) {
				count++;
				set.remove(tmpNum);
				tmpNum++;
			}

			// 取出所有比num[i]小的数
			tmpNum = num[i] - 1;
			while (set.contains(tmpNum)) {
				count++;
				set.remove(tmpNum);
				tmpNum--;
			}

			max = count > max ? count : max;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] num = { -1, 0, 1 };
		LongestConsecutiveSequence_128 test = new LongestConsecutiveSequence_128();
		int res = test.longestConsecutive(num);
		System.out.println(res);
	}

}
