public class MDC {

    // modo iterativo
    public static int calcularMDC(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // modo recursivo
    public static int calcularMDCRecursivo(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcularMDCRecursivo(b, a % b);
        }
    }

    public static void main(String[] args) {

        int a = 24;
        int b = 18;

        int mdc1 = calcularMDC(a, b);
        int mdc2 = calcularMDCRecursivo(a, b);

        System.out.println("MDC(" + a + ", " + b + ") = " + mdc1);
        System.out.println("MDC(" + a + ", " + b + ") = " + mdc2);

    }

}
