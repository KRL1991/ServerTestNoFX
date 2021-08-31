import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpFinder {

    private static InetAddress address;

    public static void main(String[] args) {

        String url = "localhost";

        try {

            address = InetAddress.getByName(url);
            System.out.println("Ip Address: "
                    + address.toString());
            address = InetAddress.getLocalHost();
            System.out.println("LAN address: "
                            + address.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();

            System.out.println("Address not found");
        }
    }
}
