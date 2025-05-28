package com.Ashreem;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class Game {
	
	JPanel myPanel=new JPanel();
	ArrayList<Player> team1;
	ArrayList<Player> team2;
	Football football;
	
	public Game() {
		JFrame frame=new JFrame("Soccer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1700,1500);
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		myPanel.setBackground(Color.GRAY);
		myPanel.setFocusable(true);
        myPanel.requestFocusInWindow();
        myPanel.addKeyListener(new Listener());
		try {
			team1=new ArrayList<Player>();
			team2=new ArrayList<Player>();
			for(int i=0;i<4;i++) {
				team1.add(new Player(this,"Ron",1));
				team1.get(i).setCoordinates(570+i*150,420);
				team1.get(i).getPlayer().setBounds(570+i*150,420,60,80);
				
				team2.add(new Player(this,"Mess",2));
				team2.get(i).setCoordinates(570+i*150,280);
				team2.get(i).getPlayer().setBounds(570+i*150,280,60,80);
				
				myPanel.addKeyListener(team1.get(i));
				myPanel.add(team1.get(i).getPlayer());
	
				myPanel.addKeyListener(team2.get(i));
				myPanel.add(team2.get(i).getPlayer());
				
				myPanel.setComponentZOrder(team1.get(i).getPlayer(), i);
				myPanel.setComponentZOrder(team2.get(i).getPlayer(),i);
			}
			
			team1.get(3).getPlayer().setBounds(720,590,60,80);
			team1.get(3).setCoordinates(720, 590);
			team2.get(3).getPlayer().setBounds(720,50,60,80);
			team2.get(3).setCoordinates(720, 50);
			team1.get(1).setCurrent();
			team2.get(1).setCurrent();
			
			football=new Football(this);
			football.getFootball().setBounds(740,390,40,40);
			football.setCoordinate(740, 390);
			
			myPanel.add(football.getFootball());
			myPanel.setComponentZOrder(football.getFootball(), 8);
			
			BufferedImage goalPost1=ImageIO.read(new File("C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\Soccer\\\\assets\\post1.png"));
			JLabel post1=new JLabel(new ImageIcon(goalPost1));
			post1.setBounds(560,-160,400,400);
			
			myPanel.add(post1);
			myPanel.setComponentZOrder(post1, 9);
			
			BufferedImage goalPost2=ImageIO.read(new File("C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\Soccer\\\\assets\\post2.png"));
			JLabel post2=new JLabel(new ImageIcon(goalPost2));
			post2.setBounds(560,530,400,400);
			myPanel.add(post2);
			myPanel.setComponentZOrder(post2, 10);
			
			BufferedImage stadPic=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\ground.png"));
			JLabel stadium=new JLabel(new ImageIcon(stadPic));
			stadium.setBounds(10,10,1500,800);
			myPanel.add(stadium);
			myPanel.setComponentZOrder(stadium,11);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		frame.add(myPanel);
		frame.setVisible(true);
		
		startGame();
	}
	
	public void startGame() {
		try {
			BufferedImage threeImg=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\3.png"));
			BufferedImage twoImg=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\2.png"));
			BufferedImage oneImg=ImageIO.read(new File("C:\\Users\\ASUS\\eclipse-workspace\\Soccer\\assets\\1.png"));
			JLabel three=new JLabel(new ImageIcon(threeImg));
			three.setBounds(700,350,150,130);
			
			myPanel.add(three);
			myPanel.setComponentZOrder(three, 5);
			myPanel.repaint();
			Thread.sleep(1000);
			
			three.setIcon(new ImageIcon(twoImg));
			myPanel.repaint();
			Thread.sleep(1000);

			three.setIcon(new ImageIcon(oneImg));
			myPanel.repaint();
			Thread.sleep(1000);
			File audioFile = new File("C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\Soccer\\\\assets\\\\whistle.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
			myPanel.remove(three);
			
            clip.start();
			
			myPanel.repaint();
			
			while(true) {
				callRepeatedly();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Football getFootball() {
		return football;
	}

	
	public void callRepeatedly() {
		try {
			Thread.sleep(50);
			for(Player p:team1) {
				p.update();
			}
			for(Player p:team2) {
				p.update();
			}
			football.update();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void change() {
		myPanel.repaint();
	}
	
	public class Listener implements KeyListener{

		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()=='q') {
				for(int i=0;i<team2.size();i++) {
					if(team2.get(i).getCurrent()==true) {
						team2.get(i).removeCurrent();
						team2.get((i+1)%team2.size()).setCurrent();
						break;
					}
				}
			}
			if(e.getKeyChar()=='/') {
				for(int i=0;i<team1.size();i++) {
					if(team1.get(i).getCurrent()==true) {
						team1.get(i).removeCurrent();
						team1.get((i+1)%team1.size()).setCurrent();
						break;
					}
				}
			}
		}
		

		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			
		}
		
	}
}
