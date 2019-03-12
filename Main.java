import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class Main extends JFrame{
	
	/*
	 * Jäin toppama GameWindow ning ClickListeneri juures, kus oli vaja vahetada Game Menüü vastu,
	 * aga Game komponendid jäävad alles ning Menüü komponente ei tule asemele
	 * PS. ei suuda muuta JButtonite taustavärvi
	 */
	
	
	static JFrame frame = new JFrame("QuizMe");
	
	static CardLayout cardlayout = new CardLayout();

	
	public static void main(String[] args) throws IOException  {
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setLocation(450,150);
		frame.setLayout(cardlayout);
		frame.setResizable(false);
		frame.requestFocusInWindow();
		frame.getContentPane().add(new MenuWindow(), "menu panel");
		frame.getContentPane().add(new GameWindow(), "game panel");
		cardlayout.show(frame.getContentPane(), "menu panel");
		frame.addMouseListener(new ClickListener());
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	
	
	}

