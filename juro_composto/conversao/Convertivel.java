public abstract class Convertivel {

    protected static double menorParaMaior(double taxa, int periodo) {
        return (Math.pow(1 + taxa / 100, periodo) - 1) * 100;
    }

    protected static double maiorParaMenor(double taxa, int periodo) {
        return (Math.pow(1 + taxa / 100, (double) 1 / periodo) - 1) * 100;
    }

}
