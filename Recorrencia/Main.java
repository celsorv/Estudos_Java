
public class Main {

    // Exponenciação - Algoritmo Iterativo
    public static long exponenciar(long base, int expoente) {

        long potencia = 1;

        for (int i = 0; i < expoente; i++)
            potencia *= base;

        return potencia;

    }

    // Exponenciação - Algoritmo Recursivo
    public static long exponenciarRecursivo(long base, int expoente) {

        if (expoente == 0) return 1;

        return base * exponenciarRecursivo(base, expoente - 1);

    }

    public static void main(String[] args) {

        System.out.println(exponenciar(2, 10));
        System.out.println(exponenciarRecursivo(2, 10));

    }

}
