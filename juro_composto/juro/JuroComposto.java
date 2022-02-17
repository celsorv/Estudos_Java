public class JuroComposto {

    public static double juros(double taxa, long periodo, double principal) {
        double montante = principal * Math.pow(1 + taxa / 100, periodo);

        return montante - principal;
    }

}
