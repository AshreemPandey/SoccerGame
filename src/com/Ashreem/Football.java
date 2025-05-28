package com.Ashreem;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Football{
	
	private int[] coordinate;
	private int currPosition;
	private JLabel icon;
	private Game parent;
	
	public Football(Game p) {
		try {
			BufferedImage football=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ball.png"));
			Image dimg=football.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			icon=new JLabel(new ImageIcon(dimg));
			coordinate=new int[] {740,390};
			currPosition=coordinate[1];
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		parent=p;
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
	
	public void shoot(int value) {
		currPosition=coordinate[1]-value;
	}
	
	public void update() {
		if(coordinate[1]==currPosition) {
			return;
		}
		else if(coordinate[1]<currPosition) {
			coordinate[1]+=1;
		}
		else {
			coordinate[1]-=1;
		}
		icon.setBounds(coordinate[0],coordinate[1],40,40);
		parent.change();
	}
	
	
}
