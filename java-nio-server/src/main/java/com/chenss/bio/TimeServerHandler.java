package com.chenss.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author User
 * @date 2019-9-28 19:26:10
 */
public class TimeServerHandler implements Runnable {
    public Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String line = null;
            String time = null;
            while (true) {
                line = reader.readLine();
                if (line==null) {
                    break;
                }
                time="SJ".equals(line)?new SimpleDateFormat("yyyy-MM-dd hh:mi:ss").format(new Date()):"BAD ORDER";
                writer.println(time);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer!=null) {
                writer.close();
            }
            if (socket!=null) {
                try {
                    socket.close();
                    socket=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
