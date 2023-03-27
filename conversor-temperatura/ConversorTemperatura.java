import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorTemperatura extends JFrame {

    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JLabel kelvinLabel;
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JTextField kelvinField;

    public ConversorTemperatura() {
        super("Conversor de Temperatura");

        // Criação dos componentes da interface
        celsiusLabel = new JLabel("Celsius:");
        fahrenheitLabel = new JLabel("Fahrenheit:");
        kelvinLabel = new JLabel("Kelvin:");
        celsiusField = new JTextField(10);
        fahrenheitField = new JTextField(10);
        kelvinField = new JTextField(10);

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitField);
        panel.add(kelvinLabel);
        panel.add(kelvinField);

        // Adição dos listeners para atualizar as outras escalas de temperatura
        celsiusField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double celsius = Double.parseDouble(celsiusField.getText());
                double fahrenheit = celsius * 1.8 + 32;
                double kelvin = celsius + 273.15;
                fahrenheitField.setText(String.format("%.2f", fahrenheit));
                kelvinField.setText(String.format("%.2f", kelvin));
            }
        });

        fahrenheitField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                double celsius = (fahrenheit - 32) / 1.8;
                double kelvin = celsius + 273.15;
                celsiusField.setText(String.format("%.2f", celsius));
                kelvinField.setText(String.format("%.2f", kelvin));
            }
        });

        kelvinField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double kelvin = Double.parseDouble(kelvinField.getText());
                double celsius = kelvin - 273.15;
                double fahrenheit = celsius * 1.8 + 32;
                celsiusField.setText(String.format("%.2f", celsius));
                fahrenheitField.setText(String.format("%.2f", fahrenheit));
            }
        });

        // Configuração da janela principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ConversorTemperatura ct = new ConversorTemperatura();
    }
}
