package com.chenss.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChenssSocketTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println(serverSocket.getReuseAddress());
            serverSocket.bind(new InetSocketAddress(9876));
            System.out.println("wait accept");
            Socket socket= serverSocket.accept();
            System.out.println("Client Conn");
            socket.getInputStream().read(bytes);
            System.out.println(new String(bytes));
            System.out.println("read Over");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
