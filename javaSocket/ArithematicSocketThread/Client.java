package javaSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        try{
            Socket clientsocket = new Socket ("localhost", 5000);
            System.out.println("Connected at server Handshaking port " + clientsocket.getPort());
            System.out.println("Client is connecting at Communication Port " + clientsocket.getLocalPort());
            System.out.println("Client is Connected");
            Scanner scn = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientsocket.getInputStream());

            while(true){
                String inLine = dis.readUTF();
                System.out.println(inLine);
                String outLine = scn.nextLine();
                dos.writeUTF(outLine);

                if(outLine.equals("Exit")){
                    System.out.println("Closing the connecting "+ clientsocket);
                    clientsocket.close();
                    System.out.println("Connection Closed");
                    break;
                }

                switch (outLine) {
                    case "Add" -> {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        Arithematics.sum(a,b);
                    }
                    case "Sub" -> {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        Arithematics.sub(a,b);
                    }
                    case "Mul" -> {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        Arithematics.mul(a,b);
                    }
                    case "Div" -> {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        Arithematics.div(a,b);
                    }
                    case "Mod" -> {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        Arithematics.mod(a,b);
                    }

                    default -> System.out.println("Invalid input");
                }

                String received = dis.readUTF();
                System.out.println(received);
            }
            dos.close();
            dis.close();
            clientsocket.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

}
