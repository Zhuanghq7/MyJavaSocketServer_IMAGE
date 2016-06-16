package Zhuangh7.JFrame.main;

import java.net.Socket;

public class sender extends Thread{
	private ChatSocket s;
	public  boolean tag = true;
	
	public sender(ChatSocket s){
		this.s = s;
	}
	@Override
	public void run(){
		//this.setPriority(7);
		while(tag){
			//MainClass.print(""+s.Size.size());
			if(!s.Size.isEmpty()){
				int size = s.Size.get(0);
				s.Size.remove(0);
				ChatManager.getChatManager().publish_size(s, size);
				//while(!s.map.isEmpty()){
				byte[] t = s.map.get(0);
				s.map.remove(0);
				ChatManager.getChatManager().publish_byte(s, t);
				MainClass.print("转发了一张图片"+s.Size.size());
				//}
			}
			if(s.Size.size()>=20){	
					s.Size.clear();
					s.map.clear();
			}
			else{
				s.receive = true;
				//s.socket.getInputStream();
			}
		}
	}
}
