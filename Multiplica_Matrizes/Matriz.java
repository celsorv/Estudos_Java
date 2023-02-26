
public class Matriz {

    public static void main(String[] args) {

        int[][] A = new int[][]{{13, -3, -25, 20}, {-3, -16, -23, 18}, {20, -7, 12, -5}, {-22, 15, -4, 7}};
        int[][] B = new int[][]{{13, 10, 11, 12}, {13, 14, -23, 18}, {20, -7, 12, -11}, {-12, -13, -14, 7}};

        int[][] Z1 = multiplicaMatrizQuadrada(A, B);
        int[][] Z2 = multiplicaMatrizQuadradaRec(A, B);

        mostrarMatriz(Z1);
        System.out.println("-".repeat(20));
        mostrarMatriz(Z2);

    }


    public static int[][] multiplicaMatrizQuadrada(int[][] X, int[][] Y) {

        final int n = X[0].length;

        if(n != Y.length) throw new IllegalArgumentException("X.columns != Y.rows");

        int[][] Z = new int[n][n];  // Java: array de tipos primitivos são iniciados com zero por default

        for (int linha = 0; linha < n; linha++)

            for (int coluna = 0; coluna < n; coluna++)

                for (int k = 0; k < n; k++)
                    Z[ linha ][ coluna ] += X[ linha ][ k ] * Y[ k ][ coluna ];

        return Z;

    }


    public static int[][] multiplicaMatrizQuadradaRec(int[][] A, int[][] B) {
        return multiplicaMatrizQuadradaRec(A, B, 0, 0, 0, 0, A.length);
    }


    /**
     * Multiplicação de matriz quadrada pelo algoritmo de divisão e conquista.
     *
     *  <br />
     *     <p><b>SQUARE-MATRIX-MULTIPLY-RECURSIVE (A, B)</b></p>
     *  <br />
     * 	<p>n = A.rows</p>
     * 	<p>let Z be a new n x n matrix</p>
     * 	<br />
     * 	<p>if n == 1</p>
     * 	<p>&nbsp;&nbsp;z11 = a11 x b11</p>
     * 	<br />
     * 	<p>else partition A, B, and Z as in equations (4.9)</p>
     * 	<br />
     * 		<p>&nbsp;&nbsp;&nbsp;Z11 = SQUARE-MATRIX-MULTIPLY-RECURSIVE(A11, B11)</p>
     * 		    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+ SQUARE-MATRIX-MULTIPLY-RECURSIVE(A12, B21)</p>
     * 		<p>&nbsp;&nbsp;&nbsp;Z12 = SQUARE-MATRIX-MULTIPLY-RECURSIVE(A11, B12)</p>
     * 	        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+ SQUARE-MATRIX-MULTIPLY-RECURSIVE(A12, B22)</p>
     * 		<p>&nbsp;&nbsp;&nbsp;Z21 = SQUARE-MATRIX-MULTIPLY-RECURSIVE(A21, B11)</p>
     * 	        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+ SQUARE-MATRIX-MULTIPLY-RECURSIVE(A22, B21)</p>
     * 		<p>&nbsp;&nbsp;&nbsp;Z22 = SQUARE-MATRIX-MULTIPLY-RECURSIVE(A21, B12)</p>
     * 	        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+ SQUARE-MATRIX-MULTIPLY-RECURSIVE(A22, B22)</p>
     * 	<br />
     * 	return Z</p>
     * 	<br /><br />
     *
     * @param A     matriz quadrada nxn
     * @param B     matriz quadrada nxn
     * @param rowA
     * @param colA
     * @param rowB
     * @param colB
     * @param size
     * @return      matriz quadrada nxn com o resultado
     */
    public static int[][] multiplicaMatrizQuadradaRec(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB,  int size) {

        int[][] Z = new int[size][size];

        if (size == 1)
            Z[0][0] = A[rowA][colA] * B[rowB][colB];

        else {

            int[][] nA;
            int[][] nB;
            int newSize = size / 2;

            // Z11 = A11 * B11 + A12 * B21
            nA = multiplicaMatrizQuadradaRec(A, B, rowA, colA, rowB, colB, newSize);    // A11 * B11
            nB = multiplicaMatrizQuadradaRec(A, B, rowA, colA + newSize, rowB + newSize, colB, newSize); // A12 * B21
            adiciona(Z, nA, nB, 0, 0);      // C11

            // Z12 = A11 * B12 + A12 * B22
            nA = multiplicaMatrizQuadradaRec(A, B, rowA, colA, rowB, colB + newSize, newSize); // A11 * B12
            nB = multiplicaMatrizQuadradaRec(A, B, rowA, colA + newSize, rowB + newSize, colB + newSize, newSize); // A12 * B22
            adiciona(Z, nA, nB, 0, newSize);     // C12

            // Z21 = A21 * B11 + A22 * B21
            nA = multiplicaMatrizQuadradaRec(A, B, rowA + newSize, colA, rowB, colB, newSize); // A21 * B11
            nB = multiplicaMatrizQuadradaRec(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB, newSize); // A22 * B21
            adiciona(Z, nA, nB, newSize, 0);     // C21

            // Z22 = A21 * B12 + A22 * B22
            nA = multiplicaMatrizQuadradaRec(A, B, rowA + newSize, colA, rowB, colB + newSize, newSize); // A21 * B12
            nB = multiplicaMatrizQuadradaRec(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB + newSize, newSize); // A22 * B22
            adiciona(Z, nA, nB, newSize, newSize);    // C22

        }

        return Z;

    }


    /**
     * @param Z    Matriz de tamanho nxn a ser adicionada
     * @param A    matriz de tamanho n/2 x n/2 para somar
     * @param B    matriz de tamanho n/2 x n/2 para somar
     * @param rowZ A linha inicial da matriz Z
     * @param colZ A coluna inicial da matriz Z
     */
    private static void adiciona(int[][] Z, int[][] A, int[][] B, int rowZ, int colZ) {

        int n = A.length;

        for (int linha = 0; linha < n; linha++)

            for (int coluna = 0; coluna < n; coluna++)
                Z[linha + rowZ][coluna + colZ] = A[linha][coluna] + B[linha][coluna];

    }


    private static void mostrarMatriz(int[][] z) {

        for (int[] ints : z) {
            System.out.println();
            for (int anInt : ints) System.out.print(anInt + " ");
        }
        System.out.println();

    }

}
