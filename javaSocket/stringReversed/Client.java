package javaSocket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try{
            Socket clientsocket = new Socket ("localhost", 5000);
            System.out.println("Connected at server Handshaking port " + clientsocket.getPort());
            System.out.println("Client is connecting at Communication Port " + clientsocket.getLocalPort());
            System.out.println("Client is Connected");
            DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientsocket.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";
            while(!clientMessage.equals("Exit"))
            {
                System.out.println("Enter a String :");
                clientMessage=br.readLine();
                dos.writeUTF(clientMessage);
                dos.flush();
                serverMessage=dis.readUTF();
                System.out.println(serverMessage);
            }
            dos.close();
            dos.close();
            clientsocket.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
