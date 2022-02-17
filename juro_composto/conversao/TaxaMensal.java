public class TaxaMensal extends Convertivel {

    public static double aoAno(double taxa) {
        return menorParaMaior(taxa, 12);
    }

    public static double aoDia(double taxa) {
        return maiorParaMenor(taxa, 30);
    }

}
