import java.util.Scanner;

public class MmcPeloMdc {

    // Método para calcular o MDC (Máximo Divisor Comum)
    public static int mdc(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mdc(b, a % b);
    }

    // Método para calcular o MMC (Mínimo Múltiplo Comum)
    public static int mmc(int a, int b) {
        return a * b / mdc(a, b);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ler dois números inteiros
        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = input.nextInt();
        System.out.print("Digite o segundo número inteiro: ");
        int num2 = input.nextInt();

        // Calcular o MMC dos dois números
        int result = mmc(num1, num2);

        // Mostrar o resultado
        System.out.println("O MMC de " + num1 + " e " + num2 + " é " + result + ".");

    }

}
