import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class ExemploGraficoDePizza3D {

    public static void main(String[] args) {
        // Cria um conjunto de dados para o gráfico de pizza
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Maçãs", 35);
        dataset.setValue("Laranjas", 25);
        dataset.setValue("Bananas", 40);

        // Cria o gráfico de pizza em 3D
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Vendas de frutas", // título
                dataset, // dados
                true, // legenda
                true, // tooltips
                false); // URLs

        // Personaliza o gráfico de pizza em 3D
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setDepthFactor(0.1);
        plot.setSectionPaint("Maçãs", new Color(255, 0, 0));
        plot.setSectionPaint("Laranjas", new Color(0, 255, 0));
        plot.setSectionPaint("Bananas", new Color(0, 0, 255));

        // Cria um painel de gráfico e adiciona o gráfico de pizza a ele
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true); // ativa a movimentação com a roda do mouse

        // Cria uma janela e adiciona o painel de gráfico a ela
        JFrame frame = new JFrame("Gráfico de pizza em 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
