import java.util.*;

public class MMcPelaFatoracao {

    // Função para obter os fatores primos de um número
    public static List<Integer> obterFatoresPrimos(int n) {

        List<Integer> fatores = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            while (n % i == 0) {
                fatores.add(i);
                n /= i;
            }

        }

        return fatores;

    }

    // Função para obter o MMC de um array de inteiros
    public static int mmc(int[] numeros) {

        Map<Integer, Integer> fatores = new HashMap<>();

        for (int i = 0; i < numeros.length; i++) {

            List<Integer> fatoresAtuais = obterFatoresPrimos(numeros[i]);
            Map<Integer, Integer> fatoresAtuaisMap = new HashMap<>();

            for (int fator : fatoresAtuais)
                fatoresAtuaisMap.put(fator, fatoresAtuaisMap.getOrDefault(fator, 0) + 1);

            for (int fator : fatoresAtuaisMap.keySet())
                if (!fatores.containsKey(fator) || fatores.get(fator) < fatoresAtuaisMap.get(fator))
                    fatores.put(fator, fatoresAtuaisMap.get(fator));

        }

        int resultado = 1;

        for (int fator : fatores.keySet())
            resultado *= Math.pow(fator, fatores.get(fator));

        return resultado;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ler um array de inteiros
        System.out.print("Digite a quantidade de números inteiros: ");
        int n = input.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i+1) + "º número inteiro: ");
            numeros[i] = input.nextInt();
        }

        int result = mmc(numeros);
        System.out.println("O MMC dos números digitados é " + result + ".");

    }

}
