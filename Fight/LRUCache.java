package Fight;

import java.util.HashMap;
import java.util.Map;

// 超时
public class LRUCache {

	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	private int capacity = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			int tmpVal = cache.get(key) + 1;
			cache.put(key, tmpVal);
			return cache.get(key);
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {

		if (cache.size() < capacity) {
			cache.put(key, value);
		} else {
			removeLeastUsed();
			cache.put(key, value);
		}
	}

	private void removeLeastUsed() {
		int minVal = Integer.MAX_VALUE;
		int minKey = 0;
		for (int tmpKey : cache.keySet()) {
			if (cache.get(tmpKey) < minVal) {
				minVal = cache.get(tmpKey);
				minKey = tmpKey;
			}
		}
		cache.remove(minKey);
	}

	public static void main(String[] args) {

	}

}
