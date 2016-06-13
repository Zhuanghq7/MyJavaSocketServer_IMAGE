package Zhuangh7.JFrame.main;

import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
import javax.swing.JOptionPane;  
  
public class ServerListener extends Thread {  
  
    @Override  
    public void run() {  
        //1-65535  
        try {  
            ServerSocket serverSocket = new ServerSocket(12345);  
            while (true) {  
                //accept()会阻塞主线程，故要开一个新的线程处理  
                Socket socket = serverSocket.accept();  
                //建立连接  
                MainClass.print("有客户端链接到了本机的12345端口");  
                //将socket传递给新的线程  
                ChatSocket cs = new ChatSocket(socket);  
                cs.start();  
                ChatManager.getChatManager().add(cs);  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  