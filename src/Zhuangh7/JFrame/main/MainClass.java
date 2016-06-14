package Zhuangh7.JFrame.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainClass {
	private static final String TITLE = "Socket_DEMO";
	public static final int WIN_WIDTH = 400;
	public static final int WIN_HEIGHT = 700;
	public static int Tag = 0;
	//public static Main_WIN mainWin;
	static Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	static JPanel p1 = new JPanel();
	static JPanel p2 = new JPanel();
	static JPanel p3 = new JPanel();
	static ArrayList<JLabel> label = new ArrayList<JLabel>();
	private static int Str_NUM = 15;
	/*static JLabel label1 = new JLabel("1");
	static JLabel label2 = new JLabel("2");*/
	//static JTextField tf = new JTextField();
	static JButton b = new JButton("connect");
	static JLabel t;
	private static JFrame Win;
	
	public static void main(String[] args){
		Win = new JFrame(TITLE);
		Win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		Win.setLocation((width-WIN_WIDTH)/2, (height-WIN_HEIGHT)/2);
		Win.setResizable(true);
		//mainWin = new Main_WIN(WIN_WIDTH,WIN_HEIGHT);
		//Win.add(mainWin);
		Win.setLayout(new BorderLayout());
		initLabel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		for(int i = 0;i<Str_NUM;i++){
			p1.add(label.get(i));
		}
	//	p1.add(tf);
		Win.add(p1,BorderLayout.NORTH);
		p2.add(b,BorderLayout.CENTER);
		t = new JLabel("LISTENING");
		p3.add(t,BorderLayout.CENTER);
		t.setForeground(Color.GRAY);
		Win.add(p2,BorderLayout.CENTER);
		Win.add(p3, BorderLayout.SOUTH);
		Win.pack();
		Win.setSize(200,400);
		Win.setVisible(true);
		
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			//	String str = tf.getText();
				run();
			}
		});
		//mainWin.requestFocus();
	}
	public static void print(String str){
		label.get(Tag).setText(str);
		Tag++;
		if(Tag>=Str_NUM){
			Tag = 0;
		}
	}
	public static void run(){
		b.setEnabled(false);
		t.setForeground(Color.RED);
		new ServerListener().start();
	}
	
	public static void initLabel(){
		for(int i = 0;i<Str_NUM;i++){
			JLabel temp = new JLabel(""+(i+1));
			label.add(temp);
		}
	}
}
