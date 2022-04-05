import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8089;
        boolean connectEstablished = true;
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while (connectEstablished) {
            String response = in.readLine();
            System.out.println(response);
            String string = input.nextLine();
            if (string.equals("exit")) {
                connectEstablished = false;
                out.println(string);
                response = in.readLine();
                System.out.println(response);
            }
            out.println(string);
        }
        clientSocket.close();
    }
}
