package scoket;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * @author ZTF
 * @version 创建时间：2018年7月10日 下午3:12:56 类说明
 */
public class UploadListener implements Runnable {

	private Socket socket;
    private static DecimalFormat df = null;  
    private DataInputStream dis;  
    private FileOutputStream fos; 
    
    static {  
        // 设置数字格式，保留一位有效小数  
        df = new DecimalFormat("#0.0");  
        df.setRoundingMode(RoundingMode.HALF_UP);  
        df.setMinimumFractionDigits(1);  
        df.setMaximumFractionDigits(1);  
    }  
    
	public UploadListener(Socket socket) {
		this.socket = socket;
	}

	public void sendFile(Socket socket) {

		try {
			dis = new DataInputStream(socket.getInputStream());
			// 文件名和长度
			String fileName = dis.readUTF();
			long fileLength = dis.readLong();
			System.out.println("文件名："+fileName);
			System.out.println("文件大小："+fileLength+"B");
			File directory = new File("D:\\FTCache");  
            if(!directory.exists()) {  
                directory.mkdir();  
            }  
            File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);  
            fos = new FileOutputStream(file);  

            // 开始接收文件  
            byte[] bytes = new byte[1024];  
            int length = 0;  
            while((length = dis.read(bytes, 0, bytes.length)) != -1) {  
                fos.write(bytes, 0, length);  
                fos.flush();  
            }  
            System.out.println("======== 文件接收成功 [文件名称：" + fileName + "] [Size：" + getFormatFileSize(fileLength) + "] ========");  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
            try {  
                if(fos != null)  
                    fos.close();  
                if(dis != null)  
                    dis.close();  
                socket.close();  
            } catch (Exception e) {}  
        }  

	}
	
	/** 
     * 格式化文件大小 
     * @param length 
     * @return 
     */  
    private String getFormatFileSize(long length) {  
        double size = ((double) length) / (1 << 30);  
        if(size >= 1) {  
            return df.format(size) + "GB";  
        }  
        size = ((double) length) / (1 << 20);  
        if(size >= 1) {  
            return df.format(size) + "MB";  
        }  
        size = ((double) length) / (1 << 10);  
        if(size >= 1) {  
            return df.format(size) + "KB";  
        }  
        return length + "B";  
    }  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendFile(socket);
	}

}
