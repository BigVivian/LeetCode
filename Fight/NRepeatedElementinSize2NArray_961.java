package Fight;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray_961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> map = new HashSet<>();
        for(int a: A) {
            if(map.contains(a)) {
                return a;
            } else {
                map.add(a);
            }
        }
        return -1;
    }
}
