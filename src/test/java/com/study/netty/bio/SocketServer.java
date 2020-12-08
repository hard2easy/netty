package com.study.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        byte[] data = new byte[1024];
        int read = socket.getInputStream().read(data);
        System.out.println("server read结束");
        if(read != -1){
            System.out.println("接收到客户端数据为:" + new String(data,0,read));
        }
        socket.getOutputStream().write("hello client".getBytes());
        socket.getOutputStream().flush();
        System.out.println("server send结束");
    }
}
