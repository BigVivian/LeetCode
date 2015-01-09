package Fight;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();

		int i;
		boolean flag = false;
		for (i = 0; i <= intervals.size() - 1; i++) {

			Interval tmp = intervals.get(i);
			if (tmp.start > newInterval.end) {
				res.add(newInterval);
				flag = true;
				break;
			} else if (tmp.end < newInterval.start) {
				res.add(tmp);
			} else {
				newInterval.start = Math.min(tmp.start, newInterval.start);
				newInterval.end = Math.max(tmp.end, newInterval.end);
			}

		}

		for (int j = i; j <= intervals.size() - 1; j++) {
			res.add(intervals.get(j));
		}
		if (!flag) {
			res.add(newInterval);
		}

		return res;
	}

	public class Interval {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
