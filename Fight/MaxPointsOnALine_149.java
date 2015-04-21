package Fight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一组点，求这组点在一条线上的最大的数量
 * 
 * 斜率存在三种情况<br>
 * 1.x1 = x2 <br>
 * 2.y1 = y2 <br>
 * 3.x1!=x2 & y1 != y2 <br>
 * 
 * @author Vivian
 * 
 */
public class MaxPointsOnALine_149 {
	public int maxPoints(Point[] points) {

		if (points.length == 0) {
			return 0;
		}
		if (points.length < 3) {
			return points.length;
		}

		int max = 0;

		for (int i = 0; i <= points.length - 2; i++) {
			int same = 0;
			int xCount = 0;
			Map<Double, Integer> map = new HashMap<Double, Integer>();

			for (int j = i + 1; j <= points.length - 1; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
				} else if (points[i].x == points[j].x) {
					xCount++;
				} else {
					double k = (double) (points[i].y - points[j].y)
							/ (points[i].x - points[j].x);
					if (points[i].y == points[j].y) {
						k = 0.0;
					}

					if (map.containsKey(k)) {
						int value = map.get(k) + 1;
						map.put(k, value);
					} else {
						map.put(k, 1);
					}
				}
			}
			same++;
			xCount += same;

			if (xCount > max) {
				max = xCount;
			}

			Iterator<Map.Entry<Double, Integer>> iterator = map.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Double, Integer> entry = iterator.next();
				max = entry.getValue() + same > max ? entry.getValue() + same
						: max;
			}
		}

		return max;
	}

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		// Point[] points = new Point[5];
		// points[0] = new Point(-4, -4);
		// points[1] = new Point(-8, -582);
		// points[2] = new Point(-3, 3);
		// points[3] = new Point(-9, -651);
		// points[4] = new Point(9, 591);
		// Point[] points = new Point[3];
		// points[0] = new Point(0, 0);
		// points[1] = new Point(1, 1);
		// points[2] = new Point(-1, 1);
		Point[] points = new Point[10];
		points[0] = new Point(84, 250);
		points[1] = new Point(0, 0);
		points[2] = new Point(-1, 1);
		points[3] = new Point(1, 0);
		points[4] = new Point(0, -70);
		points[5] = new Point(0, -70);
		points[6] = new Point(1, -1);
		points[7] = new Point(21, 10);
		points[8] = new Point(42, 90);
		points[9] = new Point(-42, -230);

		MaxPointsOnALine_149 test = new MaxPointsOnALine_149();
		int max = test.maxPoints(points);

		System.out.println(max);
	}
}
