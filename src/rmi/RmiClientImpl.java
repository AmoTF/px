package rmi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

/**
*@author ZTF
*@version 创建时间：2018年7月11日 下午2:54:52
* 类说明
*/
public class RmiClientImpl implements RmiClient,Serializable{
	
	public static void main(String[] args) throws Exception {
		RmiClientImpl client = new RmiClientImpl();
		//UnicastRemoteObject.exportObject(client);
		RmiServer stub = (RmiServer) Naming.lookup("rmi://127.0.0.1:1099/ztf");
		System.out.print("请输入文字：");
		// 定义键盘输入流，用于读取用户键盘输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			// 调用远程方法时，将自身作为参数传入
			if(line.equals("q"))
				break;
			stub.hello(client, line);
		}
		if(br!=null) {
			br.close();
			br=null;
		}
		System.out.println("1111");
	}
	// 实现允许远程调用的方法
	public void showDialog(String msg) throws java.rmi.RemoteException {
		// 使用JOptionPane显示对话框
		//JOptionPane.showMessageDialog(null,msg);
		System.out.println("客户端: "+msg);
	}

}
