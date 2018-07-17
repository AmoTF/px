package w2018_7_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IdentityCard {

	private static StringBuffer isIdCard = new StringBuffer("");
	private static StringBuffer notIsIdCard = new StringBuffer("");

	public static void dqFIle(String filePath) {

		BufferedReader br = null;

		StringBuffer idCardStr = new StringBuffer();
		try {
			System.out.println("开始！");
			System.out.println("读取源文件！");
			br = new BufferedReader(new FileReader(filePath));
			System.out.println("读取源文件结束！");
			String idCard = null;
			while ((idCard = br.readLine()) != null) {
				matchIDCard(idCard);
			}
			exportFile(notIsIdCard.toString(), "notIsIdCard");
			exportFile(isIdCard.toString(), "isIdCard");
			//exportExecl(notIsIdCard.toString(), "notIsIdCard");
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			System.out.println("结束！");
		}
	}

	public static void matchIDCard(String idCard) {

		String pattern = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)"
				+ "\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";

		boolean isMatch = Pattern.matches(pattern, idCard);
		if (isMatch) {
			isIdCard.append(idCard + "\r\n");
		} else {
			notIsIdCard.append(idCard + "\r\n");
		}
		
	}

	public static void exportFile(String idCardContent, String fileName) {
		File file = new File("E:/work/培训资料/java作业/" + fileName + ".xls");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		Writer out = null;
		try {
			out = new FileWriter(file);
			System.out.println("开始导出文件！");
			System.out.println("导出文件路径：" + file.getPath());
			out.write(idCardContent);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			System.out.println("导出文件结束！");
		}

	}
	
	public static void exportExecl(String idCardContent, String fileName) {
		File file = new File("E:/work/培训资料/java作业/" + fileName + ".xls");
		
		FileOutputStream fileoutputStream=null;
        Workbook workbook = new XSSFWorkbook();
		try {
			System.out.println("开始导出文件！");
			System.out.println("导出文件路径：" + file.getPath());
	        fileoutputStream = new FileOutputStream(file);
	        workbook.write(fileoutputStream);
	        fileoutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileoutputStream != null) {
				try {
					fileoutputStream.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			System.out.println("导出文件结束！");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dqFIle("E:/work/培训资料/java作业/身份证号码.txt");
	}

}
