package scoket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ZTF
 * @version 创建时间：2018年7月10日 下午2:53:10 类说明
 */
public class SocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		DataOutputStream dos=null;
		File file = new File("E:/work/培训资料/java作业/身份证号码.txt");
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9999);
			System.out.println("客户端[port:" + socket.getLocalPort() + "] 成功连接服务端"); 
			if (file.exists()) {
				fis = new FileInputStream(file);  
                dos = new DataOutputStream(socket.getOutputStream());  
  
                // 文件名和长度  
                dos.writeUTF(file.getName());  
                dos.flush();  
                dos.writeLong(file.length());  
                dos.flush();  
                
                System.out.println("======== 开始传输文件 ========");  
                System.out.println("传输文件为："+file);  
                byte[] bytes = new byte[1024];  
                int length = 0;  
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {  
                    dos.write(bytes, 0, length);  
                    dos.flush();  
                }  
                System.out.println("======== 文件传输成功 ========");  
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
            if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            if(dos != null)
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  

	}

}
