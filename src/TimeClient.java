import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost",5000);

            System.out.println("Enter any command: ");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            dataOutputStream.writeUTF(scanner.nextLine());
            dataOutputStream.flush();
            System.out.println(dataInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
