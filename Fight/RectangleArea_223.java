package Fight;

/**
 * LeetCode-223 / Rectangle Area / get the total area of two rectangles
 * Be careful about the border
 */
public class RectangleArea_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        // one of the rectangle is point
        if (area1 == 0) {
            return area2;
        }
        if (area2 == 0) {
            return area1;
        }

        // do not have overlapped area
        if (C <= E || G <= A || D <= F || H <= B) {
            return area1 + area2;
        }

        //  one contains the other
        if (contains(A, B, C, D, E, F, G, H)) {
            return Math.max(area1, area2);
        } else {
            // overlap
            int overlap = getOverlap(A, C, E, G) * getOverlap(B, D, F, H);
            return area1 + area2 - overlap;
        }

    }

    private boolean contains(int A, int B, int C, int D, int E, int F, int G, int H) {

        if (((A <= E) && (B <= F) && (C >= G) && (D >= H)) || ((E <= A) && (F <= B) && (G >= C) && (H >= D)))
            return true;
        else
            return false;
    }

    private int getOverlap(int a, int b, int c, int d) {

        // overlaps
        if (c <= b && c >= a && b <= d) {
            return Math.abs(b - c);
        }
        if (d <= b && d >= a && c <= a) {
            return Math.abs(d - a);
        }

        // contains
        if ((a <= c && d <= b)) {
            return Math.abs(d - c);
        }
        if (c <= a && b <= d) {
            return Math.abs(b - a);
        }

        return -1;
    }

    public static void main(String[] args) {

        RectangleArea_223 test = new RectangleArea_223();
        int res = test.computeArea(-3, -3, 3, -1, -2, -2, 2, 2);

        System.out.print(res);
    }
}
