import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class GameWindow extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static File answers = new File("src/answers.txt");
	static File questions = new File("src/questions.txt");
	static File explanations = new File("src/explanations.txt");
	static JTextArea questionLabel = new JTextArea();
	static JTextArea answerLabel = new JTextArea();
	
	
	static JButton answerButton1 = new JButton("");
	static JButton answerButton2 = new JButton("");
	static JButton answerButton3 = new JButton("");
	static JButton menuButton = new JButton("Menu");
	
	static ClickListener clickListener = new ClickListener();
	
	static String q, a, e, explanation;
	static JLabel optionLabel = new JLabel("New label");

	static String correctAnswer;
	static JButton newqButton = new JButton("Next Question?");
	
	
	
	public GameWindow() {
		setBackground(SystemColor.activeCaption);
		

		
		/*setGamePanel();
		
		mainPanel.add(menuPanel, MenuPangamePanel.setBackground(Color.GRAY);
		el);
		mainPanel.add(gamePanel, GamePanel);
		
		cardLayout.show(mainPanel, MenuPanel);
		cardLayout.show(mainPanel, GamePanel);
		*/
		
		
		setLayout(null);
		
		setSize(500,600);
		
		
		answerButton1.setBounds(10, 137, 480, 41);
		add(answerButton1);
		
		
		answerButton2.setBounds(10, 178, 480, 41);
		add(answerButton2);
		
		answerButton3.setBounds(10, 219, 480, 41);
		add(answerButton3);
		
		newqButton.setBounds(57, 11, 136, 23);
		add(newqButton);
		
		menuButton = new JButton("Menu");
		menuButton.setBounds(302, 11, 89, 23);
		add(menuButton);
		
		questionLabel.setWrapStyleWord(true);
		questionLabel.setBackground(SystemColor.activeCaption);
		questionLabel.setLineWrap(true);
		questionLabel.setForeground(Color.BLACK);
		questionLabel.setEditable(false);
		questionLabel.setColumns(5);
		questionLabel.setBounds(49, 45, 410, 106);
		add(questionLabel);
		
		answerLabel.setWrapStyleWord(true);
		answerLabel.setLineWrap(true);
		answerLabel.setForeground(Color.BLACK);
		answerLabel.setEditable(false);
		answerLabel.setColumns(5);
		answerLabel.setBackground(SystemColor.activeCaption);
		answerLabel.setBounds(49, 269, 410, 170);
		add(answerLabel);
		
		newqButton.addMouseListener(clickListener);
		menuButton.addMouseListener(clickListener);
		
		
		try {
			GameWindow.setGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	
	//Reads 2 text files and saves the text as lists of string lines in another list and returns it
	public static ArrayList getLists() throws IOException {
		ArrayList<String> theQuestions = new ArrayList<String>();
		ArrayList<String> theAnswers = new ArrayList<String>();
		ArrayList<String> theExplanations = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(answers));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		String string;
		while((string = bufferedReader.readLine()) != null) {
			theAnswers.add(string);
		}
		}catch(FileNotFoundException e) {
			System.out.println("Error: " + e);
		}finally {
			bufferedReader.close();
		}
		
		
		BufferedReader bufferedReader2 = new BufferedReader(new FileReader(questions));
		try {
		String string;
		while((string = bufferedReader2.readLine()) != null) {
			theQuestions.add(string);
		}
		}catch(FileNotFoundException e) {
			System.out.println("Error: " + e);
		}finally {
			bufferedReader.close();
		}
		
		BufferedReader bufferedReader3 = new BufferedReader(new FileReader(explanations));
		try {
		String string;
		while((string = bufferedReader3.readLine()) != null) {
			theExplanations.add(string);
		}
		}catch(FileNotFoundException e) {
			System.out.println("Error: " + e);
		}finally {
			bufferedReader.close();
		}
		
		ArrayList list = new ArrayList(3);
		list.add(theQuestions);
		list.add(theAnswers);
		list.add(theExplanations);
		
		return list;
		
	}
		public static ArrayList<String> getQandA() throws IOException {
			
		ArrayList list = getLists();
		
		ArrayList<String> theQuestions = (ArrayList<String>) list.get(0);
		ArrayList<String> theAnswers = (ArrayList<String>) list.get(1);	
		ArrayList<String> theExplanations = (ArrayList<String>) list.get(2);	
			
		Random r = new Random();
		String again = "Y";
		String in;
		
			
		int random = r.nextInt((int) theAnswers.size());
		String question = theQuestions.get(random);
		String answer = theAnswers.get(random);
		String explanation = theExplanations.get(random);
		
		ArrayList<String> QandA = new ArrayList<String>();
		QandA.add(question);
		QandA.add(answer);
		QandA.add(explanation);
		
		return QandA;
		
		}
		
		public static String[] getAnswerOptions() throws IOException{
			System.out.println("newQuestion() called");
		
				ArrayList<String> QandA = getQandA();
				q = QandA.get(0);
				a = QandA.get(1);
				e = QandA.get(2);
				
				System.out.println("");
				
				
				String[] answerOptions1 = a.split(";");
				String[] answerOptions = new String[4];
				answerOptions[0] = answerOptions1[0];
				answerOptions[1] = answerOptions1[1];
				answerOptions[2] = answerOptions1[2];
				answerOptions[3] = e;
				
				GameWindow.answerLabel.setText("");
				GameWindow.questionLabel.setText(q);
			
				return answerOptions;
			
		}
		
		
		
		public static String rightAnswer(String[] answerOptions) throws IOException{
			
			String correctAnswer = "";
			
			for(String answer : answerOptions) {
				if(answer.contains("*")) {
					answer = answer.replace("*", "");
					correctAnswer = answer;
					
				}
			}
			return correctAnswer;
		}
		
		public static void setGame() throws IOException {
			
			newqButton.setVisible(false);
			
			answerButton1.setBackground(null);
			answerButton2.setBackground(null);
			answerButton3.setBackground(null);
			
			String[] answerOptions = getAnswerOptions();
			
			correctAnswer = rightAnswer(answerOptions);
			
			int i = 0;
			for(String answer : answerOptions) {
				if(answer.contains("*")) {
					answerOptions[i] = answer.replace("*", "");
				}
				i++;
			}
			
			
			for(int z = 0; z < 3; z++) {
				if(answerOptions[z].length() > 85) {
					answerOptions[z] = stringToNextLine(answerOptions[z]);
				}
			}
			
			
			
			Random random = new Random();
			int r = random.nextInt(2) ;
			
			explanation = answerOptions[3];
			
			GameWindow.answerButton1.setText(answerOptions[r]);
			
			
			
			
			if(answerButton1.getText().toString() == answerOptions[0]) {
				answerButton2.setText(answerOptions[1]);
				answerButton3.setText(answerOptions[2]);
			}
			
			if(answerButton1.getText().toString() == answerOptions[1]) {
				answerButton2.setText(answerOptions[0]);
				answerButton3.setText(answerOptions[2]);
			}
			
			if(answerButton1.getText().toString() == answerOptions[2]) {
				answerButton2.setText(answerOptions[1]);
				answerButton3.setText(answerOptions[0]);
			}
			
			answerButton1.addMouseListener(clickListener);
			
			answerButton2.addMouseListener(clickListener);
			
			answerButton3.addMouseListener(clickListener);
		
		}
		
		public static String getExplanation(String[] answerOptions) {
			String explanation = answerOptions[3];
			return explanation;
		}
		
		public static String stringToNextLine(String word) {
			ArrayList<String> list= new ArrayList<String>();
			String[] sublist = word.split("");
			
			
			for(String letter: sublist) {
				list.add(letter);
			}
			
			word = "";
			list.add(0, "<html>");
			list.add(list.size(), "</html>");
			
			
			for(String particle : list) {
				word += particle;
			}
			
			return word;
		}
}

		
	
		
	

	

