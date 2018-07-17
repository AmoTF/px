package rmi;

import java.rmi.Remote;

/**
 * @author ZTF
 * @version 创建时间：2018年7月11日 下午2:54:52 类说明
 */
public interface RmiClient extends Remote{

	// 定义一个允许远程调用的方法
	void showDialog(String msg) throws java.rmi.RemoteException;
}
