package com.chenss.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author User
 */
public class BioServer {
    ServerSocket serverSocket = null;

    public BioServer() {
        try {
            this.serverSocket = new ServerSocket(9090);
            TimeServerHandlerExecutorPool timeServerHandlerExecutorPool =  new TimeServerHandlerExecutorPool(50,10000);

            while (true) {
                // 在接受连接的过程中，处于阻塞状态
                Socket accept =  this.serverSocket.accept();
                timeServerHandlerExecutorPool.execute(new TimeServerHandler(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    public void start() {

    }

    public static void main(String[] args) {

    }
}
