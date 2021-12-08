package job4j.io.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println(address.getHostName());
        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        Arrays.stream(addresses).forEach(addr -> System.out.println(addr.getHostAddress()));
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost.getHostAddress());
    }
}
