
import java.util.Arrays;

public class MergeSortAlgorithm {

    public static void main(String[] args) {

        int[] A = new int[]{10, 6, 8, 5, 7, 3, 4};
        mergeSort(A);

        System.out.println(Arrays.toString(A));

    }

    public static void mergeSort(int[] A) {
        mergeSort(A, A.length);
    }

    private static void mergeSort(int[] A, int n) {

        if (n < 2) return;

        int mid = n / 2;

        int[] L = new int[mid];
        int[] R = new int[n - mid];

        for (int i = 0; i < mid; i++)
            L[i] = A[i];

        for (int i = mid; i < n; i++)
            R[i - mid] = A[i];

        mergeSort(L, mid);
        mergeSort(R, n - mid);

        merge(A, L, R, mid, n - mid);

    }

    private static void merge(int[] A, int[] L, int[] R, int nL, int nR) {

        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR)
            if (L[i] <= R[j])
                A[k++] = L[i++];
            else
                A[k++] = R[j++];

        while (i < nL) A[k++] = L[i++];

        while (j < nR) A[k++] = R[j++];

    }

}
