package com.example.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer
{
    public static void main(String[] args) throws Exception
    {
        // 创建服务器端的socket对象
        ServerSocket ss = new ServerSocket(5000);

        // 监听连接
        Socket socket = ss.accept();
        // 直到连接建立好之后代码才会往下执行

        System.out.println("Connected Successfully!");

        // 获得服务器端的输入流，从客户端接收信息
        InputStream is = socket.getInputStream();
        // 服务器端的输出流，向客户端发送信息
        OutputStream os = socket.getOutputStream();

        byte[] buffer = new byte[200];

        int length = 0;
        length = is.read(buffer);
        String str = new String(buffer, 0, length);
        System.out.println(str);

        // 服务器端的输出
        os.write("Welcome".getBytes());

        // 关闭资源
        is.close();
        os.close();
        socket.close();

    }

}