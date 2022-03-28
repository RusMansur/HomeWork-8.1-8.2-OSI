import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8089;

        while (true) {
                ServerSocket serverSocket = new ServerSocket(port);
                Socket connection = serverSocket.accept();
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                System.out.println("Новое соединение установлено");
                final String name = in.readLine();
                out.println(String.format("Привет %s, ваш порт %d", name, connection.getPort()));
                serverSocket.close();
        }
    }
}
