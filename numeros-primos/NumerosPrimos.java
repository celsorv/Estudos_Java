import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumerosPrimos {

    // Método que retorna uma lista de números primos até um determinado limite usando o crivo de Eratóstenes
    public static List<Integer> obterPrimosCrivo(int limite) {

        // Inicialmente, assume-se que todos os números são primos
        boolean[] numeros = new boolean[limite + 1];
        Arrays.fill(numeros, true);

        // O número 0 e o 1 não são primos
        numeros[0] = false;
        numeros[1] = false;

        // Percorre todos os números até o limite, marcando como não primos os múltiplos de cada número
        for (int i = 2; i <= limite; i++)
            if (numeros[i])
                for (int j = i * i; j <= limite; j += i)
                    numeros[j] = false;

        // Cria uma lista com todos os números primos encontrados
        List<Integer> primos = new ArrayList<Integer>();
        for (int i = 2; i <= limite; i++)
            if (numeros[i])
                primos.add(i);

        return primos;
    }

    // Método que retorna uma lista de números primos até um determinado limite usando divisões sucessivas
    public static List<Integer> obterPrimosDivisao(int limite) {

        List<Integer> primos = new ArrayList<Integer>();

        // Percorre todos os números até o limite, testando se cada um é primo
        for (int i = 2; i <= limite; i++) {
            boolean ehPrimo = true;

            // Testa se o número é divisível por algum número menor que ele (exceto 1)
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    ehPrimo = false;
                    break;
                }
            }

            // Se o número é primo, adiciona-o à lista
            if (ehPrimo)
                primos.add(i);

        }

        return primos;
    }

    // Método que determina se um número é primo usando o algoritmo AKS
    public static boolean ehPrimoAKS(int n) {

        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;

        final double sqrtN = Math.sqrt(n);

        // Calcula o valor de r
        int r = 2;
        while (r <= sqrtN) {
            if (n % r == 0) return false;
            r++;
        }

        // Calcula o valor de a
        for (int a = 2; a <= sqrtN; a++) {

            BigInteger pow = BigInteger.valueOf(a).pow(n);
            BigInteger subtract = pow.subtract(BigInteger.valueOf(a));
            BigInteger gcd = subtract.gcd(BigInteger.valueOf(n));

            if (!gcd.equals(BigInteger.ONE)) return false;
        }

        return true;
    }

    public static boolean isPrimoMillerRabin(int n, int k) {

        // Casos especiais
        if (n <= 1 || (n != 2 && n % 2 == 0)) {
            return false;
        }

        // Escreve (n - 1) como 2^r * d, onde d é ímpar
        int r = 0;
        int d = n - 1;
        while (d % 2 == 0) {
            r++;
            d /= 2;
        }

        // Testa o número k vezes
        for (int i = 0; i < k; i++) {
            int a = 2 + (int)(Math.random() * (n - 3)); // Escolhe um número aleatório entre 2 e n - 2
            int x = modPow(a, d, n); // Calcula a^d mod n

            // Se x é 1 ou n - 1, é provavelmente primo
            if (x == 1 || x == n - 1) {
                continue;
            }

            // Aplica a^d, a^(2*d), a^(4*d), ..., a^(2^(r-1)*d)
            for (int j = 1; j < r; j++) {
                x = modPow(x, 2, n); // Calcula x^2 mod n
                if (x == n - 1) { // Se x é n - 1, é provavelmente primo
                    break;
                }
            }

            if (x != n - 1) { // Se x não é n - 1, n é composto
                return false;
            }
        }

        // Se o número passou em todos os testes, é provavelmente primo
        return true;
    }

    // Calcula a^b mod m usando exponenciação modular
    private static int modPow(int a, int b, int m) {

        int res = 1;
        a %= m;

        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b /= 2;
        }

        return res;

    }

    public static void main(String[] args) {
        int limite = 30;

        // Testa o método obterPrimosCrivo
        List<Integer> primosCrivo = obterPrimosCrivo(limite);
        System.out.println("Primos até " + limite + " usando o crivo de Eratóstenes: " + primosCrivo);

        // Testa o método obterPrimosDivisao
        List<Integer> primosDivisao = obterPrimosDivisao(limite);
        System.out.println("Primos até " + limite + " usando divisões sucessivas: " + primosDivisao);

        // Testa o método AKS
        for (int i = 1; i <= limite; i++) {
            System.out.println(i + " é primo? " + ehPrimoAKS(i));
        }

        // Testa o método isPrimoMillerRabin
        int numero = 31;
        int iteracoes = 5;
        boolean ehPrimo = isPrimoMillerRabin(numero, iteracoes);
        System.out.println(numero + " é primo segundo o algoritmo de Miller-Rabin com " + iteracoes + " iterações: " + ehPrimo);

    }

}
