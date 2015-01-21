package Fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * sort and merge
 * 
 * @author Vivian
 * 
 */
public class MergeIntervals_56 {
	public List<Interval> merge(List<Interval> intervals) {

		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		List<Interval> res = new ArrayList<Interval>();
		Interval current = null;
		for (int i = 0; i <= intervals.size() - 1; i++) {
			Interval tmp = intervals.get(i);
			if (current == null) {
				current = tmp;
			} else {
				if (tmp.start <= current.end) {
					current.end = Math.max(current.end, tmp.end);
				} else {
					res.add(current);
					current = tmp;
				}
			}
		}
		if (current != null) {
			res.add(current);
		}
		return res;
	}

	// for (int i = 0; i <= intervals.size() - 2; i++) {
	// for (int j = i; j <= intervals.size() - 1; j++) {
	// if (intervals.get(i).start > intervals.get(j).start) {
	// swap(intervals, i, j);
	// }
	// }
	// }
	// private void swap(List<Interval> list, int i, int j) {
	// Interval tmp = list.get(j);
	// list.set(j, list.get(i));
	// list.set(i, tmp);
	// }

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
