package com.Ashreem;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game {
	
	public Game() {
		JFrame frame=new JFrame("Soccer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1700,1500);
		
		JPanel myPanel=new JPanel();
		myPanel.setLayout(null);
		myPanel.setBackground(Color.BLACK);
		try {
			BufferedImage player1Pic=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ron.png"));
			Image dplayer = player1Pic.getScaledInstance(60,80,Image.SCALE_SMOOTH);
			BufferedImage player2Pic=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\mess.png"));
			Image dplayer2 = player2Pic.getScaledInstance(60,80,Image.SCALE_SMOOTH);
			ArrayList<JLabel> team1=new ArrayList<JLabel>();
			ArrayList<JLabel> team2=new ArrayList<JLabel>();
			for(int i=0;i<4;i++) {
				team1.add(new JLabel(new ImageIcon(dplayer)));
				team1.get(i).setBounds(570+i*150,420,60,80);
				team2.add(new JLabel(new ImageIcon(dplayer2)));
				team2.get(i).setBounds(570+i*150,280,60,80);
				myPanel.add(team1.get(i));
				myPanel.add(team2.get(i));
			}
			
			team1.get(3).setBounds(720,590,60,80);
			team2.get(3).setBounds(720,50,60,80);
			BufferedImage footballPic=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ball.png"));
			Image dimg = footballPic.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			JLabel football=new JLabel(new ImageIcon(dimg));
			football.setBounds(740,390,40,40);
			myPanel.add(football);
			
			BufferedImage goalPost1=ImageIO.read(new File("C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\Soccer\\\\assets\\post1.png"));
			JLabel post1=new JLabel(new ImageIcon(goalPost1));
			post1.setBounds(560,-160,400,400);
			myPanel.add(post1);
			
			BufferedImage goalPost2=ImageIO.read(new File("C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\Soccer\\\\assets\\post2.png"));
			JLabel post2=new JLabel(new ImageIcon(goalPost2));
			post2.setBounds(560,530,400,400);
			myPanel.add(post2);
			
			BufferedImage stadPic=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ground.png"));
			JLabel stadium=new JLabel(new ImageIcon(stadPic));
			stadium.setBounds(10,10,1500,800);
			myPanel.add(stadium);
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		frame.add(myPanel);
		frame.setVisible(true);
	}
	
	public void startGame() {
		
	}
}
