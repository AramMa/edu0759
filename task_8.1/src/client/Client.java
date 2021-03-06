package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("45.141.79.138",8188);
            System.out.println("Успешно подключен");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String response = null;
                    while (true){
                        try {
                            response = in.readUTF();
                            System.out.println(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            Scanner scanner = new Scanner(System.in);
            String request = null;
            while (true){
                request = scanner.nextLine();
                out.writeUTF(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}