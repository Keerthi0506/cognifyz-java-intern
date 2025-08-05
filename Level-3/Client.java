import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5678);
        System.out.println("Connected to the server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // Reading thread (receives messages from server)
        new Thread(() -> {
            try {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println("Server: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Writing thread (sends messages to server)
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = keyboard.readLine()) != null) {
            output.println(msg);
        }

        socket.close();
    }
}
