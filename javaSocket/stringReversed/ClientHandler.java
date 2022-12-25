package javaSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {

    final Socket com_tunnel;
    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.com_tunnel = s;
        this.dis_tunnel = dis;
        this.dos_tunnel = dos;
    }

    public void run() {
        String clientMessage="", serverMessage="";
        String rever;
        while (!clientMessage.equals("Exit")) {
            try {
                clientMessage=dis_tunnel.readUTF();
                System.out.println("From Client-" +clientMessage);
                StringBuilder sb= new StringBuilder(clientMessage);
                sb.reverse();
                rever = sb.toString();
                serverMessage="From Server to Client-"+ " Revers of " + clientMessage + " is " +rever;
                dos_tunnel.writeUTF(serverMessage);
                dos_tunnel.flush();

            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
