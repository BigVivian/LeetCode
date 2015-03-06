package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose there are N elements and they range from A to B.
 * 
 * Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
 * 
 * Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we
 * will have at most num = (B - A) / len + 1 of bucket
 * 
 * for any number K in the array, we can easily find out which bucket it belongs
 * by calculating loc = (K - A) / len and therefore maintain the maximum and
 * minimum elements in each bucket.
 * 
 * Since the maximum difference between elements in the same buckets will be at
 * most len - 1, so the final answer will not be taken from two elements in the
 * same buckets.
 * 
 * For each non-empty buckets p, find the next non-empty buckets q, then q.min -
 * p.max could be the potential answer to the question. Return the maximum of
 * all those values.
 * 
 */
public class MaximumGap_164 {
	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int tmp : num) {
			if (tmp < min) {
				min = tmp;
			}
			if (tmp > max) {
				max = tmp;
			}
		}

		int len = num.length;
		int bucketSize = (int) Math.ceil((max - min) / (len - 1));
		bucketSize = (bucketSize == 0) ? 1 : bucketSize;
		int bucketNum = ((max - min) / bucketSize) + 1;

		// init
		List<Bucket> buckets = new ArrayList<Bucket>(bucketNum);
		for (int i = 0; i <= bucketNum; i++) {
			buckets.add(new Bucket());
		}

		// put in the bucket
		for (int tmpNum : num) {
			int k = (tmpNum - min) / bucketSize;

			Bucket kthBucket = buckets.get(k);

			kthBucket.size += 1;
			if (tmpNum < kthBucket.min) {
				kthBucket.min = tmpNum;
			}
			if (tmpNum > kthBucket.max) {
				kthBucket.max = tmpNum;
			}

		}

		// cal the max gap
		int maxGap = 0;
		for (int i = 0; i <= bucketNum - 1; i++) {
			while (buckets.get(i).size == 0) {
				i++;
			}

			int j = i + 1;
			while (j <= buckets.size() - 1 && buckets.get(j).size == 0) {
				j++;
			}

			if (j <= buckets.size() - 1) {
				// System.out.println("min[" + i + "]= " + buckets.get(i).min
				// + ", max[" + i + "]= " + buckets.get(i).max);
				// System.out.println("min[" + j + "]= " + buckets.get(j).min
				// + ", max[" + j + "]= " + buckets.get(j).max);
				maxGap = Math.max(maxGap, buckets.get(j).min
						- buckets.get(i).max);
			}
			i = j - 1;
		}

		return maxGap;
	}

	static class Bucket {
		public int min;
		public int max;
		public int size;

		public Bucket() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
			this.size = 0;
		}

	}

	public static void main(String[] args) {
		int[] num = { 23909, 19622, 13107, 10834, 11667, 28450, 30959, 7877,
				6015, 4816, 17362, 3482, 2247, 230, 16899, 3818, 4461, 16494,
				31033, 290, 1918, 15188, 10109, 30387, 3570, 14782, 8496,
				11275, 724, 10139, 20559, 6597, 6307, 22655, 14582, 30492,
				7927, 15790, 10019, 16550, 15975, 17015, 27069, 5951, 11179,
				17091, 16085, 2882, 5630, 20461, 21803, 10240, 21702, 14292,
				1780, 21354, 6263, 559, 12762, 22033, 8885, 22561, 20549, 8017,
				18873, 2574, 14297, 6600, 19189, 10156, 8512, 9229, 12539,
				24157, 23849, 415, 20635, 4540, 23184, 22556, 8523 };
		MaximumGap_164 test = new MaximumGap_164();
		int res = test.maximumGap(num);
		System.out.println(res);
	}

}
