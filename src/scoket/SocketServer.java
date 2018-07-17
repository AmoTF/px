package scoket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZTF
 * @version 创建时间：2018年7月10日 下午2:53:50 类说明
 */
public class SocketServer {

	public static void main(String[] args) {

		int port = 9999;
		ServerSocket serverSocket  = null;
		Socket socket = null ;

        System.out.println("服务器启动，等待客户端的连接。。。");
		try {
			serverSocket=new ServerSocket(port);
			while(true) {
				socket=serverSocket.accept();
		        Thread serverUploadListener= new Thread(new UploadListener(socket));
		        serverUploadListener.start();

				//BufferString b
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
