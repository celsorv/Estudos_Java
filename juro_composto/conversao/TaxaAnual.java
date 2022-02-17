public class TaxaAnual extends Convertivel {

    public static double aoMes(double taxa) {
        return maiorParaMenor(taxa, 12);
    }

    public static double aoDia(double taxa) {
        return maiorParaMenor(taxa, 360);
    }

}
