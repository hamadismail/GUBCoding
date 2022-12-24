package javaSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
//    Arithematics arr = new Arithematics();
    final Socket com_tunnel;
    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;
    String received = "";
    String toreturn = "";

//    Scanner scanner = new Scanner(System.in);
//    int a = scanner.nextInt();
//    int b = scanner.nextInt();

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.com_tunnel = s;
        this.dis_tunnel = dis;
        this.dos_tunnel = dos;
    }



    public void run() {
        while (true) {
            try {
                dos_tunnel.writeUTF("What do you want [Date/Time]");
                received = dis_tunnel.readUTF();
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.com_tunnel + " sends exits");
                    System.out.println("Closing the connection");
                    this.com_tunnel.close();
                    break;
                }

                Date date = new Date();
                switch (received) {
                    case "Date" -> {
                        toreturn = fordate.format(date);
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Time" -> {
                        toreturn = fortime.format(date);
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Add" -> {
                        toreturn = Arithematics.sum();
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Sub" -> {
                        toreturn = Arithematics.sub();
                        dos_tunnel.writeUTF(toreturn);
                    }

                    default -> dos_tunnel.writeUTF("Invalid input");
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            this.dos_tunnel.close();
            this.dis_tunnel.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
