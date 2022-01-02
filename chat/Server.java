import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Server implements Runnable {

    public static final ANSIColor LINE_COLOR = ANSIColor.YELLOW;
    public static final Random GENERATOR = new Random(6);
    public static final String DATA_FILE_NAME = "dados.txt";
    public static final String TOKEN_EOT = "EOT";
    public static final String IP = "127.0.0.1";
    public static final int PORT = 1234;

    private static final String[] UNKNOWN_MSG = {
            "Não sei responder", "Não sei dizer", "Sei não!", "Não tenho essa resposta",
            "Vou ficar lhe devendo essa!", "Hum... não sei!", "Desculpe, não sei responder"
    };

    private static final String[] IGNORED_WORDS = {
            "E", "O", "OU", "A", "QUE", "QUEM", "QUAL", "DE", "TE",
            "MAS", "ME", "LA", "TE", "SE", "DIGA", "FALA", "FALE", "MESMO"
    };

    private Map<String, String> DBquestions;
    private boolean online = false;
    private int afirmacoes = 0;

    public Server() {
        loadData();
    }

    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            ColorConsole.println("\nOlá, seja bem-vindo(a)!", LINE_COLOR );

            online = true;

            while (online) {

                Socket conn = serverSocket.accept();
                DataInputStream is = new DataInputStream(conn.getInputStream());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                String question;

                while (true) {
                    if (is.available() > 0) {
                        question = is.readUTF();
                        String answer = getAnswer(question);
                        os.writeUTF(answer);
                        break;
                    }
                }

                conn.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ColorConsole.println("\nServidor encerrado", LINE_COLOR);
        ColorConsole.println("Bye!\n", LINE_COLOR);

    }

    private void loadData() {

        DBquestions = new HashMap<>();

        try(BufferedReader bufRead = new BufferedReader(new FileReader(DATA_FILE_NAME))) {
            String txtLine;
            while ((txtLine = bufRead.readLine()) != null) {

                int index = txtLine.indexOf(":");
                if (index == -1) continue;

                String question = txtLine.substring(0, index).trim();
                if (question.isBlank()) continue;

                String answer = txtLine.substring(index + 1).trim();
                DBquestions.put(question.toUpperCase(), answer);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String normalizer(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public String getAnswer(String question) {

        if (question == null || question.isBlank())
            return "   :: O que disse?";

        if (!question.contains("?")) {
            if (afirmacoes != -1 && ++afirmacoes > 2) {
                afirmacoes = -1;
                return "   :: Para perguntas, interrogação ao final dela!";
            } else
                return "   :: :)";
        }

        question = normalizer(question.trim().toUpperCase(Locale.ROOT));
        String answer = DBquestions.get(question.substring(0, question.length() - 1));
        if (answer != null) return "   :: " + answer;

        String[] words = question.split("[,.!?'@_-] *| +");
        StringBuilder newQuestion = new StringBuilder();

        for (String word: words) {
            boolean found = false;
            for (String ignored: IGNORED_WORDS) {
                if (ignored.equals(word)) {
                    found = true;
                    break;
                }
            }
            if (!found) newQuestion.append(word + " ");
        }

        answer = DBquestions.get(newQuestion.toString().trim());
        if (answer == null)
            answer = UNKNOWN_MSG[random()];

        return "   :: " + answer;

    }

    public int random() {
        // final int min = 0;
        // final int max = 6;
        return GENERATOR.nextInt(6);  // GENERATOR.nextInt(max + min) + min;
    }

}
