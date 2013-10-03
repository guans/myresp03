package ubimessage.dispatcher;

import java.io.IOException;
import java.util.ArrayList;

import ubimessage.message.Message;

public class MessageParser {
	private Message msg;
	private static String SP = "|";
	private static String SP1 = ":";
	public MessageParser(Message msg) {
		this.msg = msg;
	}
	
	//topic="monitor"����ؿͻ��˷�������б�ʱ����������ص�Ŀ��ͻ����б�
	public  ArrayList<String>  parserMonitoredClient(){
		String content;
		//�ͻ����б�
		ArrayList<String> clientList = new ArrayList<String>();
		try {
			//��Ϣ������
			content = (String)msg.getContent();
			//�ͻ����б�
			String []clients = content.split("\\"+SP);
			//��һ��ӿͻ���
			for(int i=1;i<clients.length;i++) {
				clientList.add(clients[i].trim());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientList;
	}
	
	/*//topic="coordinate"�������������͵���Ϣʱ���������ͻ���ID
	public String parserClient(){
		String content = null;
		String clientID = null;
		//content = (String)msg.getContent();
		 clientID = msg.getRecipient();
		//��ȡmac
		//String mac = content.split(SP)[1];
		return clientID;
	}*/
}
