import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CampoMinadoSwing extends JFrame implements ActionListener {
    private JButton[][] botoes;
    private boolean[][] campoMinado;
    private int[][] numMinasAdjacentes;
    private int linhas;
    private int colunas;
    private int numMinas;

    public CampoMinadoSwing(int linhas, int colunas, int numMinas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.numMinas = numMinas;
        campoMinado = new boolean[linhas][colunas];
        numMinasAdjacentes = new int[linhas][colunas];
        gerarMinas();
        calcularMinasAdjacentes();
        criarGUI();
    }

    private void gerarMinas() {
        int numMinasGeradas = 0;
        while (numMinasGeradas < numMinas) {
            int linha = (int) (Math.random() * linhas);
            int coluna = (int) (Math.random() * colunas);
            if (!campoMinado[linha][coluna]) {
                campoMinado[linha][coluna] = true;
                numMinasGeradas++;
            }
        }
    }

    private void calcularMinasAdjacentes() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                int numMinasAdjacentes = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int linhaAdjacente = linha + i;
                        int colunaAdjacente = coluna + j;
                        if (linhaAdjacente >= 0 && linhaAdjacente < linhas && colunaAdjacente >= 0 && colunaAdjacente < colunas) {
                            if (campoMinado[linhaAdjacente][colunaAdjacente]) {
                                numMinasAdjacentes++;
                            }
                        }
                    }
                }
                this.numMinasAdjacentes[linha][coluna] = numMinasAdjacentes;
            }
        }
    }

    private void criarGUI() {
        setTitle("Campo Minado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(linhas, colunas));
        botoes = new JButton[linhas][colunas];
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                botoes[linha][coluna] = new JButton();
                botoes[linha][coluna].addActionListener(this);
                add(botoes[linha][coluna]);
            }
        }
        pack();
        setVisible(true);
    }

    private void mostrarMina(int linha, int coluna) {
        if (campoMinado[linha][coluna]) {
            botoes[linha][coluna].setText("X");
            JOptionPane.showMessageDialog(this, "Você perdeu!");
            reiniciarJogo();
        } else {
            int numMinasAdjacentes = this.numMinasAdjacentes[linha][coluna];
            botoes[linha][coluna].setText(Integer.toString(numMinasAdjacentes));
            botoes[linha][coluna].setEnabled(false);
            if (numMinasAdjacentes == 0) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int linhaAdjacente = linha + i;
                        int colunaAdjacente = coluna + j;
                        if (linhaAdjacente >= 0 && linhaAdjacente < linhas && colunaAdjacente >= 0 && colunaAdjacente < colunas) {
                            if (botoes[linhaAdjacente][colunaAdjacente].isEnabled()) {
                                mostrarMina(linhaAdjacente, colunaAdjacente);
                            }
                        }
                    }
                }
            }
            verificarVitoria();
        }
    }

    private void reiniciarJogo() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                campoMinado[linha][coluna] = false;
                numMinasAdjacentes[linha][coluna] = 0;
                botoes[linha][coluna].setText("");
                botoes[linha][coluna].setEnabled(true);
            }
        }
        gerarMinas();
        calcularMinasAdjacentes();
    }

    private void verificarVitoria() {
        boolean vitoria = true;
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                if (!campoMinado[linha][coluna] && botoes[linha][coluna].isEnabled()) {
                    vitoria = false;
                    break;
                }
            }
        }
        if (vitoria) {
            JOptionPane.showMessageDialog(this, "Você ganhou!");
            reiniciarJogo();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                if (e.getSource() == botoes[linha][coluna]) {
                    mostrarMina(linha, coluna);
                }
            }
        }
    }

    public static void main(String[] args) {
        CampoMinadoSwing campoMinado = new CampoMinadoSwing(10, 10, 10);
    }

}
