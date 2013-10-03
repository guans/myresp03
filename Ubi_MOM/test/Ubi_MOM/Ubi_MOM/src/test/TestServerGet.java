package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import ubimessage.client.MOMClient;
import ubimessage.message.Message;
import ubimessage.message.MessageListener;

/**
 * ��Ҫ���ܣ��������˻�ȡ��Ϣ
 * 
 */

public class TestServerGet {
	// �����ƶ��˵�½��Ϣ(Ŀǰֻ�����)

	// ---------------------------------------------------------------------------------------------
	// ���㵽�ֽ�ת�� ÿ��λһ��������
	public static byte[] doubleToByte(double x, double y, double z) {
		byte[] b = new byte[24];
		long l = Double.doubleToLongBits(x);
		for (int i = 0; i < 8; i++) {
			b[i] = new Long(l).byteValue();
			l = l >> 8;

		}
		l = Double.doubleToLongBits(y);
		for (int i = 8; i < 16; i++) {
			b[i] = new Long(l).byteValue();
			l = l >> 8;

		}
		l = Double.doubleToLongBits(z);
		for (int i = 16; i < b.length; i++) {
			b[i] = new Long(l).byteValue();
			l = l >> 8;

		}
		return b;
	}

	// �ֽڵ�����ת��
	public static double[] byteToDouble(byte[] b) {
		long l[] = new long[3];
		//for (int i = 0; i < 3; i++) {
			l[0] = b[0];
			l[0] &= 0xff;
			l[0] |= ((long) b[1] << 8);
			l[0] &= 0xffff;
			l[0] |= ((long) b[2] << 16);
			l[0] &= 0xffffff;
			l[0] |= ((long) b[3] << 24);
			l[0] &= 0xffffffffl;
			l[0] |= ((long) b[4] << 32);
			l[0] &= 0xffffffffffl;
			l[0] |= ((long) b[5] << 40);
			l[0] &= 0xffffffffffffl;
			
			l[0] |= ((long) b[6] << 48);
			l[0]&=0xffffffffffffffl;
			l[0] |= ((long) b[7] << 56);

			l[1] = b[8];
			l[1] &= 0xff;
			l[1] |= ((long) b[9] << 8);
			l[1] &= 0xffff;
			l[1] |= ((long) b[10] << 16);
			l[1] &= 0xffffff;
			l[1] |= ((long) b[11] << 24);
			l[1] &= 0xffffffffl;
			l[1] |= ((long) b[12] << 32);
			l[1] &= 0xffffffffffl;
			l[1] |= ((long) b[13] << 40);
			l[1] &= 0xffffffffffffl;
			
			l[1] |= ((long) b[14] << 48);
			l[1]&=0xffffffffffffffl;
			l[1] |= ((long) b[15] << 56);

			l[2] = b[16];
			l[2] &= 0xff;
			l[2] |= ((long) b[17] << 8);
			l[2] &= 0xffff;
			l[2] |= ((long) b[18] << 16);
			l[2] &= 0xffffff;
			l[2] |= ((long) b[19] << 24);
			l[2] &= 0xffffffffl;
			l[2] |= ((long) b[20] << 32);
			l[2] &= 0xffffffffffl;
			l[2] |= ((long) b[21] << 40);
			l[2] &= 0xffffffffffffl;
			
			l[2] |= ((long) b[22] << 48);
			l[2]&=0xffffffffffffffl;
			l[2] |= ((long) b[23] << 56);
	//	}
		
		
		double d[] = new double[3];
		d[0] = Double.longBitsToDouble(l[0]);
		d[1] = Double.longBitsToDouble(l[1]);
		d[2] = Double.longBitsToDouble(l[2]);
		return d;
	}

	// ----------------------------------------------------------------------------------------------

