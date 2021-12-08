package shildt.io;

import java.io.*;

public class ReadBytes {
    public static void main(String[] args)
        throws IOException {
        byte[] data = new byte[15];
        System.out.println("Enter symbols:");
        System.in.read(data);
        System.out.println("Вы ввели: ");
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                continue;
            }
            System.out.print((char) data[i]);
        }
    }
}
