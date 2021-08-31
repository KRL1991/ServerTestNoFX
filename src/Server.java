import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        int port = 4500;

        new Thread(() -> {
            try {

                //Step 1:
                ServerSocket serverSocket = new ServerSocket(port);

                //Step 2:

                System.out.println("Accepting connection on port: " + port);

                Socket socket = serverSocket.accept();

                System.out.println("Connection establishing from " + socket.getRemoteSocketAddress().toString());

                // Step 3:

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                //Step 4:
                while (true) {
                    String incomingText = dataInputStream.readUTF();
                    System.out.println("Data from client: " + incomingText);
                    dataOutputStream.writeUTF("Data received");
                    dataOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