	public static void DoLogin(Message m) throws Exception { /* �ƶ��� */
		// System.out.println("m"+m.getContent());
		byte[] newByte1 = new byte[16];
		byte[] newByte2 = new byte[16];
		// ** ����Ҫ�����鸴�Ƶ��������� *//*
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		System.arraycopy(m.getContentAsBytes(), 16, newByte2, 0, 16);
		// ** ��������ӵ������� *//*
		String id = new String(newByte1).trim();
		String key = new String(newByte2).trim();

		System.out.println("id:" + id);
		System.out.println("password:" + key);

	}

	// �����ƶ���ע����Ϣ
	public static void DoEnroll(Message m) throws Exception { /* �ƶ��� */
		// System.out.println("m"+m.getContent());
		byte[] newByte1 = new byte[16];
		byte[] newByte2 = new byte[16];
		byte[] newByte3 = new byte[32];
		// ** ����Ҫ�����鸴�Ƶ��������� *//*
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		System.arraycopy(m.getContentAsBytes(), 16, newByte2, 0, 16);
		System.arraycopy(m.getContentAsBytes(), 32, newByte3, 0, 16);
		// ** ��������ӵ������� *//*
		String id = new String(newByte1).trim();
		String key = new String(newByte2).trim();
		String email = new String(newByte3).trim();

		System.out.println("id:" + id);
		System.out.println("password:" + key);
		System.out.println("email:" + email);
	}

	// �����ƶ�������λ������Ϣ
	public static void DoLocateSelf(Message m) throws Exception { /* �ƶ��� */
		// ���ܵ��ƶ�����Ϣ��������Ϣ�������͸�����ǰ����
	}

	// �����ƶ��˻��ֵ�������Ϣ
	public static void DoFirePoint(Message m) throws Exception { /* �ƶ��� */
		// ���ܵ��ƶ�����Ϣ��������Ϣ�������͸������ֵ�����
	}

	// �����ƶ��˽������ҽ��������Ϣ
	public static void DoDocterInfo(Message m) throws Exception { /* �ƶ��� */
		// ���ܵ��ƶ�����Ϣ��������Ϣ�������͸���ҽ����Ϣ������+�绰��
	}

	// �����ƶ��˲�ѯ�ص�������Ϣ
	public static void DoSearchPoint(Message m) throws Exception { /* �ƶ��� */
		byte[] newByte1 = new byte[16];
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		String pname = new String(newByte1, "utf-8");// ����תΪ���ġ���
		System.out.println("Ҫ��ѯ�ĵ�:" + pname);
	}

	// �����ƶ��ˌ���������Ϣ
	public static void DoNavigation(Message m) throws Exception { /* �ƶ��� */
		byte[] newByte1 = new byte[16];
		byte[] newByte2 = new byte[8];
		byte[] newByte3 = new byte[16];
		byte[] newByte4 = new byte[16];
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		System.arraycopy(m.getContentAsBytes(), 16, newByte2, 0, 8);
		System.arraycopy(m.getContentAsBytes(), 24, newByte3, 0, 16);
		System.arraycopy(m.getContentAsBytes(), 40, newByte4, 0, 16);

		if (newByte2[0] == (1))
			System.out.println(("�Ϸ��ɹ�"));
		else
			System.out.println(("�Ƿ�ʧ��"));

		String splace = new String(newByte1, "utf-8");// ����תΪ���ġ���
		String eplace = new String(newByte3, "utf-8");// ����תΪ���ġ���
		String id = new String(newByte4).trim();
		System.out.println("Ҫ��ѯ�����:" + splace);
		System.out.println("Ҫ��ѯ���ص�:" + eplace);
		System.out.println("Ҫ��ѯ��id:" + id);
	}

	// �����ƶ��˲�ѯ����������Ϣ
	public static void DoSearchCoordinate(Message m) throws Exception { /* �ƶ��� */
		double x[] = byteToDouble(m.getContentAsBytes());
		System.out.println((x[0]));
		System.out.println((x[1]));
		System.out.println((x[2]));

	}

