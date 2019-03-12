import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class MenuWindow extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton startButton = new JButton("Let's go");
	static JButton statsButton = new JButton("Statistics");
	static JLabel statsLabel = new JLabel("");
	static JLabel statsLabel2 = new JLabel("");
	
	static ClickListener clickListener = new ClickListener();
	
	public MenuWindow() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		startButton = new JButton("Let's go");
		
		
		startButton.setBounds(186, 73, 89, 23);
		add(startButton);
		
		statsButton.setBounds(186, 120, 89, 23);
		add(statsButton);
		
		statsLabel.setBounds(186, 168, 241, 14);
		add(statsLabel);
		
		statsLabel2.setBounds(186, 193, 241, 14);
		add(statsLabel2);
		
		startButton.addMouseListener(clickListener);
		statsButton.addMouseListener(clickListener);
		
		
	}
}
