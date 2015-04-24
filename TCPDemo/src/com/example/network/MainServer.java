package com.example.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(4000);
		ArrayList<ServerInputThread> inList = new ArrayList<ServerInputThread>();
		ArrayList<ServerOutputThread> outList = new ArrayList<ServerOutputThread>();

		while (true) {

			// һֱ���ڼ���״̬,�������Դ������û�
			Socket socket = serverSocket.accept();

			ServerInputThread inThread = new ServerInputThread(socket);
			inThread.start();
			inList.add(inThread);

			ServerOutputThread outThread = new ServerOutputThread(socket);
			outThread.start();
			outList.add(outThread);
		}
	}
}