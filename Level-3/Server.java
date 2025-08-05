import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5678);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // Reading thread
        new Thread(() -> {
            try {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println("Client: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Writing thread
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = keyboard.readLine()) != null) {
            output.println(msg);
        }

        socket.close();
        serverSocket.close();
    }
}
