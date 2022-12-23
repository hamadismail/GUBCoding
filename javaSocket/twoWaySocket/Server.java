package javaSocket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server is connected at port no: " + ss.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");
        Socket s = ss.accept();
        System.out.println("Client request is accepted at port no: " + s.getPort());
        System.out.println("Server’s Communication Port: " + s.getLocalPort());

        System.out.println("Enter the messages that you want to send and send \" stop\" to close the connection:");
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str2 = "";

        DataInputStream input = new DataInputStream(s.getInputStream());
        String str = "";

        while (!str.equals("stop")) {
            str2 = read.readLine();
            output.writeUTF(str2);

            str = input.readUTF();
            System.out.println("Client Says: " + str);
        }
        s.close();
        input.close();

        output.close();
        read.close();
        //s.close();
    }

}