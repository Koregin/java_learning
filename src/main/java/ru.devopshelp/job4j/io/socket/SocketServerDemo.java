package job4j.io.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket incoming = serverSocket.accept(); // Ожидание подключения к порту
    }
}
