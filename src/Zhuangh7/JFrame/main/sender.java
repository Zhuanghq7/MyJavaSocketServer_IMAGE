package Zhuangh7.JFrame.main;

import java.net.Socket;

public class sender extends Thread{
	private ChatSocket s;
	public static boolean tag = true;
	
	public sender(ChatSocket s){
		this.s = s;
	}
	@Override
	public void run(){
		while(tag){
			if(!s.Size.isEmpty()){
				int size = s.Size.get(s.Size.size());
				s.Size.remove(s.Size.size());
				ChatManager.getChatManager().publish_size(s, size);
				if(!s.map.isEmpty()){
					byte[] t = s.map.get(s.map.size());
					s.map.remove(s.map.size());
					ChatManager.getChatManager().publish_byte(s, t);
					MainClass.print("转发了一张图片");
				}
			}
		}
	}
}
