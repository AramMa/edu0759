package server;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clinetSokets = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            System.out.println("Сервер запущен");
            while (true){
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept();
                User currentUser = new User(socket);
                users.add(currentUser);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        try {
                            out.writeUTF("Введите имя: ");
                            String userName = in.readUTF();
                            currentUser.setUserName(userName);
                            System.out.println(currentUser.getUserName()+" добро пожаловать на сервер!");
                            out.writeUTF(currentUser.getUserName()+" добро пожаловать на сервер!");
                            while (true){
                                request = in.readUTF();
                                System.out.println("Клиент прислал: "+request);
                                for (User user: users) {
                                    if(currentUser != user){
                                        DataOutputStream out = new DataOutputStream(user.getSocket().getOutputStream());
                                        out.writeUTF(currentUser.getUserName()+": "+request);
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            for (User user: users) {
                                if(currentUser != user){
                                    try {
                                        DataOutputStream out = new DataOutputStream(user.getSocket().getOutputStream());
                                        out.writeUTF("Пользователь "+currentUser.getUserName()+" покинул чат");
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                            }
                            users.remove(currentUser);
                        }
                    }
                });
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}