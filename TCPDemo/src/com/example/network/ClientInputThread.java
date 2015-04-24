package com.example.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientInputThread extends Thread
{
    private Socket socket;

    public ClientInputThread(Socket socket)
    {
        super();
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            // ���������
            InputStream is = socket.getInputStream();

            while (true)
            {
                byte[] buffer = new byte[1024];

                int length = is.read(buffer);

                String str = new String(buffer, 0, length);

                System.out.println(str);

                if("quit".equals(str)) {
                	
                	socket.close();
                	System.exit(0);
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}