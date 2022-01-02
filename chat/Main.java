import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Server server = new Server();
        new Thread(server).start();

        Scanner sc = new Scanner(System.in );

        while (true) {

            try (Socket conn = new Socket(Server.IP, Server.PORT)) {

                DataOutputStream os = new DataOutputStream(conn.getOutputStream());

                String question = sc.nextLine();

                os.writeUTF(question);
                os.flush();

                DataInputStream is = new DataInputStream(conn.getInputStream());

                String msg;

                while (true) {
                    if (is.available() > 0) {
                        msg = is.readUTF();
                        ColorConsole.println(msg, Server.LINE_COLOR);
                        break;
                    }
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
