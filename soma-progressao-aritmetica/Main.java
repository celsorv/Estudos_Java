public class Main {

    // devido ao loop for para somar cada termo individualmente, tem um tempo de execução de O(n^2).
    public static long sumOfArithmeticProgression(long firstTerm, long commonDifference, long numberOfTerms) {

        long sum = 0;  // O(1)

        for (long i = 0; i < numberOfTerms; i++) {
            long currentTerm = firstTerm + i * commonDifference; // O(n)
            sum += currentTerm;                                  // O(n)
        }

        return sum;  // O(1)

    }

    // com a fórmula aplicada diretamente, o tempo de execução é O(1).
    public static long sumOfArithmeticProgressionFormulaBased(long firstTerm, long commonDifference, long numberOfTerms) {

        return (2 * firstTerm + (numberOfTerms - 1) * commonDifference) * numberOfTerms / 2;  // O(1)

    }

    public static void main(String[] args) {

        long res1 = 0, res2 = 0;

        long start = System.currentTimeMillis();

//        res1 = sumOfArithmeticProgression(1, 2, 2_000_000_000);
        res2 = sumOfArithmeticProgressionFormulaBased(1, 2, 2_000_000_000);

        long end = System.currentTimeMillis();

        System.out.printf("res1=%d -- res2=%d -- time=%d", res1, res2, end - start);

    }

}
