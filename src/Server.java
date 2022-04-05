import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8089;
        System.out.println("Сервер запущен...");
        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket connection = serverSocket.accept();

            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            out.println("Добрый день! Как ваше имя?");
            final String username = in.readLine();
            System.out.format("Пользователь %s в сети...\n", username);
            out.println(String.format("Привет, %s! Вам уже есть 18 лет? Напишите 'да (yes)'/'нет (no)' или 'exit', чтобы отключиться...", username));
            while (true) {
                String answer = in.readLine();
                if (answer.equals("да") || answer.equals("yes")) {
                    out.println(String.format("%s, добро пожаловать в раздел для взрослых. Хорошего отдыха или приятной работы!", username));
                } else if (answer.equals("нет") || answer.equals("no")) {
                    out.println(String.format("%s, добро пожаловать в раздел для детей. Давай поиграем!", username));
                } else if (answer.equals("exit")) {
                    out.println("Всего доброго! Хорошего дня! Сессия завершена!");
                    System.out.printf("Пользователь %s вышел из сети.\n", username);
                    break;
                }
            }
            serverSocket.close();
        }
    }
}