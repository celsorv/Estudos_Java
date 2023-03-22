import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

public class BarChart3DExample {

    public static void main(String[] args) {
        // cria um conjunto de dados de exemplo
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5, "Produto 1", "Janeiro");
        dataset.addValue(7, "Produto 2", "Janeiro");
        dataset.addValue(9, "Produto 3", "Janeiro");
        dataset.addValue(6, "Produto 4", "Janeiro");

        // cria o gráfico de barras 3D
        JFreeChart chart = ChartFactory.createBarChart3D("Vendas de Janeiro", "Produto", "Vendas",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        // configura as cores das barras
        BarRenderer3D renderer = (BarRenderer3D) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesPaint(3, Color.YELLOW);

        // adiciona rótulos nas barras
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);

        // cria a janela do gráfico
        ChartFrame frame = new ChartFrame("Gráfico de barras 3D", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
