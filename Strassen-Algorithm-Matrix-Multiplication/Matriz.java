
public class Matriz {

    public static void main(String[] args) {

        int n = 4;

        int[][] A = new int[][]{{13, -3, -25, 20}, {-3, -16, -23, 18}, {20, -7, 12, -5}, {-22, 15, -4, 7}};
        int[][] B = new int[][]{{13, 10, 11, 12}, {13, 14, -23, 18}, {20, -7, 12, -11}, {-12, -13, -14, 7}};

        int[][] Z = multiplicar(A, B);

        imprimir(Z);

    }

    public static int[][] multiplicar(int[][] A, int[][] B) {

        int n = A.length;

        int[][] Z = new int[n][n];

        if (n == 1)
            Z[0][0] = A[0][0] * B[0][0];

        else {

            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Divide matriz A em 4 metades
            dividir(A, A11, 0, 0);
            dividir(A, A12, 0, n / 2);
            dividir(A, A21, n / 2, 0);
            dividir(A, A22, n / 2, n / 2);

            // Divide matriz B em 4 metades
            dividir(B, B11, 0, 0);
            dividir(B, B12, 0, n / 2);
            dividir(B, B21, n / 2, 0);
            dividir(B, B22, n / 2, n / 2);

            // M1 = (A1 + A3) X (B1 + B2)
            int[][] M1 = multiplicar(adicionar(A11, A22), adicionar(B11, B22));

            // M2 = (A2 - A4) X (B3 + B4)
            int[][] M2 = multiplicar(adicionar(A21, A22), B11);

            // M3 = (A1 - A4) X (B1 + A4)
            int[][] M3 = multiplicar(A11, subtrair(B12, B22));

            // M4 = A1 X (B2 - B4)
            int[][] M4 = multiplicar(A22, subtrair(B21, B11));

            // M5 = (A3 + A4) X B1
            int[][] M5 = multiplicar(adicionar(A11, A12), B22);

            // M6 = (A1 + A2) X B4
            int[][] M6 = multiplicar(subtrair(A21, A11), adicionar(B11, B12));

            // M7 = A4 X (B3 - B1)
            int[][] M7 = multiplicar(subtrair(A12, A22), adicionar(B21, B22));

            // P = M2 X M3 - M6 - M7
            int[][] C11 = adicionar(subtrair(adicionar(M1, M4), M5), M7);

            // Q = M4 + M6
            int[][] C12 = adicionar(M3, M5);

            // R = M5 + M7
            int[][] C21 = adicionar(M2, M4);

            // S = M1 - M3 - M4 - M5
            int[][] C22 = adicionar(subtrair(adicionar(M1, M3), M2), M6);

            unir(C11, Z, 0, 0);
            unir(C12, Z, 0, n / 2);
            unir(C21, Z, n / 2, 0);
            unir(C22, Z, n / 2, n / 2);

        }

        return Z;

    }

    // Subtração de duas matrizes
    public static int[][] subtrair(int[][] A, int[][] B) {

        int n = A.length;

        int[][] C = new int[n][n];

        for (int linha = 0; linha < n; linha++)

            for (int coluna = 0; coluna < n; coluna++)

                C[linha][coluna] = A[linha][coluna] - B[linha][coluna];

        return C;

    }

    // Soma de duas matrizes
    public static int[][] adicionar(int[][] A, int[][] B) {

        int n = A.length;

        int[][] C = new int[n][n];

        for (int linha = 0; linha < n; linha++)

            for (int coluna = 0; coluna < n; coluna++)

                C[linha][coluna] = A[linha][coluna] + B[linha][coluna];

        return C;

    }

    // Divide a matriz pai em matrizes filhas
    public static void dividir(int[][] P, int[][] C, int linhaB, int colunaB) {

        int n = C.length;

        for (int linhaC = 0, linhaP = linhaB; linhaC < n; linhaC++, linhaP++)

            for (int colunaC = 0, colunaP = colunaB; colunaC < n; colunaC++, colunaP++)

                C[linhaC][colunaC] = P[linhaP][colunaP];

    }

    // Une as matrizes filhas na matriz pai
    public static void unir(int[][] C, int[][] P, int linhaB, int colunaB) {

        int n = C.length;

        for (int linhaC = 0, linhaP = linhaB; linhaC < n; linhaC++, linhaP++)

            for (int colunaC = 0, colunaP = colunaB; colunaC < n; colunaC++, colunaP++)

                P[linhaP][colunaP] = C[linhaC][colunaC];

    }

    private static void imprimir(int[][] Z) {

        for (int[] ints : Z) {
            System.out.println();
            for (int anInt : ints) System.out.print(anInt + " ");
        }
        System.out.println();

    }

}