	/**
	 * �����ƶ��ͻ��˵Ľ�������·������
	 * 
	 * @param m
	 *            ����Ϣ�м���л�ȡ������Ϣ
	 */
	public static void DoEmergencyRequest(Message m) {
		byte[] receive = new byte[32];
		System.arraycopy(m.getContentAsBytes(), 0, receive, 0, 32);
		String username = new String(receive).trim();
		if (m.getHeader("status").equals("success")) {
			System.out.println("����ԱΪ��������");
		} else {
			System.out.println("����ԱΪ��ͨ����");
		}
		System.out.println("�û���Ϊ��" + username);
	}

	// ����web�˶�λ������Ϣ
	public static void DoLocateWeb(Message m) throws Exception { /* web�� */

	}

	// ����web�˵�����Ա��ѯ��Ϣ
	public static void DoSearchSingle(Message m) throws Exception { /* web�� */
		byte[] newByte1 = new byte[16];
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		String id = new String(newByte1).trim();
		System.out.println("��Ա���:" + id);

	}

	// ����web�˷�����������Ա��ѯ��Ϣ
	public static void SearchAll(Message m) throws Exception { /* web�� */

		byte[] newByte1 = new byte[16];
		System.arraycopy(m.getContentAsBytes(), 0, newByte1, 0, 16);
		String id = new String(newByte1).trim();
		System.out.println("������:" + id);
	}
	
	// ����WEB����
		public static void DoSendFireNode(Message m) throws Exception { /* web�� */

			double x[] = byteToDouble(m.getContentAsBytes());
			System.out.println((x[0]));
			System.out.println((x[1]));
			System.out.println((x[2]));
		}
		
		// ����WEB�������ֵ�
				public static void DoRemoveFireNode(Message m) throws Exception { /* web�� */

					System.out.println("�������ֵ�");
				}
	
	
	
	//��д�ļ�
	
		 public static void DOWriteTxt(String file, String txt) {
		  try {
		   FileOutputStream os = new FileOutputStream(new File(file), false);
		   os.write(txt.getBytes());
		   os.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }

	public static void main(String args[]) throws Exception {

		// create a client to receive messages asynchronously
		// Client rcpt=new Client("0.0.0.0",1234,"receiver");
		MOMClient rcpt = new MOMClient("127.0.0.1", 3009,
				Setting.SERVER_ENGINE_ID);
		// then set the MessageListener for the client
		//

		rcpt.setMessageListener(new MessageListener() {

			public void messageReceived(Message m) {
				try {
					// �޸�Setting��MAC
					if (m.getHeader("from").equals("utility")) {
						Setting.MAC = m.getSender();
						DOWriteTxt("1.txt",m.getSender());
					}
					
					// ��ȡ��Ϣͷ
					if (m.getHeader("type").equals("login")) {
						DoLogin(m);
					}
					if (m.getHeader("type").equals("enroll")) {
						DoEnroll(m);
					}
					if (m.getHeader("type").equals("navigate")) {
						DoNavigation(m);
					}
					if (m.getHeader("type").equals("locateself")) {
						System.out.println(("locate my place now"));
					}
					if (m.getHeader("type").equals("sendfirenode")) {
						DoSendFireNode(m);
					}
					if (m.getHeader("type").equals("removefirenode")) {
						DoRemoveFireNode(m);
					}

					if (m.getHeader("type").equals("searchcoordinate")) {
						DoSearchCoordinate(m);
					}
					else
						// System.out.println(m.getContentAsBytes().toString());
						System.out.println(m.getHeader("type"));
					System.out.println(m.getContent());
					System.out.println(m.getSender());
					System.out.println();

				} catch (Exception ex) {
				}
			}

			public void exceptionRaised(Exception ex) {
			}
		});
		// connect to the dispatcher
		rcpt.connect();
		//
		// wait for user input
		System.in.read(new byte[10]);
		// disconnect
		rcpt.disconnect();
	}
}