
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] A = new int[]{2, 8, 10, 3, 6, 7, 4, 5, 1, 9, 11, 19, 15, 20, 13, 18, 14, 12, 17, 16};

        System.out.println(Arrays.toString(A));

        sort(A);

        System.out.println(Arrays.toString(A));

    }

    public static void sort(int[] A) {
        sort(A, 0, A.length - 1);
    }

    private static void sort(int[] A, int low, int high) {

        if (low >= high) return;

        int left, right;
        {
            int[] partitionIndex = partition(A, low, high);
            left = partitionIndex[0];
            right = partitionIndex[1];
        }

        sort(A, low, right);
        sort(A, left, high);

    }

    private static int[] partition(int[] A, int low, int high) {

        int left = low, right = high;
        int pivot = A[(low + high) / 2];
        //int pivot = A[low];
        //int pivot = A[high];

        while (left <= right) {

            while (A[left] < pivot) left++;
            while (A[right] > pivot) right--;

            if (left > right) break;

            swap(A, left, right);

            left++;
            right--;

        }

        return new int[]{left, right};

    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
