import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.LineRenderer3D;

public class GraficoLinhas3D {
    public static void main(String[] args) {

        // Cria o dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(50, "Cereais", "Janeiro");
        dataset.addValue(15, "Cereais", "Fevereiro");
        dataset.addValue(30, "Cereais", "Março");
        dataset.addValue(12, "Bebidas", "Janeiro");
        dataset.addValue(38, "Bebidas", "Fevereiro");
        dataset.addValue(32, "Bebidas", "Março");
        dataset.addValue(10, "Laticínios", "Janeiro");
        dataset.addValue(58, "Laticínios", "Fevereiro");
        dataset.addValue(65, "Laticínios", "Março");

        // Cria o gráfico de linhas 3D
        JFreeChart chart = ChartFactory.createLineChart3D(
                "Vendas por Produto", // título do gráfico
                "Mês", // label do eixo x
                "Vendas", // label do eixo y
                dataset, // dados do gráfico
                PlotOrientation.VERTICAL, // orientação do gráfico
                true, // exibe legendas
                true, // exibe tooltips
                false // não exibe urls
        );

        // Configura o renderer para que cada linha tenha uma cor diferente
        LineRenderer3D renderer = new LineRenderer3D();
        renderer.setAutoPopulateSeriesPaint(false); // desabilita cores padrão
        Color[] cores = {Color.red, Color.blue, Color.green}; // cores das linhas
        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, cores[i % cores.length]); // define a cor da linha
        }
        chart.getCategoryPlot().setRenderer(renderer);

        // Cria o frame do gráfico
        ChartFrame frame = new ChartFrame("Gráfico de Linhas 3D", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
