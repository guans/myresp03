package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * ���ౣ���˳�������ʱ��ȫ��������Ϣ��Ӧ�ó�������ʱ�ȴ������ļ����أ����ø���ľ�̬������
 * ����ʱ�������û������ã��޸���ľ�̬�������˳�ʱ����̬��Ա�������浽�����ļ��С�
 * 
 * @author �����
 * @version 0.1
 */
public class Setting {

	public Setting() {
		readTxtFile("1.txt");
	}

	/** ���������ʶ */
	public static String SERVER_ENGINE_ID = "server_engine";

	/** WEB�������ʶ */
	public static String WEB_ENGINE_ID = "web_engine";

	/** ��λ�����ʶ */
	public static String LOCATION_ENGINE_ID = "location_engine";
	public static String MAC=readTxtFile("1.txt");
	/** ��¼�û��ĵ�¼״̬ */
	public static String LOGIN_STATUS = "fail";
	/** ��¼�û��ĵ�¼ID */
	public static String USERNAME = " ";
	static	String lineTxt = null;
	public static String readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				
				while ((lineTxt = bufferedReader.readLine()) != null) {
					Setting.MAC = lineTxt;
					System.out.println(lineTxt);
					break;
				}
				//read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return lineTxt;

	}
}
