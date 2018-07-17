package w2018_7_9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ZTF
 * @version 创建时间：2018年7月10日 上午11:14:15 类说明
 */
public class CompareTest {

	public static void testArrayList() {
		
		long start, end;
		List list = new ArrayList();
		int maxNum = 100000;
		
		int i = 0;
		for (; i < 100000; i++) {
			list.add(i);
		}
		
		i = 0;
		start = System.currentTimeMillis();
		for (; i < maxNum; i++) {
			list.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList遍历for()测试： " + "开始时间：" + start + "； 结束时间：" + end + "； 运行时间：" + (end - start) + "(ms)");
		
		start = 0;
		end = 0;
		
		start = System.currentTimeMillis();
		for (Object num:list) {
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList遍历foreach()测试： " + "开始时间：" + start + "； 结束时间：" + end + "； 运行时间：" + (end - start) + "(ms)");

	}

	public static void testLinkedList() {
		long start, end;
		List list = new LinkedList();
		int maxNum = 100000;
		
		int i = 0;
		for (; i < 100000; i++) {
			list.add(i);
		}
		
		i = 0;
		start = System.currentTimeMillis();
		for (; i < maxNum; i++) {
			list.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList遍历for()测试： " + "开始时间：" + start + "； 结束时间：" + end + "； 运行时间：" + (end - start) + "(ms)");
		
		start = 0;
		end = 0;
		
		start = System.currentTimeMillis();
		for (Object  num:list) {
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList遍历foreach()测试： " + "开始时间：" + start + "； 结束时间：" + end + "； 运行时间：" + (end - start) + "(ms)");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testArrayList();
		testLinkedList();
	}

}
