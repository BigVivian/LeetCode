package Fight;

/**
 * 冒泡排序，稳定排序
 *
 * 最好时间：O(n),加入标志位后
 * 最坏时间：O(n^2)
 * 平均时间：O(n^2)
 *
 */
public class BubbleSort {

    // this is Bubble sort
    public void sort(int[] A) {
        boolean hasChange = true;

        for (int i = 0; i <= A.length - 1 && hasChange; i++) {

            hasChange = false;

            for (int j = 0; j <= A.length - 2 - i; j++) {
                // swap
                if (A[j] > A[j + 1]) {
                    int tmp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = tmp;
                    hasChange = true;
                }
            }
        }
    }

    // this is no Bubble sort...
    public void noSort(int[] A) {

        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = i+1; j <= A.length - 1; j++) {
                if(A[i] > A[j]){
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = { 5,4,3,2,1};
        BubbleSort test = new BubbleSort();
       // test.sort(A);
        test.noSort(A);

        for (int tmp : A) {
            System.out.print(tmp + " ");
        }
    }
}
