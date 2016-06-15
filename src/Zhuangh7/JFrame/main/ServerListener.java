package Zhuangh7.JFrame.main;

import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;  
  
public class ServerListener extends Thread {  
	public static int Client_num = 0;
	public static int max_client = 2;
	
	@Override  
    public void run() {  
    	
        //1-65535  
        try {  
            ServerSocket serverSocket = new ServerSocket(2016);  
            while (true) {  
                //accept()���������̣߳���Ҫ��һ���µ��̴߳���  
                Socket socket = serverSocket.accept();  
                //��������  
                MainClass.print("�пͻ������ӵ��˱�����2016�˿�");  
                Client_num++;
                MainClass.print(socket.getInetAddress().toString());
                //��socket���ݸ��µ��߳�  
                ChatSocket cs = new ChatSocket(socket);  
                cs.start();  
                ChatManager.getChatManager().add(cs);  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  