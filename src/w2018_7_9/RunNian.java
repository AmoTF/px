package w2018_7_9;

public class RunNian {

	public static void printYear(int[] year, int length) {

		for (int i = 0; i < length; i++) {
			if (i == length - 1) {
				System.out.println(year[i]);
			} else {
				System.out.print(year[i] + "-");
			}
			if (i % 100 == 0 && i != 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		int[] isRunNian = new int[2000];
		int[] notIsRunNian = new int[2000];

		int isIndex = 0;
		int notIsIndex = 0;

		int startYear = 1;

		for (; startYear <= 2018; startYear++) {
			if (startYear % 4 == 0) {
				isRunNian[isIndex++] = startYear;
			} else {
				notIsRunNian[notIsIndex++] = startYear;
			}
		}
		System.out.print("公元1到2018闰年有：");
		printYear(isRunNian, isIndex);
		System.out.print("公元1到2018不是闰年有：");
		printYear(notIsRunNian, notIsIndex);

	}

}
