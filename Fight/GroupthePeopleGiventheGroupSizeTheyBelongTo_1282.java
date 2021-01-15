package Fight;

import java.util.*;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            if(map.containsKey(key)) {
                List<Integer> list = map.get(key);
                list.add(i);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(key, list);
            }
        }

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int i = 0; i < list.size() / key; i++) {
                List<Integer> group = new LinkedList<>();
                for(int j = 0; j < key; j++) {
                    group.add(list.get(i*key+j));
                }
                result.add(group);
            }
        }
        return result;
    }
}
