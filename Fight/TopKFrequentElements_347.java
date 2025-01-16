package Fight;

import java.util.*;

public class TopKFrequentElements_347 {

    /**
     * 使用PriorityQueue根据数字出现频率构造大根堆，再输出前K个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((p, q) -> q.getValue() - p.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }

    /**
     * 构造小顶堆。如果当前堆小于k个元素，则直接插入。
     * 比较当前元素和堆顶元素，若堆顶元素出现频率小，则删除堆顶元素，插入当前元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((p, q) -> p.getValue() - q.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }

        int idx = 0;
        int[] res = new int[k];
        while(!queue.isEmpty()) {
            res[idx++] = queue.poll().getKey();
        }

        return res;
    }

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[len + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (bucket[value] != null) {
                bucket[value].add(entry.getKey());
            } else {
                bucket[value] = new ArrayList<>();
                bucket[value].add(entry.getKey());
            }
        }

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (int i = bucket.length - 1; i >= 0 && cnt < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                cnt += bucket[i].size();
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 solution = new TopKFrequentElements_347();
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3};
        int[] res = solution.topKFrequent2(nums, 2);
        Arrays.stream(res).forEach(System.out::println);
    }
}
