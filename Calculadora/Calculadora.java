import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField display;
    private double valor1, valor2, resultado;
    private String operacao;
    private boolean novaOperacao = true;
    private boolean limparDisplay = true;
    private double ans = 0;

    public Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JPanel painelDisplay = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        display = new JTextField("0", 20);
        display.setEditable(false);
        painelDisplay.add(display);
        painelPrincipal.add(painelDisplay, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] rotulos = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        for (String rotulo : rotulos) {
            JButton botao = new JButton(rotulo);
            botao.addActionListener(this);
            painelBotoes.add(botao);
        }
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        JPanel painelMemoria = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton botaoAns = new JButton("Ans");
        botaoAns.addActionListener(this);
        painelMemoria.add(botaoAns);
        painelPrincipal.add(painelMemoria, BorderLayout.SOUTH);

        setContentPane(painelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "C":
                valor1 = 0;
                valor2 = 0;
                resultado = 0;
                operacao = "";
                novaOperacao = true;
                display.setText("0");
                limparDisplay = true;
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!novaOperacao) {
                    calcular();
                    valor1 = resultado;
                } else {
                    valor1 = Double.parseDouble(display.getText());
                    novaOperacao = false;
                }
                operacao = comando;
                display.setText("");
                break;
            case "=":
                calcular();
                novaOperacao = true;
                limparDisplay = true;
                break;
            case "Ans":
                if (novaOperacao) {
                    display.setText(String.valueOf(ans));
                } else {
                    display.setText(display.getText() + ans);
                }
                break;
            default:
                if (limparDisplay) {
                    display.setText(comando);
                    limparDisplay = false;
                } else {
                    display.setText(display.getText() + comando);
                }
                break;
        }
    }

    private void calcular() {
        valor2 = Double.parseDouble(display.getText());
        switch (operacao) {
            case "+":
                resultado = valor1 + valor2;
                break;
            case "-":
                resultado = valor1 - valor2;
                break;
            case "*":
                resultado = valor1 * valor2;
                break;
            case "/":
                resultado = valor1 / valor2;
                break;
        }
        display.setText(String.valueOf(resultado));
        ans = resultado;
    }

    public static void main(String[] args) {
        new Calculadora();
    }

}
