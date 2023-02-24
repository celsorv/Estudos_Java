public class Main {

    public static void main(String[] args) {

        int[] x = new int[]{10, 3, 1, 6, 4, 12, 5, 2, 8, 7};

        int[] r = insertionSort(x);

        mostrar(r);

    }

    public static int[] insertionSort(int[] A) {

        for (int j = 1; j < A.length; j++) {    // percorre o vetor a partir da posição 1

            int atual = A[j];                   // guarda o valor da posição corrente em análise

            /* ------------------------------------------------------
               Abaixo, insere A[j] na sequência ordenada A[0 ... j-1]
               ------------------------------------------------------ */

            int i = j - 1;                      // aponta para a posição à esquerda da posição em análise

            while (i >= 0 && A[i] > atual) {    // se não chegou ao início do vetor e o valor da posição
                                                // à esquerda (j=i-1) é maior que o valor da posição em análise

                A[i + 1] = A[i];                // desloca para a direita o valor da posição à esquerda (j=i-1)
                i--;                            // aponta para a próxima posição à esquerda

            }

            A[i + 1] = atual;                   // se chegou ao início do vetor ou o valor da posição à esquerda
                                                // é menor que o valor da posição em análise, escreva o valor na
                                                // lacuna (à direita da última posição verificada)
        }

        return A;

    }

    private static void mostrar(int[] r) {
        System.out.println();
        for (int j : r) System.out.print(j + ", ");
        System.out.println();
    }

}
