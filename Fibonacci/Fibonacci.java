public class Fibonacci {

    // constante usada no método usando fórmula
    private static final double SQUARE_ROOT_OF_FIVE = Math.sqrt(5);

    // armazena as soluções já calculadas no método Top-Down
    private static final double[] cache = new double[101];

    public static double FibonacciNaturalRecursion(int n) {
        if (n <= 1) return n;
        return FibonacciNaturalRecursion(n - 1) + FibonacciNaturalRecursion(n - 2);
    }

    public static double fibonacciTopDown(int n) {

        if (n <= 1) return n;

        // verifica se a solução para este subproblema já foi calculada e armazenada em cache
        if (cache[n] != 0) {
            return cache[n];
        }

        // calcula a solução para este subproblema e a armazena em cache
        double result = fibonacciTopDown(n-1) + fibonacciTopDown(n-2);
        cache[n] = result;

        return result;

    }

    public static double fibonacciBottomUp(int n) {

        if (n <= 1) return n;

        double fibPrev = 0; // caso base 0
        double fib = 1;     // caso base 1

        for (int i = 2; i <= n; i++) {
            double fibNext = fib + fibPrev;
            fibPrev = fib;
            fib = fibNext;
        }

        return fib;

    }

    public static double fibonacciFormulaBased(int n) {
        return (Math.pow(1 + SQUARE_ROOT_OF_FIVE, n) - Math.pow(1 - SQUARE_ROOT_OF_FIVE, n)) / (Math.pow(2, n) * SQUARE_ROOT_OF_FIVE);
    }

    public static void main(String[] args) {

        for (int n = 0; n <= 100; n++) {

            //double res1 = FibonacciNaturalRecursion(n);
            double res1 = fibonacciTopDown(n);
            double res2 = fibonacciBottomUp(n);
            double res3 = fibonacciFormulaBased(n);

            System.out.printf("fib(%03d): %f -- %f -- %f%n", n, res1, res2, res3);
        }

    }

}
