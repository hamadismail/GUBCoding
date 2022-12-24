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


                String received = dis.readUTF();
                System.out.println(received);
            }



//            Scanner scanner = new Scanner(System.in);
//            int a = scn.nextInt();
//            int b = scn.nextInt();

//            Arithematics.sum(a,b);
//            Arithematics.sub();



            dos.close();
            dis.close();
            clientsocket.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }


}
