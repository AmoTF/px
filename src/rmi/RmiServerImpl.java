package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZTF
 * @version 创建时间：2018年7月11日 下午2:46:35 类说明
 */
public class RmiServerImpl extends UnicastRemoteObject implements RmiServer {

	static List<RmiClient> users = new ArrayList<RmiClient>();

	public RmiServerImpl() throws RemoteException {}

// 该方法中有一个形参是Client类型
// 通过这种方式让服务器获得远程客户端对象的引用
	public void hello(RmiClient cm, String saying) throws Exception {
		if (!users.contains(cm)) {
			users.add(cm);
		}
		
		try {
			java.util.Date now = new java.util.Date();
			String clientt = cm.toString();
			String msg = now + " : "+saying;
			// 依次调用连接到该服务器的每个客户端的showDialog方法
			for (RmiClient c : users) {
				// 回调远程客户端方法
				c.showDialog(msg);
			}
		} catch (RemoteException ex) {
			users.remove(cm);
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		// 注册RMI服务端口
		LocateRegistry.createRegistry(1099);
		RmiServer remote = new RmiServerImpl();
		// 将远程服务对象绑定到指定JNDI。
		System.out.println("RMI服务开启！");
		Naming.rebind("rmi://127.0.0.1:1099/ztf", remote);
	}

}
