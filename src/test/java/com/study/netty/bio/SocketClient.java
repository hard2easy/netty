package com.study.netty.bio;

import java.io.IOException;
import java.net.Socket;

public class SocketClient{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9000);
        socket.getOutputStream().write("hello server".getBytes());
        socket.getOutputStream().flush();
        System.out.println("client send结束");
        byte[] data = new byte[1024];
        int read = socket.getInputStream().read(data);
        System.out.println("client read结束");
        if(read != -1){
            System.out.println("接收到服务端数据为:" + new String(data,0,read));
        }
    }
}
