package javaSocket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Client Connected at server Handshaking port " + s.getPort());
        System.out.println("Client’s communcation port " + s.getLocalPort());
        System.out.println("Client is Connected");

        System.out.println("Enter the messages that you want to send and send \" stop\" to close the connection:");
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        DataInputStream input = new DataInputStream(s.getInputStream());
        String str2 = "";

        while (!str.equals("stop")) {
            str = read.readLine();
            output.writeUTF(str);

            str2 = input.readUTF();
            System.out.println("Server Says: " + str2);
        }
        output.close();
        read.close();
        s.close();

        //s.close();
        input.close();
    }
}

