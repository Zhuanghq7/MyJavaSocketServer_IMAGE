package Zhuangh7.JFrame.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Main_WIN extends JPanel implements Runnable {

	private int winWidth,winHeight;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public Main_WIN(int width,int height){
		winWidth = width;
		winHeight = height;
		setPreferredSize(new Dimension(winWidth,winHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		
	}
}
