package Thread;

/**
 * @author ZTF
 * @version 创建时间：2018年7月10日 下午4:32:09 类说明
 */
public class Test {

	public static void main(String[] args) {

		Cave cave = new Cave();
		Thread t1 = new Thread(new PersonPassCave("张1", cave));
		Thread t2 = new Thread(new PersonPassCave("张2", cave));
		Thread t3 = new Thread(new PersonPassCave("张3", cave));
		Thread t4 = new Thread(new PersonPassCave("张4", cave));
		Thread t5 = new Thread(new PersonPassCave("张5", cave));
		Thread t6 = new Thread(new PersonPassCave("张6", cave));
		Thread t7 = new Thread(new PersonPassCave("张7", cave));
		Thread t8 = new Thread(new PersonPassCave("张8", cave));
		Thread t9 = new Thread(new PersonPassCave("张9", cave));
		Thread t10 = new Thread(new PersonPassCave("张10", cave));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();

	}
}
