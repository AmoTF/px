package Thread;
/**
*@author ZTF
*@version 创建时间：2018年7月10日 下午4:26:35
* 类说明
*/
public class PersonPassCave implements Runnable {

	private Cave cave;
	private String name;
	
	public PersonPassCave(String name,Cave cave) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.cave=cave;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cave.passCave(name);
		
	}
	
	
}
