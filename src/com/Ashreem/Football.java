package com.Ashreem;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Football {
	private int Power;
	private int[] coordinate;
	private JLabel icon;
	
	public Football() {
		try {
			BufferedImage football=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ball.png"));
			Image dimg=football.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			icon=new JLabel(new ImageIcon(dimg));
			coordinate=new int[] {100,100};
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(int x, int y) {
		coordinate[0]=x;
		coordinate[1]=y;
	}
	
	public JLabel getFootball() {
		return icon;
	}
}
