/**
 * HeronSqrt
 * 
 * Esta classe fornece uma implementação do método de Herão (também conhecido como método babilônico)
 * para calcular a raiz quadrada de um número real positivo por aproximação iterativa.
 * 
 * O algoritmo inicia com uma estimativa inicial e melhora essa estimativa até que a diferença
 * entre duas iterações consecutivas seja menor que uma tolerância definida.
 * 
 * O método approximateSqrt(double number, double guess) retorna a aproximação da raiz quadrada de `number`,
 * iniciando a partir da estimativa `guess`.
 * 
 * Exemplo de uso:
 *   double raiz = HeronSqrt.approximateSqrt(2, 1);
 *   System.out.println("√2 ≈ " + raiz);
 * 
 * Limitação:
 *   - O método funciona apenas para números positivos.
 *   - A precisão depende da constante TOLERANCE.
 */


public class HeronSqrt {

    private static final double TOLERANCE = 1e-9;

    public static double approximateSqrt(double number, double guess) {
        double nextGuess;

        while (true) {
            nextGuess = 0.5 * (guess + number / guess);

            if (Math.abs(nextGuess - guess) < TOLERANCE) {
                break;
            }

            System.out.println("-> " + nextGuess);
            guess = nextGuess;
        }

        return nextGuess;
    }
    
    public static void main(String[] args) {
        double number = 2;
        double initialGuess = 1;

        double result = approximateSqrt(number, initialGuess);
        System.out.println("√" + number + " ≈ " + result);
    }
    
}
