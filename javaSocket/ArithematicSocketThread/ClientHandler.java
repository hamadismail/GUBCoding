package javaSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler extends Thread {
    final Socket com_tunnel;
    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;
    String received = "";
    String toreturn = "";


    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) throws IOException {
        this.com_tunnel = s;
        this.dis_tunnel = dis;
        this.dos_tunnel = dos;
    }

    public void run() {
        while (true) {
            try {
                dos_tunnel.writeUTF("What do you want [Add/Sub/Mul/Div/Mod]");
                received = dis_tunnel.readUTF();
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.com_tunnel + " sends exits");
                    System.out.println("Closing the connection");
                    this.com_tunnel.close();
                    break;
                }

                switch (received) {
                    case "Add" -> {
                        toreturn = Arithematics.sum();
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Sub" -> {
                        toreturn = Arithematics.sub();
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Mul" -> {
                        toreturn = Arithematics.mul();
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Div" -> {
                        toreturn = Arithematics.div();
                        dos_tunnel.writeUTF(toreturn);
                    }
                    case "Mod" -> {
                        toreturn = Arithematics.mod();
                        dos_tunnel.writeUTF(toreturn);
                    }

                    default -> System.out.println("Invalid input");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

