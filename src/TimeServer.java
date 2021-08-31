import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//TODO shows the correct time for the user, but server connection resets and result in an error

public class TimeServer {

    public static void main(String[] args) {

        new Thread(() -> {
try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        Date date = new Date(System.currentTimeMillis());

        ServerSocket serverSocket = new ServerSocket(5000);

        Socket socket = serverSocket.accept();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        dataOutputStream.writeUTF(format.format(date) + "\n");


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
