package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import test.Node;

import ubimessage.client.MOMClient;
import ubimessage.message.Message;

/**
 * ��Ҫ���ܣ��ƶ��˷�����Ϣ
 * 
 */
public class TestUtilitySend {
	public static void main(String args[]) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ

		// create a client to send messages
		// Client sender=new Client("192.168.1.135",3009,"sender");
		Setting.MAC = "abc123";
		MOMClient sender = new MOMClient("192.168.1.104", 3009, Setting.MAC);
		// then connect it to the dispatcher
		sender.connect();
		Thread.sleep(3000);
		// now send multiple messages to receiver with different contents

		Message m;
		sender.sendMessage(Enroll("asdfhkj", "8347fd", "34838435@qq.com"));
		sender.sendMessage(LogIn("admin", "123"));
		sender.sendMessage(LogIn("boy", "231"));
		sender.sendMessage(LogIn("shifsao", "34234"));
		sender.sendMessage(LogIn("asdfhkj", "8347fd"));
		sender.sendMessage(Navigation("�̶�¥", true, "����", "dfsgdfgsdf"));
		sender.sendMessage(LocateSelf());
		sender.sendMessage(SearchCoordinate(1.11,845.6545,84659.485));

		// disconnect from the publisher
		sender.disconnect();
	}

	// ----------------------------------------------------------------------------------------------------
	// ��½
	public static Message LogIn(String id, String password) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "32");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "login");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[32];
		id.getBytes(0, id.length(), content, 0);
		password.getBytes(0, password.length(), content, 16);
		t.setContentAsBytes(content);
		// m.setContent("Message "+x);
		return t;
	}

	// ע��
	public static Message Enroll(String id, String password, String email)
			throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "64");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "enroll");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[64];
		id.getBytes(0, id.length(), content, 0);
		password.getBytes(0, password.length(), content, 16);
		email.getBytes(0, email.length(), content, 32);
		t.setContentAsBytes(content);
		return t;

	}

	// ����λ
	public static Message LocateSelf() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "16");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "locateself");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[16];

		return t;
	}

	// ���ֵ���Ϣ
	public static Message FirePoint(String firp) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "16");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "firepoint");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[16];
		for (int i = 0; i < firp.getBytes().length; i++) {
			content[i] = firp.getBytes()[i];
		}
		return t;
	}

	// Ӧ�������ҽ������
	public static Message DocterInfo(String doc) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "16");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "docterinfo");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[16];
		for (int i = 0; i < doc.getBytes().length; i++) {
			content[i] = doc.getBytes()[i];
		}

		return t;
	}

	// ��ѯ�ص�
	public static Message SearchPoint(String pname) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "16");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "searchpoint");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[16];
		for (int i = 0; i < pname.getBytes().length; i++) {
			content[i] = pname.getBytes()[i];
		}
		t.setContentAsBytes(content);
		return t;
	}

	// ��ѯ����
	public static Message SearchCoordinate(double x, double y, double z)
			throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "24");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "searchcoordinate");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[24];
		content = doubleToByte(x, y, z);
		t.setContentAsBytes(content);

		return t;

	}

	// ����
	public static Message Navigation(String splace, boolean islogin,
			String eplace, String id) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Message t = new Message();
		t.setRecipient(Setting.SERVER_ENGINE_ID);
		t.setSender(Setting.MAC);
		// ��Ϣͷ
		t.setHeader("length", "56");
		t.setHeader("timeid", df.format(new Date()));
		t.setHeader("type", "navigate");
		t.setHeader("from", "utility");
		t.setHeader("to", "server");
		// ��Ϣ
		byte[] content = new byte[16 + 8 + 16 + 16];
		for (int i = 0; i < splace.getBytes().length; i++) {
			content[i] = splace.getBytes()[i];
		}
		content[16] = (byte) (islogin ? 0x01 : 0x00);
		for (int i = 0; i < eplace.getBytes().length; i++) {
			content[24 + i] = eplace.getBytes()[i];
		}

		id.getBytes(0, id.length(), content, 16 + 8 + 16);
		t.setContentAsBytes(content);
		return t;

	}

	/**
	 * ����״���µĵ���·������
	 * 
	 * @return ���úõ���Ϣ
	 */
	public static Message EmergencyRequest(String username) {
		Message message = new Message();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ��������
		// ������Ϣͷ
		message.setHeader("length", "16");
		message.setHeader("timeid", df.format(new Date()));
		message.setHeader("type", "emergency");
		message.setHeader("from", "utility");
		message.setHeader("to", "server");
		message.setHeader("status", Setting.LOGIN_STATUS);
		byte[] content = new byte[32];
		username.getBytes(0, username.length(), content, 0);
		message.setContentAsBytes(content);

		return message;
	}

	// ----------------------------------------------------------------------------------------------------
	// �ڵ���
	public static class Node {
		/**
		 * number �������
		 */
		int number;

		/**
		 * type �������
		 */
		int type;

		/**
		 * coor_x ���x����
		 */
		double coor_x;

		/**
		 * coor_y ���y����
		 */
		double coor_y;

		/**
		 * coor_z ���z����
		 */
		double coor_z;

		/**
		 * weight �洢����Ȩ��
		 */
		double weight;

		/**
		 * next �����ڽӽ��
		 */
		Node next = null;

		public Node(double a, double b, double c) {

			coor_x = a;
			coor_y = b;
			coor_z = c;
		}

		Node(Node p) {
			coor_x = p.coor_x;
			coor_y = p.coor_y;
			coor_z = p.coor_z;
		}
	}

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
		for (int i = 16; i < 24; i++) {
			b[i] = new Long(l).byteValue();
			l = l >> 8;

		}
		return b;
	}

	// �ֽڵ�����ת��
	public static double[] byteToDouble(byte[] b) {
		long l[] = new long[3];
		for (int i = 0; i < 3; i++) {
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
			l[0] &= 0xffffffffffffffl;
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
			l[1] &= 0xffffffffffffffl;
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
			l[2] &= 0xffffffffffffffl;
			l[2] |= ((long) b[23] << 56);
		}

		double d[] = new double[3];
		d[0] = Double.longBitsToDouble(l[0]);
		d[1] = Double.longBitsToDouble(l[1]);
		d[2] = Double.longBitsToDouble(l[2]);
		return d;
	}

	// ���㵽�ֽ�ת��(���)
	public static byte[] doubleToByteSome(Node points[], int num) {

		byte b[] = new byte[24 * num];
		for (int i = 0; i < num; i++) {

			// byte[] b = new byte[24];
			long l = Double.doubleToLongBits(points[i].coor_x);
			for (int j = 0; j < 8; j++) {
				b[24 * i + j] = new Long(l).byteValue();
				l = l >> 8;
			}
			l = Double.doubleToLongBits(points[i].coor_y);
			for (int j = 8; j < 16; j++) {
				b[24 * i + j] = new Long(l).byteValue();
				l = l >> 8;

			}
			l = Double.doubleToLongBits(points[i].coor_z);
			for (int j = 16; j < 24; j++) {
				b[24 * i + j] = new Long(l).byteValue();
				l = l >> 8;
			}

		}
		return b;
	}

	// �ֽڵ�����ת������㣩
	public static Node[] byteToDoubleSome(byte[] b, int num) {
		Node nodes[] = new Node[num];
		for (int i = 0; i < num; i++) {

			long l[] = new long[3];
			for (int j = 0; j < 3; j++) {
				l[0] = b[24 * i + 0];
				l[0] &= 0xff;
				l[0] |= ((long) b[24 * i + 1] << 8);
				l[0] &= 0xffff;
				l[0] |= ((long) b[24 * i + 2] << 16);
				l[0] &= 0xffffff;
				l[0] |= ((long) b[24 * i + 3] << 24);
				l[0] &= 0xffffffffl;
				l[0] |= ((long) b[24 * i + 4] << 32);
				l[0] &= 0xffffffffffl;

				l[0] |= ((long) b[24 * i + 5] << 40);
				l[0] &= 0xffffffffffffl;
				l[0] |= ((long) b[24 * i + 6] << 48);
				l[0]&=0xffffffffffffffl;
				l[0] |= ((long) b[24 * i + 7] << 56);

				l[1] = b[24 * i + 8];
				l[1] &= 0xff;
				l[1] |= ((long) b[24 * i + 9] << 8);
				l[1] &= 0xffff;
				l[1] |= ((long) b[24 * i + 10] << 16);
				l[1] &= 0xffffff;
				l[1] |= ((long) b[24 * i + 11] << 24);
				l[1] &= 0xffffffffl;
				l[1] |= ((long) b[24 * i + 12] << 32);
				l[1] &= 0xffffffffffl;

				l[1] |= ((long) b[24 * i + 13] << 40);
				l[1] &= 0xffffffffffffl;
				l[1] |= ((long) b[24 * i + 14] << 48);
				l[1]&=0xffffffffffffffl;
				l[1] |= ((long) b[24 * i + 15] << 56);

				l[2] = b[24 * i + 16];
				l[2] &= 0xff;
				l[2] |= ((long) b[24 * i + 17] << 8);
				l[2] &= 0xffff;
				l[2] |= ((long) b[24 * i + 18] << 16);
				l[2] &= 0xffffff;
				l[2] |= ((long) b[24 * i + 19] << 24);
				l[2] &= 0xffffffffl;
				l[2] |= ((long) b[24 * i + 20] << 32);
				l[2] &= 0xffffffffffl;

				l[2] |= ((long) b[24 * i + 21] << 40);
				l[2] &= 0xffffffffffffl;
				l[2] |= ((long) b[24 * i + 22] << 48);
				l[2]&=0xffffffffffffffl;
				l[2] |= ((long) b[24 * i + 23] << 56);
			}

			nodes[i] = new Node(Double.longBitsToDouble(l[0]),
					Double.longBitsToDouble(l[1]),
					Double.longBitsToDouble(l[2]));
			/*
			 * nodes[i].coor_x=Double.longBitsToDouble(l[0]);
			 * nodes[i].coor_y=Double.longBitsToDouble(l[1]);
			 * nodes[i].coor_z=Double.longBitsToDouble(l[2]);
			 */

			/*
			 * double d[] = new double[3]; d[0] = Double.longBitsToDouble(l[0]);
			 * d[1] = Double.longBitsToDouble(l[1]); d[2] =
			 * Double.longBitsToDouble(l[2]);
			 */

		}
		return nodes;
	}

}