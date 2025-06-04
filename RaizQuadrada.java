/**
 * Calcula a raiz quadrada de um número utilizando o método de Newton-Raphson.
 * 
 * O método consiste em fazer um chute inicial e ir refinando esse chute até que
 * o erro seja menor que uma precisão desejada (epsilon).
 * 
 * A cada iteração, o programa imprime:
 * - o valor de epsilon
 * - o valor do erro atual (|x² - n|)
 * - o valor atual da raiz quadrada aproximada.
 */
public class RaizQuadrada {

    public static double raizQuadrada(double n) {
        double x = n; // chute inicial: o próprio número
        double epsilon = 1e-10; // precisão desejada

        String strEpsilon = String.format("%.20f", epsilon);
        
        // Enquanto a diferença entre x² e n for maior que epsilon
        while (Math.abs(x * x - n) > epsilon) {

            double v = Math.abs(x * x - n); // erro atual

            // Refinamos o chute usando a fórmula de Newton-Raphson
            x = 0.5 * (x + n / x);
            
            System.out.println("epsilon........: " + strEpsilon);
            System.out.println("abs(x * x - n).: " + v);
            System.out.println("Raiz quadrada..: " + String.format("%.20f", x));
            System.out.println();
        }

        return x;
    }

    public static void main(String[] args) {
        double numero = 2.0;
        double resultado = raizQuadrada(numero);

        System.out.println("A raiz quadrada de " + numero + " é aproximadamente: " + resultado);
    }
}
