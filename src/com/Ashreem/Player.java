package com.Ashreem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player implements KeyListener{
	
	private int[] coordinate;
	private JLabel icon;
	private Game parent;
	private boolean current;
	private HashSet<Integer> keysPressed;
	private int Team;
	
	public Player(Game parent,String a, int team) {
		try {
			this.parent=parent;
			BufferedImage image=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\"+a+".png"));
			Image player = image.getScaledInstance(60,80,Image.SCALE_SMOOTH);
			icon=new JLabel(new ImageIcon(player));
			coordinate=new int[]{300,300};
			Team=team;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		current=false;
		keysPressed=new HashSet<Integer>();
	}
	public void setCoordinates(int x, int y) {
		coordinate[0]=x;
		coordinate[1]=y;
	}
	public JLabel getPlayer() {
		return icon;
	}
	public int[] getCoordinates() {
		return coordinate;
	}
	public void setCurrent() {
		current=true;
	}
	public boolean getCurrent() {
		return current;
	}
	public void removeCurrent() {
		current=false;
	}
	public void update() {
		for(int keyPressed:keysPressed) {
			if(Team==1&&current) {
				if(keyPressed==KeyEvent.VK_UP) {
					coordinate[1]-=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_LEFT) {
					coordinate[0]-=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_DOWN) {
					coordinate[1]+=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_RIGHT) {
					coordinate[0]+=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				
			}
			if(Team==2&&current) {
				if(keyPressed==KeyEvent.VK_W) {
					coordinate[1]-=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_A) {
					coordinate[0]-=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_S) {
					coordinate[1]+=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
				if(keyPressed==KeyEvent.VK_D) {
					coordinate[0]+=1;
					icon.setBounds(coordinate[0],coordinate[1],60,80);
					parent.change();
				}
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		keysPressed.add(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e) {
		keysPressed.remove(e.getKeyCode());
	}
	public void keyTyped(KeyEvent e) {
		if(current&&Team==1&&e.getKeyChar()=='u'&&(coordinate[1]-parent.getFootball().getCoordinate()[1])<5) {
			parent.getFootball().shoot(50);
		}
		if(current&&Team==2&&e.getKeyChar()=='r'&&(parent.getFootball().getCoordinate()[1]-coordinate[1])<60&&(parent.getFootball().getCoordinate()[1]-coordinate[1])>50) {
			parent.getFootball().shoot(-50);
		}
	}

}
