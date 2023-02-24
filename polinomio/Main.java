public class Main {

    public static void main(String[] args) {

        int[] A = new int[]{5, 2, 10};

        int r1 = polinomio(A, 2, 2);
        int r2 = polinomioRecursivo(A, 2, 2);

        System.out.println(r1);
        System.out.println(r2);

    }

    /**
     * @param A int[]: valores dos coeficientes A (e.g. 10x² + 2x + 5 -> polinomio(new int[]{5, 2, 10}, 2, x)
     * @param m int: grau do polinômio
     * @param x int: valor de x para o cálculo
     * @return int: resultado
     */
    private static int polinomio(int[] A, int m, int x) {

        int f = A[0];
        int xn = 1;

        if (m == 0) return f;

        for (int i = 1; i <= m; i++) {
            xn = xn * x;
            f = f +  A[i] * xn;
        }

        return f;

    }

    /**
     * @param A int[]: valores dos coeficientes A (e.g. 10x² + 2x + 5 -> polinomio(new int[]{5, 2, 10}, 2, x)
     * @param m int: grau do polinômio
     * @param x int: valor de x para o cálculo
     * @return int: resultado
     */
    private static int polinomioRecursivo(int[] A, int m, int x) {

        if (m == 0) return A[0];

        return polinomioRecursivo(A, m - 1, x) + A[m] * (int) Math.pow(x, m);

    }

}
