package Fight;

public class FloodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];

        int target = image[sr][sc];
        flood(image, visited, sr, sc, row, col, target, newColor);

        return image;
    }

    public void flood(int[][] image, boolean[][] visited, int sr, int sc, int rowCount, int colCount, int target, int newColor) {
        if(sr < 0 || sr >= rowCount || sc < 0 || sc >= colCount) return;
        if(visited[sr][sc]) return;
        if(image[sr][sc] != target) {
            visited[sr][sc] = true;
            return;
        }
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        flood(image, visited, sr, sc-1, rowCount, colCount, target, newColor);
        flood(image, visited, sr, sc+1, rowCount, colCount, target, newColor);
        flood(image, visited, sr-1, sc, rowCount, colCount, target, newColor);
        flood(image, visited, sr+1, sc, rowCount, colCount, target, newColor);
    }
}
