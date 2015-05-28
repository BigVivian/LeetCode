package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定非负整数N，求出比N小的数中，素数的个数
 * 
 * 1.依次将2的倍数、3的倍数置为false<br>
 * 2.保存已知的素数 [超时]<br>
 * 
 * @author Vivian
 * 
 */
public class CountPrimes_204 {

	// 依次将2的倍数、3的倍数...置为false
	public int countPrimes2(int n) {
		if (n <= 1) {
			return 0;
		}

		boolean[] primes = new boolean[n];
		for (int i = 0; i <= n - 1; i++) {
			primes[i] = true;
		}

		primes[0] = false;
		primes[1] = false;

		for (int i = 2, limit = (int) Math.sqrt(n); i <= limit; i++) {
			if (primes[i]) {
				// j = i*i, i(i+1), i(i+2), ..., i(i+k)
				for (int j = i * i; j < n; j += i) {
					primes[j] = false;
				}
			}
		}

		// count
		int res = 0;
		for (int i = 0; i <= n - 1; i++) {
			if (primes[i]) {
				res++;
			}
		}

		return res;
	}

	// 将当前已知的素数保存在一个ArrayList中
	// 超时
	public int countPrimes(int n) {

		if (n <= 1) {
			return 0;
		}

		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);

		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				continue;
			}

			boolean isPrime = true;
			for (int j = 0; isPrime && j <= primeList.size() - 1; j++) {
				if (i % primeList.get(j) == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				primeList.add(i);
			}
		}

		return primeList.size();
	}

	public static void main(String[] args) {
		int n = 7;
		CountPrimes_204 test = new CountPrimes_204();
		int res = test.countPrimes2(n);

		System.out.println(res);
	}

}
