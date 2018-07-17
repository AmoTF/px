package rmi;

import java.rmi.Remote;

/**
*@author ZTF
*@version 创建时间：2018年7月11日 下午2:46:35
* 类说明
*/
public interface RmiServer extends Remote{
	
	void hello(RmiClient client, String saying) throws Exception;

}
