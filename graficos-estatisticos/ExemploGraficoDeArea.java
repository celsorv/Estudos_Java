import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.DefaultXYZDataset;

public class ExemploGraficoDeArea {

    public static void main(String[] args) {
        // Define as médias esperadas e as médias alcançadas de cada disciplina
        double[] mediaEsperada = { 7.0, 6.0, 8.0, 9.0 };
        double[] mediaAlcancada = { 6.0, 5.5, 7.5, 8.5 };
        String[] disciplinas = { "Matemática", "Português", "História", "Geografia" };

        // Cria um conjunto de dados para o gráfico de área
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[][] data = new double[3][mediaEsperada.length];
        for (int i = 0; i < mediaEsperada.length; i++) {
            data[0][i] = i + 1;
            data[1][i] = mediaEsperada[i];
            data[2][i] = mediaAlcancada[i];
        }
        dataset.addSeries("Média esperada", data);

        // Cria o gráfico de área
        JFreeChart chart = ChartFactory.createXYAreaChart(
                "Médias esperadas e alcançadas por disciplina", // título
                "Disciplina", // rótulo do eixo X
                "Média", // rótulo do eixo Y
                dataset, // dados
                PlotOrientation.VERTICAL, // orientação do gráfico
                true, // legenda
                false, // tooltips
                false); // URLs

        // Personaliza o gráfico de área
        XYPlot plot = chart.getXYPlot();
        XYAreaRenderer renderer = new XYAreaRenderer();
        renderer.setSeriesPaint(0, new Color(255, 0, 0));
        plot.setRenderer(renderer);

        // Cria um painel de gráfico e adiciona o gráfico de área a ele
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 400));

        // Cria uma janela e adiciona o painel de gráfico a ela
        JFrame frame = new JFrame("Gráfico de área 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
