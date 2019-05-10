//Justin Cai, jc5pz
//Emerson Berlik, elb5esn
//Ayush Mayur, am3nz
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
	JLabel instructions;
	JButton submit;
	JTextArea enterArea;

	JLabel livesRemaining;
	JLabel lettersEntered;
	JLabel wordOutput;


	boolean[] lettersCorrect = {false, false, false, false, false};
	int lives;
	String password;
	ArrayList<String> letters;

	public static void main(String[] args) {
		new GUILLOfFortune();
	}

	public GUILLOfFortune()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);

		password = "super";
		lives = 5;
		letters = new ArrayList<String>();

		instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>" );
		submit = new JButton("ENTER");
		enterArea = new JTextArea();
		livesRemaining = new JLabel("Lives: " + lives);
		lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
		wordOutput = new JLabel("_ _ _ _ _");
		wordOutput.setFont(new Font("Times", Font.BOLD, 20));

		instructions.setSize(23*width/60, height/6);
		submit.setSize(width/3, 50);
		enterArea.setSize(width/3, 50);
		livesRemaining.setSize(width/4, height/12);
		lettersEntered.setSize(width/3, height/3);
		wordOutput.setSize(width/2, height/6);

		instructions.setLocation(width/15, 1);
		submit.setLocation(width/2, height/2);
		enterArea.setLocation(width/6, height/2);
		livesRemaining.setLocation(11*width/15, 1);
		lettersEntered.setLocation(17*width/30, height/20);
		wordOutput.setLocation(width/3, height/3);

		submit.addActionListener(new passwordButtonListener());

		this.add(instructions);
		this.add(submit);
		this.add(enterArea);
		this.add(livesRemaining);
		this.add(lettersEntered);
		this.add(wordOutput);

		this.add(new JLabel());
		this.setLocationRelativeTo(null);
		setVisible(true);
	}

	private class passwordButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = "" + enterArea.getText().charAt(0);
			enterArea.setText("");

			if(!letters.contains(s)) {
				letters.add(s);
				if(password.contains(s)) {
					lettersCorrect[password.indexOf(s)] = true;
					String temp = wordOutput.getText().substring(0, password.indexOf(s) * 2) + s + 
							wordOutput.getText().substring(password.indexOf(s) * 2 + 1);
					wordOutput.setText(temp);

				}
				else {
					lives--;
					livesRemaining.setText("" + lives);
					if(lives == 0) {
						System.out.println("You have lost.");
						System.exit(0);
					}

				}
				String temp = "";
				for(String j: letters) {
					temp += j + " ";
				}
				lettersEntered.setText(temp);
				boolean done = true;
				for(boolean x : lettersCorrect) {
					if(!x) {
						done = false;
						break;
					}
				}
				if(done) {
					System.out.println("You have won.");
					System.exit(0);
				}

			}
			// TODO: Implement the action taken by the button.
		}
	}
}