import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ClickListener implements MouseListener {
	
	static int rightAnswers = 0;
	static int wrongAnswers = 0;
	
	public ClickListener() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
		
		

	@Override
	public void mouseEntered(MouseEvent e) {
		
		Object source = e.getSource();
		
		if(source.equals(GameWindow.answerButton1))
		GameWindow.answerButton1.setBackground(Color.ORANGE);
		if(source.equals(GameWindow.answerButton2))
		GameWindow.answerButton2.setBackground(Color.ORANGE);
		if(source.equals(GameWindow.answerButton3))
		GameWindow.answerButton3.setBackground(Color.ORANGE);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
		if(GameWindow.answerButton1.getBackground().equals(Color.ORANGE)
			|| GameWindow.answerButton2.getBackground().equals(Color.ORANGE)
			|| GameWindow.answerButton3.getBackground().equals(Color.ORANGE)) {
			GameWindow.answerButton1.setBackground(null);
			GameWindow.answerButton2.setBackground(null);
			GameWindow.answerButton3.setBackground(null);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		String answer;
		
		Object source = e.getSource();
		if(source.equals(GameWindow.answerButton1)) {
			answer = GameWindow.answerButton1.getText();
			if(answer.equals(GameWindow.correctAnswer)) {
				GameWindow.answerLabel.setText("Correct answer. " +GameWindow.explanation);
				GameWindow.answerButton1.setBackground(Color.GREEN);
				GameWindow.newqButton.setVisible(true);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				rightAnswers++;
			}else {
				GameWindow.answerLabel.setText("Right answer: " +  GameWindow.correctAnswer
						+ ". " +GameWindow.explanation);
				GameWindow.answerButton1.setBackground(Color.RED);
				GameWindow.newqButton.setVisible(true);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				wrongAnswers++;
			}
		}
		if(source.equals(GameWindow.answerButton2)) {
			answer = GameWindow.answerButton2.getText();
			if(answer.equals(GameWindow.correctAnswer)) {
				GameWindow.answerLabel.setText("Correct answer. " +GameWindow.explanation);
				GameWindow.answerButton2.setBackground(Color.GREEN);
				GameWindow.newqButton.setVisible(true);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				rightAnswers++;
			}else {
				GameWindow.answerLabel.setText("Right answer: " +  GameWindow.correctAnswer
						+ ". " +GameWindow.explanation);
				GameWindow.answerButton2.setBackground(Color.RED);
				GameWindow.newqButton.setVisible(true);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				wrongAnswers++;
			}
		}
		if(source.equals(GameWindow.answerButton3)) {
			answer = GameWindow.answerButton3.getText();
			if(answer.equals(GameWindow.correctAnswer)) {
				GameWindow.answerButton3.setBackground(Color.GREEN);
				GameWindow.answerLabel.setText("Correct answer. " +GameWindow.explanation);
				GameWindow.newqButton.setVisible(true);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				rightAnswers++;
			}else {
				GameWindow.answerLabel.setText("Right answer: " +  GameWindow.correctAnswer
						+ ". " +GameWindow.explanation);
				GameWindow.answerButton3.setBackground(Color.RED);
				GameWindow.answerButton1.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton2.removeMouseListener(GameWindow.clickListener);
				GameWindow.answerButton3.removeMouseListener(GameWindow.clickListener);
				
				wrongAnswers++;
				
				GameWindow.newqButton.setVisible(true);
			}
		}
		
		if(source.equals(GameWindow.newqButton)) {
			try {
				GameWindow.setGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(source.equals(GameWindow.menuButton))
			Main.cardlayout.show(Main.frame.getContentPane(), "menu panel");
		
		
		if(source.equals(MenuWindow.statsButton)) {
		
			MenuWindow.statsLabel.setText("Right answers : " + ClickListener.rightAnswers);
			MenuWindow.statsLabel2.setText("Wrong answers : " + ClickListener.wrongAnswers);
		}
		
		if(source.equals(MenuWindow.startButton)) {
			Main.cardlayout.show(Main.frame.getContentPane(), "game panel");
		}
		
		
	}

	
			
			
		
	

	
	
}
