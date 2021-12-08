package job4j.io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String[] args) throws IOException {
        int c;
        Socket socket = new Socket("whois.internic.net", 43);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String str = (args.length == 0 ? "OraclePressBooks.com" : args[0]) + "\n";
        byte[] buf = str.getBytes();
        outputStream.write(buf);
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }
        socket.close();
    }
}
