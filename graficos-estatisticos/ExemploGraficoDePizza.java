import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class ExemploGraficoDePizza {

    public static void main(String[] args) {
        // Cria um conjunto de dados para o gráfico de pizza
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Maçãs", 35);
        dataset.setValue("Laranjas", 25);
        dataset.setValue("Bananas", 40);

        // Cria o gráfico de pizza
        JFreeChart chart = ChartFactory.createPieChart(
                "Vendas de frutas", // título
                dataset, // dados
                true, // legenda
                true, // tooltips
                false); // URLs

        // Personaliza o gráfico de pizza
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Maçãs", new Color(255, 0, 0));
        plot.setSectionPaint("Laranjas", new Color(0, 255, 0));
        plot.setSectionPaint("Bananas", new Color(0, 0, 255));

        // Cria um painel de gráfico e adiciona o gráfico de pizza a ele
        ChartPanel chartPanel = new ChartPanel(chart);

        // Cria uma janela e adiciona o painel de gráfico a ela
        JFrame frame = new JFrame("Gráfico de pizza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
