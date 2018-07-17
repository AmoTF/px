package Thread;
/**
*@author ZTF
*@version 创建时间：2018年7月10日 下午4:26:44
* 类说明
*/
public class Cave {

	private int count=0;

	public synchronized void passCave(String name){
		++count;
		System.out.println(count);
		System.out.println(name+"进入山洞！");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(name+"已成功通过山洞");
		if(count==10) {
			System.out.println("所有人已全部通过！");
		}
	}

}
