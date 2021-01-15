package Fight;

import java.util.*;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            List<Integer> list = map.computeIfAbsent(key, k -> new LinkedList<>());
            list.add(i);
            if(list.size() == key) {
                result.add(list);
                map.put(key, null);
            }
        }
        return result;
    }
}
